package com.amirhusseinsoori.template.repositories


import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.db.DiverEntity
import com.amirhusseinsoori.template.sources.LocalDataSource
import com.amirhusseinsoori.template.sources.RemoteDataSource
import com.example.template.api.safe.ApiWrapper

import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val remote: RemoteDataSource,
    private val localDataSource: LocalDataSource

) {

    //network
    suspend fun getDiverRemote(): ApiWrapper<DiverResponse> = remote.diverRemote()



    //local
    fun getAllDataRepository() =localDataSource.getAllDataSource()
    suspend fun insertAllDataRepository(diverLocal: DiverEntity) =localDataSource.insertAllDataSource(diverLocal)

}