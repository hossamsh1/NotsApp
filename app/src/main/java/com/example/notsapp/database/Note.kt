package com.example.notsapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
class Note (
    @PrimaryKey(true)
    @ColumnInfo(name= "_id")
    val id : Int =0,
    @ColumnInfo(name ="note_details")
    val noteDetails:String,
    @ColumnInfo(name ="note_Title")
    val noteTitle:String
)
