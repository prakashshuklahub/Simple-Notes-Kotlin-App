package com.languagexx.simplenotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.languagexx.simplenotes.dao.NoteDao
import com.languagexx.simplenotes.entity.Note


//Database Class
@Database(entities = arrayOf(Note::class),version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao():NoteDao

    companion object{
        var instance:NoteDatabase? = null
        fun getDatabase(context:Context):NoteDatabase?{
            if (instance==null){
                instance = Room.databaseBuilder(context.applicationContext,NoteDatabase::class.java,
                    "note_database").build()
            }
            return instance
        }
    }





}