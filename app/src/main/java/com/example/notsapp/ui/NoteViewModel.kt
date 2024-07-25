package com.example.notsapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notsapp.database.Note
import com.example.notsapp.database.RoomDBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel (App:Application): AndroidViewModel(App){

    val db =RoomDBHelper.getInstance(App)

     fun upseretNote(n:Note){
         viewModelScope.launch(Dispatchers.IO){
        db.dao.upsertNote(n)
         }
    }

     fun deleteNote(n:Note){
         viewModelScope.launch(Dispatchers.IO) {
             db.dao.deleteNote(n)
         }
    }

    fun getNotes()= db.dao.getAllNotes()

}