package com.amirhusseinsoori.template.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.db.subdiver.TransactionSubEntity

@Entity(tableName = "diverEntity")
data class DiverEntity (
    val receiptUuId: String? = null,
    val responseCode: Int? = null,
    @TypeConverters(Converter::class)
    val responseValue: List<Any>? = null,
    @TypeConverters(Converter::class)
    val transactions: List<TransactionSubEntity>? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null


)