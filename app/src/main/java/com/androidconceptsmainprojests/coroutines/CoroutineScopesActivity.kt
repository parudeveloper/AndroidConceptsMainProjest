package com.androidconceptsmainprojests.coroutines

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.androidconceptsmainprojests.databinding.ActivityCoroutineScopesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
* Coroutine Scopes
* ===> Global Scope
* ===> Lifecycle Scope
* ===> ViewModel Scope
*
* */
class CoroutineScopesActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoroutineScopesBinding
    lateinit var job: Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineScopesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStartActivity.setOnClickListener() {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
        binding.btnCancel.setOnClickListener(){
            job.cancel()
        }
        //globalScopeExample()
        //lifeCycleScopeExample()
        //viewModelScopeExample()
        //coroutineScopeExample()
        coroutineWithJob()


    }

    // Global Scope Example ==> Till Application exists
    // if we navigate to Second activity also this scope will execute in the background till complete the work
    // once u kill the application from background then only this scope will destroy
    private fun globalScopeExample() {
        GlobalScope.launch(Dispatchers.IO) {
            for (i in 1..100) {
                delay(500)
                Log.i("GlobalScope_ZZZ", "$i")
            }
        }
    }

    // LifeCycle Scope ==> It will exists till lifecycle of the activity
    // if we navigate to another activity it will destroy why because it will exists till that activity only
    // In real time we are not supposed to run network operations y because
    // in screen orientation changes activity will destroy and again it will recreate
    // in this case we have another scope that is ViewModel Scope
    private fun lifeCycleScopeExample() {
        lifecycleScope.launch(Dispatchers.IO) {
            for (i in 1..100) {
                delay(1000)
                withContext(Dispatchers.Main) {
                    binding.tvRunMainThread.text = "${i + 1}"
                }
                Log.i("lifecycleScope-ZZZ", "$i")
            }
        }
    }


    // ViewModelScope
    // It will Surview  in the Screen Orientation Changes
    private fun viewModelScopeExample() {
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

    }

    // This is Coroutine Scope which is nothing but our Custom Scope we can create our Custom scope
    private fun coroutineScopeExample() {
        // Like this we can able to create our custom scope
        // If we mention this in lifecycle it will exists till activity exists
        // if we mention in Viewmodel it will behave like viewmodel scope
        val myCustomScope = CoroutineScope(Job() + Dispatchers.IO)
        myCustomScope.launch {

            // we can perform any kind of operations as usual
        }
    }



    private fun coroutineWithJob() {
        /*
        * we have one more feature here
        * Like if we want to cancel coroutine we can able to cancel the coroutine using JOB (like shown in below)
        * Case Study : Example if we arw downloading multiple images but in between we want to cancel we can able to cancel
        * */
        job = lifecycleScope.launch {
            for (i in 1..100) {
                delay(1000)
                Log.i("ZZZ", "$i")
            }
        }
    }
}