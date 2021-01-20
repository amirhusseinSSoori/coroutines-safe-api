package com.amirhusseinsoori.template.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amirhusseinsoori.template.api.responses.response.diverResponse.*

@Database(
    entities = [
        Chat::class,
        Contact::class
    ],
    version = 1
)
abstract class MyDataBase : RoomDatabase() {
    abstract fun getMyDao(): MyDao
}