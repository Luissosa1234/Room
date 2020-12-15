package com.example.room

import android.app.Application
import androidx.room.Room

class NotaApp:Application() {
    lateinit var db:NotaDB

    override fun onCreate() {
        super.onCreate()
        db = Room
            .databaseBuilder(this, NotaDB::class.java, "NotaDB")
            .build()
    }


}