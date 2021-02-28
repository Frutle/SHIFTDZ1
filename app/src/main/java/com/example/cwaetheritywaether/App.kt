package com.example.cwaetheritywaether

import android.app.Application
import com.example.cwaetheritywaether.data.townRepository

class App : Application() {

    lateinit var townRepository: townRepository

    override fun onCreate() {
        super.onCreate()
        townRepository = townRepository()
    }
}