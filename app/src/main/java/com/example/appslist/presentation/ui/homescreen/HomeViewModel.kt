package com.example.appslist.presentation.ui.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shareddata.repository.AppsRepository
import com.example.shareddata.common.Resource
import com.example.shareddata.model.appsList.AppInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: AppsRepository) : ViewModel() {
    private val _listAppApps = MutableStateFlow<Resource<List<AppInfo>>>(Resource.Loading())
    val listAppApps = _listAppApps.asStateFlow()

    init {
        Log.d("HomeViewModel", "init")
        viewModelScope.launch(Dispatchers.Default) {
            userRepository.loadApps()
        }

        viewModelScope.launch(Dispatchers.Default) {
           userRepository.getApps().collect {
               _listAppApps.emit(it)
           }
        }
    }

    fun loadApps() {
        viewModelScope.launch(Dispatchers.Default) {
            userRepository.loadApps()
        }
    }

    val highlights: StateFlow<Resource<List<AppInfo>>> = _listAppApps.map {
        if (it is Resource.Success) {
            Resource.Success(it.data.dropLast(5))
        } else it
    }.stateIn(viewModelScope, SharingStarted.Lazily, Resource.Loading())

    private fun handleResult(info: Resource<List<AppInfo>>): Resource<List<AppInfo>> {
        return when (info) {
            is Resource.Success -> Resource.Success(info.data)
            is Resource.Failure -> Resource.Failure()
            is Resource.Loading -> Resource.Loading()
        }
    }
}
