package com.amirhusseinsoori.template.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.db.subdiver.TransactionSubDiver

@Entity(tableName = "diverEntity")
data class DiverEntity (
    val receipt_uuid: String? = null,
    val response_code: Int? = null,
    @TypeConverters(Converter::class)
    val response_value: List<Any>? = null,
    @TypeConverters(Converter::class)
    val transactions: List<TransactionSubDiver>? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null


)