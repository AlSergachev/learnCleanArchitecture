package com.example.learncleanarchitecture.app

import android.app.Application
import com.example.learncleanarchitecture.di.AppComponent
import com.example.learncleanarchitecture.di.AppModule
import com.example.learncleanarchitecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}