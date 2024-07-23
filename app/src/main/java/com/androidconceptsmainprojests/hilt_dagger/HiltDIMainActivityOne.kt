package com.androidconceptsmainprojests.hilt_dagger

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.androidconceptsmainprojests.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltDIMainActivityOne : AppCompatActivity() {
    @Inject
    lateinit var student: Student

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt_dimain_one)
        textView = findViewById(R.id.tvTextHiltDiText)
        //student = Student()
        Log.i("ObjReference","${student.hashCode()}")
        val studentName = student.getStudentName()
        textView.text = "$studentName"

    }
}