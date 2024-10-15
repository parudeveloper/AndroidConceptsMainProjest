package com.androidconceptsmainprojests.mvvm

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.androidconceptsmainprojests.R
import com.androidconceptsmainprojests.databinding.ActivityMainBinding
import com.androidconceptsmainprojests.databinding.ActivityMvvmactivityBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Response
@AndroidEntryPoint
class MVVMActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvvmactivityBinding
    val alleriesVM: GetAllergiesViewModel by viewModels()


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        alleriesVM.mutableData.observe(this) {
            binding.tvData.text = "Response : ${it}"
            Log.i("MVVMActivity",it.toString())
        }
    }
}