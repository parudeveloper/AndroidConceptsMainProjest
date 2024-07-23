package com.androidconceptsmainprojests.hilt_dagger

import javax.inject.Inject

class Student @Inject constructor(){
    fun getStudentName() : String = "This is Student Function"
}