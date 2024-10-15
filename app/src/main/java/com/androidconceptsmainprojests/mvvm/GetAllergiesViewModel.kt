package com.androidconceptsmainprojests.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class GetAllergiesViewModel @Inject constructor(private val repo: GetAllergiesRepo) : ViewModel() {
    var mutableData = MutableLiveData<List<Allergies>>()

    init {
        getAllergies()
    }

    private fun getAllergies() {
        viewModelScope.launch {
            val result = repo.getAllApiRepo()
            mutableData.value = result
        }
    }
}