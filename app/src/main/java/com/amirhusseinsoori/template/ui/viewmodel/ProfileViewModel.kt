package com.amirhusseinsoori.template.ui.viewmodel

import android.provider.ContactsContract
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.SampleResponse
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.api.responses.response.diverResponse.TransactionX


import com.amirhusseinsoori.template.repositories.ProfileRepository
import com.example.template.api.safe.ApiWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProfileViewModel @ViewModelInject constructor(var repository: ProfileRepository) :
    ViewModel() {


    val showDetailsDiver = MutableLiveData<ApiWrapper<DiverResponse>>()
    val getShowDetailsDiver: LiveData<ApiWrapper<DiverResponse>>
        get() = showDetailsDiver


    fun showDiver(token: String) {
        viewModelScope.launch {
            showDetailsDiver.value = repository.getDiverRemote(token)
        }
    }


    val showDetails = repository
        .favoriteLatestNews()
        .asLiveData(viewModelScope.coroutineContext)


    val details: LiveData<ApiWrapper<SampleResponse>>
        get() = showDetails


    //local
    //local
    fun getAllDataProfileViewModel() = repository.getAllDataRepository()
    fun insertAllDataProfileViewModel(diverResponse: DiverResponse) {
        viewModelScope.launch {
            repository.insertAllDataRepository(diverResponse)
        }


    }
}


