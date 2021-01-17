package com.amirhusseinsoori.template.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.amirhusseinsoori.template.api.responses.response.SampleResponse


import com.amirhusseinsoori.template.repositories.ProfileRepository
import com.example.template.api.safe.ApiWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProfileViewModel @ViewModelInject constructor(var repository: ProfileRepository) :
        ViewModel() {


    val _showList = MutableLiveData<ApiWrapper<SampleResponse>>()
    val showListDr: LiveData<ApiWrapper<SampleResponse>>
        get() = _showList




    val showDetails = repository
            .favoriteLatestNews()
            .asLiveData(viewModelScope.coroutineContext)


    val details: LiveData<ApiWrapper<SampleResponse>>
        get() = showDetails






    fun showList() {
        viewModelScope.launch {
            _showList.value = repository.getRemote()
        }
    }


}


