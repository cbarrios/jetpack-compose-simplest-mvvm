package com.lalosapps.simplestmvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var state by mutableStateOf(0)
        private set

    fun onIncrementCounter() {
        state += 1
    }
}