package com.amirhusseinsoori.template.sources


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.db.MyDao
import com.amirhusseinsoori.template.db.MyDataBase

import javax.inject.Inject

class LocalDataSource @Inject constructor(
    var dao: MyDataBase

) {
//    fun getAllDataSource() = dao.getAllDataDao()
    suspend fun insertAllDataSource(diverLocal:DiverResponse) = dao.getMyDao().insertDataDao(diverLocal)


    val items = Pager(
        PagingConfig(
            pageSize = 50,
            enablePlaceholders = true,
            maxSize = 200
        )
    ) {
        dao.getMyDao().getAllPaged()
    }.liveData

}