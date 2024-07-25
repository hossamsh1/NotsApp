package com.example.notsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Note::class], version = 1 , exportSchema = false)
abstract class RoomDBHelper:RoomDatabase() {

    abstract val dao :NoteDao

    companion object{
        @Volatile  // all threads have immediate access to this variable
        private var INSTANCE:RoomDBHelper? = null

        fun getInstance(c:Context):RoomDBHelper{
            return INSTANCE ?: synchronized(this){
                val instance= Room
                    .databaseBuilder(c,RoomDBHelper::class.java,"myDB")
                    .build()

                    INSTANCE = instance
                   return instance
            }
        }
    }
}