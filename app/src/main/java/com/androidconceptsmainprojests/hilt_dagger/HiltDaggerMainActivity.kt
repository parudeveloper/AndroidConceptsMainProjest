package com.androidconceptsmainprojests.hilt_dagger

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.androidconceptsmainprojests.R
import com.androidconceptsmainprojests.databinding.ActivityHiltDaggerMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
* Dependant ==== Dependency
* Car(This is Dependent) == Engine Tyres  (These are Dependency)
* Car Dependent on Dependencies
*
*
* */
@AndroidEntryPoint // If we want to inject we need to use this annotation
class HiltDaggerMainActivity : AppCompatActivity() {

    // This is Acting like Dependency
    // We are creating one object in our entire application
    // objStudent Refers to the object which we create in AppModule
    @Inject
    lateinit var objStudent: Student

    private lateinit var binding: ActivityHiltDaggerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltDaggerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // objStudent = Student()


        if (this::objStudent.isInitialized){
            // Using Hilt DI we are Using Student Object in this class
            binding.tvTextHiltDiText.text = objStudent.getStudentName()
        }else{
            binding.tvTextHiltDiText.text = "Object is not isInitialized"
        }

        // if we want to access class methods we need to create object and using that object we need to access
        // if we want access in multiple classes we needed to create multiple Object
        // Note : Object Creation is Very Expensive in our Project
        // This is HardCoded Code
         val student = Student() // It is acting like Dependency
         binding.tvTextView.text = " Normal Calling ${student.getStudentName()}"






    }
}