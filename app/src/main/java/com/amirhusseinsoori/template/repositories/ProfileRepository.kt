package com.amirhusseinsoori.template.repositories


import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.db.DiverEntity
import com.amirhusseinsoori.template.sources.LocalDataSource
import com.amirhusseinsoori.template.sources.RemoteDataSource
import com.example.template.api.safe.ApiWrapper

import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource

) {

    //network
    suspend fun diverDataNetworkRepository(): ApiWrapper<DiverResponse> = remote.diverDataNetwork()



    //local
    fun getAllDataRepository() =local.getAllDataSource()
    suspend fun insertAllDataRepository(Local: DiverEntity) =local.insertAllDataSource(Local)

}