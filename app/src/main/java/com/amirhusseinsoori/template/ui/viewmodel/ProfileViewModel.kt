package com.amirhusseinsoori.template.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.db.DiverEntity


import com.amirhusseinsoori.template.repositories.ProfileRepository
import com.example.template.api.safe.ApiWrapper
import kotlinx.coroutines.launch

class ProfileViewModel @ViewModelInject constructor(var repository: ProfileRepository) :
    ViewModel() {


    val showDetailsDiver = MutableLiveData<ApiWrapper<DiverResponse>>()
    val getShowDetailsDiver: LiveData<ApiWrapper<DiverResponse>>
        get() = showDetailsDiver

    fun showDetailsNetworkDiver() {
        viewModelScope.launch {
            showDetailsDiver.value = repository.diverDataNetworkRepository()
        }
    }



    //local
    fun getAllDataProfileViewModel() =   repository.getAllDataRepository()




    fun insertAllDataProfileViewModel(diverResponse: DiverEntity) {
        viewModelScope.launch {
           repository.insertAllDataRepository(diverResponse)
        }


    }


}


