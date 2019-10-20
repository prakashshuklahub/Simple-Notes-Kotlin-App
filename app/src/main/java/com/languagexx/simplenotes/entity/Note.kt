package com.languagexx.simplenotes.entity

import android.util.EventLogTags
import androidx.room.Entity
import androidx.room.PrimaryKey


//Entity class for note table
@Entity(tableName = "tbl_note")
class Note(@PrimaryKey(autoGenerate = true)
           val id: Int,
           val title: String,
           val description: String,
           val color :String,
           val tag :String) {
}