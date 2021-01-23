package com.amirhusseinsoori.template.api.responses.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.db.Converter
import com.google.gson.annotations.SerializedName

data class DiverResponse(
    @SerializedName("receipt_uuid")
    val receiptUuId: String? = null,
    @SerializedName("response_code")
    val responseCode: Int? = null,
    @SerializedName("response_value")
    val responseValue: List<Any>? = null,
    @SerializedName("transactions")
    val transactions: List<Transaction>? = null,

    )


