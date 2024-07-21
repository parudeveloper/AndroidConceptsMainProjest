package com.androidconceptsmainprojests.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    init {
        Log.i("ZZZ","View Model Created ")
        viewModelScopeExample()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ZZZ","View Model Cleared ")
    }

    private fun viewModelScopeExample(){
        viewModelScope.launch(Dispatchers.IO) {
            for (i in 1..100){
                delay(1000)
                Log.i("ViewModelScope_ZZZ","${i+1}")
            }

        }

    }
}