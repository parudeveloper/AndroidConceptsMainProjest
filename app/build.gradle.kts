plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //kotlin("kapt") // Apply the kotlin-kapt plugin

    /*id("com.google.dagger.hilt.android") version "2.44"
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.0"*/


}

android {
    namespace = "com.androidconceptsmainprojests"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.androidconceptsmainprojests"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")


    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation ("androidx.work:work-runtime-ktx:2.7.0")
    implementation ("com.google.android.gms:play-services-maps:18.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")


    implementation ("androidx.room:room-ktx:2.3.0")
    //kapt "androidx.room:room-compiler:$room_version"
    //kapt ("com.google.dagger:hilt-android-compiler:2.44")


    // The Kotlin ones

    implementation ("androidx.navigation:navigation-fragment-ktx:2.2.1")
    implementation ("androidx.navigation:navigation-ui-ktx:2.2.1")

    //Hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    //kapt ("com.google.dagger:hilt-android-compiler:2.44")

    implementation ("androidx.activity:activity-ktx:1.6.1")
    implementation ("androidx.fragment:fragment-ktx:1.3.6")
}