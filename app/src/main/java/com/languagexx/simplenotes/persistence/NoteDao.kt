package com.languagexx.simplenotes.persistence
import androidx.lifecycle.LiveData
import androidx.room.*


// - Interface Dao for Note table sql operations
// - Using Kotlin Coroutines support for Room
@Dao
interface NoteDao {

    // Method #1
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note):Long

    // Method #2
    @Update
    suspend fun update(note: Note)

    // Method #3
    @Query("delete from tbl_note where id = :id")
    suspend fun deleteById(id:Int)

    // Method #4
    @Delete
    suspend fun delete(note: Note)

    // Method #5
    @Query("select * from tbl_note")
    fun getAllNotes():LiveData<List<Note>>
}