package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Values(
    @SerializedName("passive_fullname")
    val passiveFullName: String?=null,
    @SerializedName("passive_phone")
    val passivePhone: String?=null,
    @SerializedName("user_fullname")
    val userFullName: String?=null,
    @SerializedName("user_phone")
    val userPhone: String?=null, )