package com.amirhusseinsoori.template.api.responses.response.diverResponse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TransactionX")
data class TransactionX(
    val amount: Double?=null,
    val creation_time: Long?=null,
    val description: String?=null,
    val status: Int?=null,
    val tran_id: Int?=null,
    val update_time: Long?=null,
    val user_id: Int?=null,
    val view_type: Int?=null,
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null
)