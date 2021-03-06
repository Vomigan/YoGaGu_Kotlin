package com.example.yogagu

import android.app.Application
import androidx.room.Room

class App : Application() {
    var database: MyDatabase? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder<MyDatabase>(this, MyDatabase::class.java, "database")
                .build()
    }

    companion object {
        var instance: App? = null
    }
}