package com.example.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Nota::class],
    version =  1
)
abstract class NotaDB:RoomDatabase(){
    abstract fun notaDAO():NotaDAO
}