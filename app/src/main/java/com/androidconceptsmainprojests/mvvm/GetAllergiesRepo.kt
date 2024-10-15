package com.androidconceptsmainprojests.mvvm

import javax.inject.Inject

class GetAllergiesRepo @Inject constructor(private val apis: Apis) {
    suspend fun getAllApiRepo() = apis.getAllergies()


}