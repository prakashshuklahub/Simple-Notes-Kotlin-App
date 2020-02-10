package com.languagexx.simplenotes.persistence

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


// - Entity class for note table
@Entity(tableName = "tbl_note")
class Note(@PrimaryKey(autoGenerate = true)
           var id: Int,
           var title: String?,
           var description: String?,
           var color:String?,
           var tag:String?) :Parcelable{


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )


    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(color)
        parcel.writeString(tag)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }


}