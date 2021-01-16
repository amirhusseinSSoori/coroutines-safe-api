package com.amirhusseinsoori.template.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amirhusseinsoori.template.api.responses.response.SampleResponse



import com.amirhusseinsoori.template.repositories.ProfileRepository
import com.example.template.api.safe.ApiWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ProfileViewModel @ViewModelInject constructor(var repository: ProfileRepository) :
    ViewModel() {



    val _showList = MutableLiveData<ApiWrapper<SampleResponse>>()
    val showListDr: LiveData<ApiWrapper<SampleResponse>>
        get() = _showList



    fun showList(){
        viewModelScope.launch {
            _showList.value = repository.getRemote()
        }
    }










}