package com.languagexx.simplenotes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.languagexx.simplenotes.persistence.NoteDao
import com.languagexx.simplenotes.persistence.Note
import com.languagexx.simplenotes.util.Resource
import kotlinx.coroutines.*
import javax.inject.Inject

class NoteRepository @Inject constructor(val noteDao: NoteDao) {

    //function to insert note in database
    fun insert(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.insert(note)
        }
    }

    //function to delete note in database
    fun delete(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.delete(note)
        }
    }

    //function to delete note by Id in database
    fun deleteById(id:Int){
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.deleteById(id)
        }
    }

    //function to update note in database
    fun update(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.update(note)
        }
    }

    //function to get all notes in database
    fun getAllNotes(): LiveData<Resource<List<Note>>> = liveData {

        //Loading
        emit(Resource.loading())

        //Find Data
        if (noteDao.getAllNotes().size < 0) {
            emit(Resource.error("No Notes Found"))
        } else
            emit(Resource.success(noteDao.getAllNotes()))
        }
}