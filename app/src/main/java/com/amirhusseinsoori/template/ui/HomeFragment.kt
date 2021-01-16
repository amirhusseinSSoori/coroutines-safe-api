package com.amirhusseinsoori.template.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.ui.viewmodel.ProfileViewModel
import com.amirhusseinsoori.template.util.Constance
import com.amirhusseinsoori.template.util.Constance.BASE_URL

import com.example.template.api.safe.ApiWrapper
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment :Fragment(R.layout.fragment_home) {
    private val TAG = "ProfileFragment"
    private val viewModel: ProfileViewModel by viewModels()

    @Inject
    lateinit var picasso: Picasso

    private var fileID: String? = null
    private lateinit var callback: OnBackPressedCallback
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showList()
        onSubscribeShowList()
        Log.e(TAG, "onViewCreated: ", )
    }





    private fun showList() {
        viewModel.showList()
    }

    private fun onSubscribeShowList() {
        viewModel.showListDr.observe(viewLifecycleOwner, { response ->
            when (response) {
                is ApiWrapper.Success -> {

//
                      Log.e(TAG, "onSubscribeUserLogout:  ${response.data!!}", )




                }
                is ApiWrapper.ApiError -> {
                    Log.e(TAG, "showDetailsDr:${response.totalError} ", )
                    //toastError()
                }
                is ApiWrapper.NetworkError -> {
                    Log.e(TAG, "onSubscribeUserLogout:  ${response.message}", )
                    // toastNet()
                }
                is ApiWrapper.UnknownError -> {
                    Log.e(TAG, "showUnknownError: ${response.message}", )
                    //toastError()
                }


            }


        })


    }

}