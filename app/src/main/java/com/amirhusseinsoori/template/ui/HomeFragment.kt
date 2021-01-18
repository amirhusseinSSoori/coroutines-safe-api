package com.amirhusseinsoori.template.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.Transaction
import com.amirhusseinsoori.template.ui.Adapter.HomeAdapter
import com.amirhusseinsoori.template.ui.viewmodel.ProfileViewModel
import com.amirhusseinsoori.template.util.Constance

import com.example.template.api.safe.ApiWrapper
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val TAG = "ProfileFragment"
    var adapterHome: HomeAdapter? = null


    private val viewModel: ProfileViewModel by viewModels()

    @Inject
    lateinit var picasso: Picasso
    var mainList = ArrayList<DiverResponse>()
    var childList = ArrayList<Transaction>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  getDetails()
        adapterHome = HomeAdapter()


        showDiver()
        onSubscribeShowDiver()

    }


    private fun showDiver() {
        viewModel.showDiver(Constance.TOKEN)
    }

    private fun onSubscribeShowDiver() {

        viewModel.getShowDetailsDiver.observe(viewLifecycleOwner, { response ->
            when (response) {
                is ApiWrapper.Success -> {

                    response.data.let {
                   mainList.add(it!!)



                         val list1=it.transactions




                        Log.e("list", "$list1 ")
                        adapterHome!!.differ.submitList(list1!!)
                        rvMain.apply {
                            adapter = adapterHome
                            layoutManager = LinearLayoutManager(
                                requireContext(),
                                LinearLayoutManager.VERTICAL, false
                            )


                        }


                    }



//
                    Log.e(TAG, "onSubscribeShowDiver:  ${response.data!!}")


                }
                is ApiWrapper.ApiError -> {
                    Log.e(TAG, "onSubscribeShowDiver:${response.totalError} ")
                    //toastError()
                }
                is ApiWrapper.NetworkError -> {
                    Log.e(TAG, "onSubscribeShowDiver:  ${response.message}")
                    // toastNet()
                }
                is ApiWrapper.UnknownError -> {
                    Log.e(TAG, "onSubscribeShowDiver: ${response.message}")
                    //toastError()
                }


            }


        })


    }


}