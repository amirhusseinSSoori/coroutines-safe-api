package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class TransactionX(
    @SerializedName("amount")
    val amount: Double?=null,
    @SerializedName("creation_time")
    val creationTime: Long?=null,
    @SerializedName("description")
    val description: String?=null,
    @SerializedName("status")
    val status: Int?=null,
    @SerializedName("tran_id")
    val tranId: Int?=null,
    @SerializedName("update_time")
    val updateTime: Long?=null,
    @SerializedName("user_id")
    val userId: Int?=null,
    @SerializedName("view_type")
    val viewType: Int?=null
)