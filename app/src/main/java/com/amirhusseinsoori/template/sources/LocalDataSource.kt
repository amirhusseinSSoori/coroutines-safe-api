package com.amirhusseinsoori.template.sources


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import androidx.room.Dao
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.db.DiverEntity
import com.amirhusseinsoori.template.db.MyDao
import com.amirhusseinsoori.template.db.MyDataBase

import javax.inject.Inject

class LocalDataSource @Inject constructor(
    var dao: MyDao

) {
    fun getAllDataSource() = dao.getAllDataDao()
    suspend fun insertAllDataSource(diverLocal: DiverEntity) = dao.insertDataDao(diverLocal)

}