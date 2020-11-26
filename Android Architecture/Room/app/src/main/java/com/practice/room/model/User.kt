package com.practice.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//Entity
//reprezentuje tablice

@Parcelize
@Entity(tableName="user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName : String,
    val secondName: String,
    val age : Int
): Parcelable

//Parcelable jest po to by brac wartosci w navigation w update
//Poprostu wraz z zmiana fragmentu przekazujemy tego usera