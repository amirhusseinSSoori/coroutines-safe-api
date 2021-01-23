package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Property(
    @SerializedName("code")
    val code: Int?=null,
    @SerializedName("property_id")
    val propertyID: Int?=null,
    @SerializedName("tran_id")
    val tranId: Int?=null,
    @SerializedName("values")
    val values: Values?=null
)