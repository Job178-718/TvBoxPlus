package com.example.tv

import android.app.Application
import com.example.tv.osc.p2p.P2PClass
import com.example.tv.osc.util.FileUtils
import com.example.tv.osc.util.LOG
import com.orhanobut.hawk.Hawk

class App:Application() {

    private var app:Application? = null

    private var dashData: String = ""

    override fun onCreate() {
        super.onCreate()
        app = this
        initHawk()
    }

    private fun initHawk() {
        Hawk.init(this).build()
    }

    companion object{
        @JvmStatic
        lateinit var app:App

        var p: P2PClass? = null

        @JvmStatic
        fun getInstance():App{
            return app
        }

        @JvmStatic
        fun getp2p(): P2PClass? {
            try {
                if (p == null) {
                    p = P2PClass(FileUtils.getExternalCachePath())
                }
                return p
            } catch (e: Exception) {
                LOG.e(e.toString())
                return null
            }
        }
    }

    fun setDashData(data: String) {
        dashData = data
    }

    fun getDashData(): String {
        return dashData
    }
}