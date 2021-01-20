package com.amirhusseinsoori.template.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.ui.Adapter.HomeAdapter
import com.amirhusseinsoori.template.ui.viewmodel.ProfileViewModel
import com.amirhusseinsoori.template.util.Constance
import com.amirhusseinsoori.template.util.SetTime
import com.example.template.api.safe.ApiWrapper
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : MainFragment(R.layout.fragment_home) {
    private val TAG = "ProfileFragment"
    var adapterHome: HomeAdapter? = null


    private val viewModel: ProfileViewModel by viewModels()

    @Inject
    lateinit var picasso: Picasso

    @Inject
    lateinit var time: SetTime
    var details = ArrayList<Transaction>()

//    var listData = viewModel.getAllData()
    private var model = ArrayList<Transaction>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  getDetails()
        adapterHome = HomeAdapter(time, picasso)


        showDiver()
        onSubscribeShowDiver()

    }


    private fun showDiver() {
        viewModel.showDiver(Constance.TOKEN)
    }

    private fun insertData(transaction: Transaction){
//        viewModel.insertData(transaction)
    }

    private fun onSubscribeShowDiver() {



        viewModel.getShowDetailsDiver.observe(viewLifecycleOwner, { response ->
            when (response) {
                is ApiWrapper.Success -> {
                    response.data.let {


                        details = it!!.transactions!!


//                        Log.e("list", "$listData ")
                     adapterHome!!.differ.submitList(details!!)
                        rvMain.apply {
                            adapter = adapterHome
                            layoutManager = LinearLayoutManager(
                                requireContext(),
                                LinearLayoutManager.VERTICAL, false
                            )


                        }


                    }



                    Log.e(TAG, "onSubscribeShowDiver:  ${response.data!!}")


                }
                is ApiWrapper.ApiError -> {
                    Log.e(TAG, "onSubscribeShowDiver:${response.totalError} ")
                    toastError()
                }
                is ApiWrapper.NetworkError -> {
                    Log.e(TAG, "onSubscribeShowDiver:  ${response.message}")
                    toastNet()
                }
                is ApiWrapper.UnknownError -> {
                    Log.e(TAG, "onSubscribeShowDiver: ${response.message}")
                    toastError()
                }


            }


        })


    }


}