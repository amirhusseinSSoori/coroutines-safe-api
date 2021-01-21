package com.amirhusseinsoori.template.db

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.*
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Chat
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Contact
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction


@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertDataDao(diverDao: DiverResponse): Long

        @Query("SELECT * FROM diverResponse")
        fun getAllDataDao(): List<DiverResponse>


}





