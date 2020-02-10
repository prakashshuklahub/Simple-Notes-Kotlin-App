package com.languagexx.simplenotes.persistence
import androidx.room.*


// - Interface Dao for Note table sql operations
// - Using Kotlin Coroutines support for Room
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note):Long

    @Update
    suspend fun update(note: Note)

    @Query("delete from tbl_note where id = :id")
    suspend fun deleteById(id:Int)

    @Delete
    suspend fun delete(note: Note)

    @Query("select * from tbl_note")
    suspend fun getAllNotes():List<Note>
}