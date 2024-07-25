package com.example.notsapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Upsert
   suspend fun upsertNote(n: Note)  // suspend function is used to run a coroutine

    @Delete
   suspend fun deleteNote(n:Note)

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>
}