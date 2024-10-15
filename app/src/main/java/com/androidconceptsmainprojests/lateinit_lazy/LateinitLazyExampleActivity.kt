package com.androidconceptsmainprojests.lateinit_lazy

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.androidconceptsmainprojests.R
import com.androidconceptsmainprojests.databinding.ActivityLateinitLazyExampleBinding
import java.util.Formatter.BigDecimalLayoutForm

/* Ref Link : https://medium.com/huawei-developers/kotlin-lateinit-vs-by-lazy-initialization-example-tutorial-c19d84216480

*  Late init is an modifier in kotlin
* by default if we create an variable we need to declare then and there only
* We may not want to initialize our values at declaration time
*
* late init means we are telling to the compiler, we will use that late init variable later point of time
* late init should be declare with var
* late init' modifier is not allowed on properties of primitive types
* by using isInitialized we will check weather late init variable is initialized or not
*
* if we create like this --- for example if we not using that variable JVM will not allocate memory for that variable
* */

/*
* lazy --> If we access for the first time then only it will create the object after that it will reuse that value again and again
* This can be particularly useful for performance optimization
*
* */
class LateinitLazyExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLateinitLazyExampleBinding

    val user : User by lazy {
        Log.e("LateinitLazyExampleActivity", "First time lazy initialization")
        User("Mallangi")

    }
// here declaration of lazy
    // if access for the 1st time then only it will create object
    private val myUser: User by lazy {
        print("Lazy initialization")
        User("Hüseyin")
    }

    lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLateinitLazyExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //lateinitExample()
        lazyInitializationExample()


    }

    fun lateinitExample() {

        var a: String = "This is normal variable" // here we need to initialize the value
        lateinit var total: String // if we use late init modifier we no need to initialize the value
        // if we haven't initialize we will get this error late init property total has not been initialized

        // here we are going to initialize the value
        total = "We are declaring the late init variable"

        // by using isInitialized we will check weather late init variable is initialized or not
        if (::name.isInitialized) {
            Log.e("LateinitLazyExampleActivity", name.hashCode().toString())
        } else {
            Log.e("LateinitLazyExampleActivity", "Not Initialized")

        }
        Log.e("LateinitLazyExampleActivity", a)
    }

    fun lazyInitializationExample() {
        binding.tvClickHere.setOnClickListener() {
            Log.e("LateinitLazyExampleActivity", user.name)
        }

    }
}
data class User(var name :String)