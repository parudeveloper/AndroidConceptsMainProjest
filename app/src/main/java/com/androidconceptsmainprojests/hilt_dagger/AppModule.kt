package com.androidconceptsmainprojests.hilt_dagger

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // This line is to make our AppModule as SingleTon
object AppModule {

    @Provides
    @Singleton
    fun provideStudent(): Student = Student() // Dependency
}