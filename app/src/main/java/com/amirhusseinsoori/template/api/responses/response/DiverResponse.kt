package com.amirhusseinsoori.template.api.responses.response

import com.google.gson.annotations.SerializedName

data class DiverResponse(
    @SerializedName("receipt_uuid")
    val receipt_uuid: String?=null,
    @SerializedName("response_code")
    val response_code: Int?=null,
    @SerializedName("response_value")
    val response_value: List<Any>?=null,
    @SerializedName("transactions")
    val transactions: ArrayList<Transaction>?=null
)