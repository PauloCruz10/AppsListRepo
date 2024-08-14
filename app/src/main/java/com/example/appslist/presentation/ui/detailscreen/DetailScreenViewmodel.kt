package com.example.appslist.presentation.ui.detailscreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appslist.common.formatSize
import com.example.appslist.common.getFormattedDate
import com.example.appslist.model.ApplicationDetails
import com.example.network.repository.AppsRepository
import com.example.shareddata.common.Resource
import com.example.shareddata.model.appsList.AppInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewmodel @Inject constructor(savedStateHandle: SavedStateHandle, private val userRepository: AppsRepository) : ViewModel() {
    val name by lazy { savedStateHandle.get<String>("name").orEmpty() }
    private val appId by lazy { savedStateHandle.get<Long>("id") ?: -1L }

    init {
        Log.d("DetailScreenViewmodel", "init")
        loadApp(appId)
    }

    private val _currentApp = MutableStateFlow<Resource<ApplicationDetails>>(Resource.Loading())
    val currentApp = _currentApp.asStateFlow()

    fun loadApp(appId: Long = this.appId) {
        viewModelScope.launch(Dispatchers.IO) {
            _currentApp.emit(Resource.Loading())
            _currentApp.emit(handleResult(userRepository.getAppById(appId)))
        }
    }

    private fun handleResult(info: Resource<AppInfo>): Resource<ApplicationDetails> {
        return when (info) {
            is Resource.Success -> Resource.Success(info.data.toApplicationDetails())
            is Resource.Failure -> Resource.Failure()
            is Resource.Loading -> Resource.Loading()
        }
    }

    private fun AppInfo.toAppDetailItem(): List<AppDetailItem> {
        return listOf(
            AppDetailItem(size.toString().formatSize(), AppDetailType.SIZE),
            AppDetailItem(downloads.toString(), AppDetailType.DOWNLOAD),
            AppDetailItem(updated.orEmpty().getFormattedDate(), AppDetailType.LAST_UPDATED),
            AppDetailItem(rating.orEmpty(), AppDetailType.RATING),
        )
    }

    private fun AppInfo.toApplicationDetails(): ApplicationDetails {
        Log.d("toApplicationDetails", "app=$this")
        return ApplicationDetails(name.orEmpty(), graphic.orEmpty(), this.toAppDetailItem())
    }
}

data class AppDetailItem(val detailedInfo: String, val type: AppDetailType)

enum class AppDetailType {
    SIZE,
    DOWNLOAD,
    LAST_UPDATED,
    RATING,
}