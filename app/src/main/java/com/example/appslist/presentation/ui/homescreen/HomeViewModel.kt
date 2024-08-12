package com.example.appslist.presentation.ui.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.repository.AppsRepository
import com.example.shareddata.model.appsList.AppInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: AppsRepository) : ViewModel() {
    init {
        Log.d("HomeViewModel", "init")
    }

    val listAppApps: StateFlow<List<AppInfo>> = flow {
        val list = userRepository.getApps()?.responses?.listApps?.datasets?.all?.data?.list.orEmpty()
        emit(list)
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}
