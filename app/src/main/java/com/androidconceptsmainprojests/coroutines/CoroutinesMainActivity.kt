package com.androidconceptsmainprojests.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.androidconceptsmainprojests.R
import com.androidconceptsmainprojests.databinding.ActivityCoroutinesMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
* Coroutines are light weight thread it will consume less CPU
* Coroutine Builders -- >
*      1.runBlocking
*      2.Async
*      3.launch
* Coroutine Scope -->
*     1. Global Scope (Application Level)
*     2. LifeCycle Scope (Activity or Fragment level )
*     3. ViewModel Scope (It will Exits till Viewmodel Life)
* Coroutine Dispatchers -->
*     1.Main  (UI Operations)
*     2.IO (Network or DB)
*     3.Default (Complex Operations or Mathematical Expressions or Json Parsing)
*
* Launch and Async
*  --> Launch >>>>> If we have any single time operation after that we are no more using this then we can able to use this
*                   Just like Fire and forgot
*                   if we want to execute tasks in Sequential Manner we will use Launch
* ---> Async >>>>>>>>> If we have number of tasks and we want to execute parallel then we will use async
*
*Exception Handling >>>> (Try catch and CoroutineExceptionHandler)
* With Context >>> It is a Suspend Function
*           if we want to move any thing to main thread we will use withContext
*
* Suspend Function >>>> Pause and Resume (Pause and resume the process of execution )
*
* */
class CoroutinesMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoroutinesMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        * we have 1 Main Thread (UI Thread)
        * Long Running Operations Like DB Operations and Network Operations and File Downloading
        * =====> We have thread concept in Android (to do long running operations)
        * =====> Don't do any UI operations on Thread
        * =====> If we want to Update any thing on Main UI we need to Use runOnUIThread
        */


        /*
        * Coroutine is Lightweight thread we can create number of coroutines
        *
        * */

        // Simple Example One
        GlobalScope.launch(Dispatchers.IO) {
            // If we want to update anything on  Main Thread we will use "WithContext"
            withContext(Dispatchers.Main) {
                binding.tvText.text = "Updating through Coroutines" // Move Code to UI Thread
            }
        }

        binding.btnLaunchBuilder.setOnClickListener() {
            GlobalScope.launch(Dispatchers.IO) {
                /* This is Launch Coroutine Builder (It will Execute in Sequential Manner)
                * it will execute One by one */
                task1()

            }

            GlobalScope.launch(Dispatchers.IO) {
                /* This is Launch Coroutine Builder (It will Execute in Sequential Manner)
                * it will execute One by one */

                task2()
            }


        }

        binding.btnAsyncBuilder.setOnClickListener() {
            GlobalScope.async(Dispatchers.IO) {
                task3()
            }

            GlobalScope.async(Dispatchers.IO) {
                task4()
            }
        }


    }
}

suspend fun task1() {
    for (i in 0..20) {
        delay(500)
        Log.i("ZZZ", " Task 1 $i")
    }
}

suspend fun task2() {
    for (i in 20..40) {
        delay(1000)
        Log.i("ZZZ", " Task 2 $i")
    }
}

suspend fun task3() {
    for (i in 0..20) {
        delay(1500)
        Log.i("ZZZ", " Task 3 $i")
    }
}

suspend fun task4() {
    for (i in 20..40) {
        delay(1000)
        Log.i("ZZZ", " Task 4 $i")
    }
}