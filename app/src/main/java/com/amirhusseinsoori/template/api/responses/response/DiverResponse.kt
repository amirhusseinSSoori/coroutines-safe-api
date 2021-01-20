package com.amirhusseinsoori.template.api.responses.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.db.Converter
import com.google.gson.annotations.SerializedName
@Entity(tableName = "diverResponse")
data class DiverResponse(
    val receipt_uuid: String? = null,
    val response_code: Int? = null,
    @TypeConverters(Converter::class)
    val response_value: List<Any>? = null,
    @TypeConverters(Converter::class)
    val transactions: List<Transaction>? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)


