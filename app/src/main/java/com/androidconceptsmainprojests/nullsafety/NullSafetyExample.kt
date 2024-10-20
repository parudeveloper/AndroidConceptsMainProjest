package com.androidconceptsmainprojests.nullsafety

fun main() {
    // By default kotlin variables are non null variables

    var age :Int = 10 // By default we need to initialize and declare variable
    var name: String? = "Mallangi" // same here we need to initialize


    //if we want to assign nullable variable we need to use safe call operator .?
    var name1:String? = null // ? Safe call Operator
    println(name1?.length) // if we don't  know weather variable is null or not so by using safe call operator we will avoid other wise we will get null pointer exception
    println(name)

    /*-------------------------------------------------------------------------------------------------------------------------------------------------*/

    //Elvis Operator  ?:
    /*
    * If variable is having null but still we want to assign default implementation we will use elvis operator
    * */

    val schoolName : String? = null
    // here we know schoolName is null but still we want to give default implementation by using Elvis Operator ?: we can achieve
    var sname = schoolName ?: "Default Implementation"
    println(sname)


    /*-------------------------------------------------------------------------------------------------------------------------------------------------*/

    // Assertion Operator !!

    /*
    * if we are sure that variable is not null then only we will use this operator other wise
    * */

    val name2 : String? =null

    val length1 = name2?.length

    println(length1)

   // val length2 = name2!!.length // we will get NullPointerException why because it is null

    try {
        val length2 = name2!!.length // Throws NullPointerException
    } catch (e: NullPointerException) {
        println("Caught an exception: $e")
    }




}
