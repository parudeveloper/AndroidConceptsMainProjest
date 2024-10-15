package com.androidconceptsmainprojests.mvvm

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {

    @Provides
    fun getSingleton() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://mytutorings.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideApiService(retrofit: Retrofit): Apis {
        return retrofit.create(Apis::class.java)
    }
}