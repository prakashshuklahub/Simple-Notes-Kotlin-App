package com.languagexx.simplenotes.persistence

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// - Database Class
@Database(entities = arrayOf(Note::class),version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}