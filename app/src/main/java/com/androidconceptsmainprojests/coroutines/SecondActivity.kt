package com.androidconceptsmainprojests.coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidconceptsmainprojests.databinding.ActivitySecoendBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecoendBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecoendBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}