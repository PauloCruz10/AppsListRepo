package com.example.appslist.presentation.ui.detailscreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appslist.model.ApplicationDetails
import com.example.network.repository.AppsRepository
import com.example.shareddata.model.appsList.AppInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewmodel @Inject constructor(savedStateHandle: SavedStateHandle, private val userRepository: AppsRepository) : ViewModel() {
    init {
        Log.d("DetailScreenViewmodel", "init")
    }

    private val appFlow = savedStateHandle.getStateFlow<Long?>("id", null).map { appId ->
        Log.d("DetailScreenViewmodel", "id=$appId")
        if (appId != null) {
            userRepository.getApps()?.responses?.listApps?.datasets?.all?.data?.list?.firstOrNull { it.id == appId}?.toApplicationDetails()
        } else {
            null
        }
    }

    val currentApp = appFlow.map { app ->
        Log.d("DetailScreenViewmodel", "app=$app")
        app
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)
}

fun AppInfo.toApplicationDetails() = ApplicationDetails(
    name.orEmpty(),
    size.toString(),
    downloads.toString(),
    updated.toString(),
    rating.toString(),
    graphic.orEmpty()
)