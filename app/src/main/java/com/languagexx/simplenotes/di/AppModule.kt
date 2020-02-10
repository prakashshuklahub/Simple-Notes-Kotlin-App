package com.languagexx.simplenotes.di

import android.app.Application
import androidx.room.Room
import com.languagexx.simplenotes.persistence.NoteDao
import com.languagexx.simplenotes.persistence.NoteDatabase
import com.languagexx.simplenotes.repository.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun providesAppDatabase(app:Application):NoteDatabase{
        return Room.databaseBuilder(app,NoteDatabase::class.java,"note_database").build()
    }

    @Singleton
    @Provides
    fun providesNoteDao(db: NoteDatabase): NoteDao {
        return db.noteDao()
    }

    @Provides
    fun providesRepository(noteDao: NoteDao):NoteRepository{
        return NoteRepository(noteDao)
    }
}