package com.amirhusseinsoori.template.sources


import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.db.MyDao

import javax.inject.Inject

class LocalDataSource @Inject constructor(
    var dao: MyDao

) {
    fun getAllDataSource() = dao.getAllDataDao()
    suspend fun insertAllDataSource(diverLocal:DiverResponse) = dao.insertDataDao(diverLocal)

}