package com.example.tv

import android.app.Application
import android.util.Log
import com.example.tv.bean.HawkConfig
import com.orhanobut.hawk.Hawk

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        initHawk()
    }

    private fun initHawk() {
        Hawk.init(this).build()
    }
}