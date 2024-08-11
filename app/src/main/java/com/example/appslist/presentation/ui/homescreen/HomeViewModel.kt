package com.example.appslist.presentation.ui.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.util.Logger
import com.example.appslist.ListApp
import com.example.network.repository.AppsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: AppsRepository) : ViewModel() {
    init {
        Log.d("HomeViewModel", "init")
        load()
    }

    fun load() {
        Log.d("HomeViewModel", "load")
        viewModelScope.launch(Dispatchers.IO) {
            val dude = userRepository.getApps()
            Log.d("HomeViewModel", "dude=$dude")
        }
    }
}
