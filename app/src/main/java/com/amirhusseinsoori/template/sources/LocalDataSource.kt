package com.amirhusseinsoori.template.sources

import com.amirhusseinsoori.template.api.responses.response.diverResponse.Chat
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.db.MyDao

import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val myDao: MyDao
) {
    suspend fun insertDataChat(chat: Chat) = myDao.insertDataChat(chat = chat)
    fun getData() = myDao.getAllDataChat()
}