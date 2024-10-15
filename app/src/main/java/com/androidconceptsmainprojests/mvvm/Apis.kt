package com.androidconceptsmainprojests.mvvm

import retrofit2.http.GET

interface Apis {
    @GET("AffectioningProject/getAllergies.php")
    suspend fun getAllergies() : List<Allergies>
}