package com.amirhusseinsoori.template.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.diverResponse.*

@Database(entities =[DiverEntity::class]   , version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class MyDataBase : RoomDatabase() {
    abstract fun getMyDao(): MyDao
}