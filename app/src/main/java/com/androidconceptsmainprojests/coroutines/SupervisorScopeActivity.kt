package com.androidconceptsmainprojests.coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidconceptsmainprojests.databinding.ActivitySupervisorScopeBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlin.coroutines.CoroutineContext

class SupervisorScopeActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySupervisorScopeBinding
    lateinit var task1Job: Job
    lateinit var task2Job: Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupervisorScopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancelCorotine.setOnClickListener() {
            //If we want to cancel the coroutine we can able to cancel
            // By Using Job we can able to monitor the Coroutine
            task2Job.cancel()
        }

        binding.btnStartDownloading.setOnClickListener() {
            doingTaskInBackGround()
        }
    }

    private fun doingTaskInBackGround() {
        // This is our Own Exception Handling Using "CoroutineExceptionHandler"
        val myException = CoroutineExceptionHandler { a, exception ->

        }
        /*
        * We need to create CoroutineContext
        * Which is having 3 params
        *  1 . Thread
        *  2 . Job()
        *  3 . Our Exception
     * */

        val myContext: CoroutineContext = Dispatchers.Main + Job() + myException
        val myScope = CoroutineScope(myContext)
        myScope.launch {
            /*
            *Imagine you have a task that involves multiple subtasks,
            *  and you want to handle errors in such a way that if one subtask fails,
            *  it doesn't affect the others or the main task. This is where "SupervisorScope"
            *  comes into play in coroutine-based programming.
            *
            * SupervisorScope ensures that failures in children don't affect the parent
            * */
            supervisorScope {
                task1Job = launch {
                    for (i in 1..100) {
                        delay(500)
                        binding.tvTask1.text = "Image 1 Downloading Status is $i"
                        if (i == 20) {
                            throw Exception("Data not Found")
                        }
                    }

                }

                task2Job = launch {
                    for (i in 1..100) {
                        delay(500)
                        binding.tvTask2.text = "Image 2 Downloading Status is $i"
                    }
                }
            }

        }
    }
}