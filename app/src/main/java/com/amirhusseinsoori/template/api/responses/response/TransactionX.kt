package com.amirhusseinsoori.template.api.responses.response

data class TransactionX(
    val amount: Double,
    val creation_time: Long,
    val description: String,
    val status: Int,
    val tran_id: Int,
    val update_time: Long,
    val user_id: Int,
    val view_type: Int
)