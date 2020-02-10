package com.languagexx.simplenotes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.languagexx.simplenotes.persistence.Note
import com.languagexx.simplenotes.repository.NoteRepository
import com.languagexx.simplenotes.util.Resource
import javax.inject.Inject

class NoteViewModel @Inject constructor(
    val noteRepository: NoteRepository
) : ViewModel() {



    //Database Operations in view model





    fun insert(note: Note) {
        return noteRepository.insert(note)
    }

    fun delete(note: Note) {
        noteRepository.delete(note)
    }

    fun deleteById(id:Int){
        noteRepository.deleteById(id)
    }

    fun update(note: Note) {
        noteRepository.update(note)
    }

    fun getAllNotes(): LiveData<Resource<List<Note>>> {
        return noteRepository.getAllNotes()
    }


}