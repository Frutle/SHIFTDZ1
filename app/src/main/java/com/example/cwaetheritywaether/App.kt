package com.example.cwaetheritywaether

import android.app.Application
import com.example.cwaetheritywaether.data.TownRepository

class App : Application() {

    lateinit var TownRepository: TownRepository

    override fun onCreate() {
        super.onCreate()
        TownRepository = TownRepository()
    }
}