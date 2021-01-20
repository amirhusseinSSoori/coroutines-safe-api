package com.amirhusseinsoori.template.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Chat
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Contact
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction


@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataChat(chat: Chat): Long

    @Query("SELECT * FROM Chat")
    fun getAllDataChat(): List<Chat>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataContact(contact: Contact): Long

    @Query("SELECT * FROM Contact")
    fun getAllDataContact(): List<Contact>


}