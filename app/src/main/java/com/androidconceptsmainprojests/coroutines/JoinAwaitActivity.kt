package com.androidconceptsmainprojests.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.androidconceptsmainprojests.R
import com.androidconceptsmainprojests.databinding.ActivityJoinAwaitBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*Launch == > Fire and Forgot                  Async == > it will perform task and it will return result
         == > launch does not return anything         == > Async will return the result of the coroutine
         == > This is Sequential Execution            == > This is Parallel Execution


* Join & Await
* Join == > Uses in "Launch" Builder
*  ==== > Join Will Return Unit
*  ==== > Using Join == > It will wait till another coroutine executes
* Await == > Uses in "Async" Builder
*  ===  > Await will return Deferrable Object means it will return last statement of the block
*
*
* */
class JoinAwaitActivity : AppCompatActivity() {
    var a = 0
    var b = 0
    lateinit var job1: Job
    lateinit var job2: Job
    lateinit var binding: ActivityJoinAwaitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinAwaitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //joinWithLaunchExample()
        binding.btnJoin.setOnClickListener() {
            joinWithLaunchExample()
        }

        binding.btnAwait.setOnClickListener() {
            awaitWithAsyncExample()
        }

    }

    private fun joinWithLaunchExample() {
        job1 = lifecycleScope.launch(Dispatchers.IO) {
            delay(3000)
            a = 10
        }

        job2 = lifecycleScope.launch(Dispatchers.IO) {
            delay(3000)
            b = 10
        }

        lifecycleScope.launch(Dispatchers.IO) {
            Log.i("ZZZ", "Before Await Calling ")
            job1.join() // it will wait till the another function execution
            job2.join()
            val result = a + b
            Log.i("ZZZ", "This is Sum of Two Numbers $result")
        }


    }

    private fun awaitWithAsyncExample() {
        val result1 = lifecycleScope.async(Dispatchers.IO) {
            delay(5000)
            Log.i("ZZZ", "Block 1 Work Completed")
            10
        }

        val result2 = lifecycleScope.async(Dispatchers.IO) {
            delay(4000)
            Log.i("ZZZ", "Block 2 Work Completed")
            12
        }
        lifecycleScope.async(Dispatchers.IO) {
            Log.i("ZZZ", "Start of the Result Block")
            val sum = result1.await() + result2.await()
            Log.i("ZZZ", "This is Sum of Two Numbers $sum")
        }
    }
}

