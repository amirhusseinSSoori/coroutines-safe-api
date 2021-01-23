package com.amirhusseinsoori.template.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.databinding.FragmentHomeBinding
import com.amirhusseinsoori.template.db.DiverEntity
import com.amirhusseinsoori.template.db.subdiver.*
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
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val TAG = "ProfileFragment"



    private val viewModel: ProfileViewModel by viewModels()

    @Inject
    lateinit var picasso: Picasso

    @Inject
    lateinit var time: SetTime

    var adapterHome: HomeAdapter? = null
    private var _binding: FragmentHomeBinding? = null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterHome = HomeAdapter(time, picasso)



        showDiver()
        onSubscribeShowDiver()
        setUpRecyclerView()

    }


    private fun showDiver() {
        viewModel.showDiver()
    }

    private fun onSubscribeShowDiver() {
        viewModel.getShowDetailsDiver.observe(viewLifecycleOwner, { response ->
            when (response) {
                is ApiWrapper.Success -> {
                    response.data.let {

                        viewModel.insertAllDataProfileViewModel(DiverEntity(
                            it!!.receipt_uuid,
                            it!!.response_code,
                            it!!.response_value,
                            it.transactions?.map { entity ->
                                TransactionSubDiver(
                                    ChatSubDiver(
                                        entity.chat?.chat_id,
                                        entity.chat?.message,
                                        entity.chat?.status,
                                        entity.chat?.tran_id,
                                        entity.chat?.update_time,
                                        entity.chat?.user_id
                                    ),
                                    ContactSubDiver(
                                        entity.contact?.contact_id,
                                        entity.contact?.first_name,
                                        entity.contact?.is_registered,
                                        entity.contact?.last_name,
                                        entity.contact?.phone,
                                        entity.contact?.user_id
                                    ),
                                    entity.properties?.map { property ->
                                        PropertySubDiver(
                                            property.code,
                                            property.property_id,
                                            property.tran_id,
                                            ValuesSubDiver(
                                                property.values?.passive_fullname,
                                                property.values?.user_phone,
                                                property.values?.user_fullname,
                                                property.values?.user_phone
                                            )
                                        )
                                    }, TransactionXSubDiver(
                                        entity.transaction?.amount,
                                        entity.transaction?.creation_time,
                                        entity.transaction?.description,
                                        entity.transaction?.status,
                                        entity.transaction?.tran_id,
                                        entity.transaction?.update_time,
                                        entity.transaction?.user_id,
                                        entity.transaction?.view_type
                                    ), UserSubDiver(
                                        entity.user?.about_me,
                                        entity.user?.first_name,
                                        entity.user?.last_name,
                                        entity.user?.phone,
                                        entity.user?.user_id,
                                        entity.user?.username
                                    ),
                                    entity.user_avatars?.map {
                                        UserAvatarSubDiver(
                                            it.avatar_id,
                                            it.update_time,
                                            it.url,
                                            it.user_id
                                        )
                                    }


                                )
                            }


                        ))

                        viewModel.getAllDataProfileViewModel().observe(viewLifecycleOwner, {
//                            setThrowable {
                                Log.e("Tag", "onSubscribeShowDiver: ${it}")
                            adapterHome!!.differ.submitList(it.transactions)

//                            }
                        })

                    }
                    Log.e(TAG, "onSubscribeShowDiver:  ${response.data!!}")
                }
                is ApiWrapper.ApiError -> {
                    Log.e(TAG, "onSubscribeShowDiver:${response.totalError} ")
//                    toastError()
                }
                is ApiWrapper.NetworkError -> {


                    viewModel.getAllDataProfileViewModel().observe(viewLifecycleOwner, {
//                        setThrowable {
                            Log.e("Tag", "onSubscribeShowDiver: ${it}")
                           adapterHome!!.differ.submitList(it.transactions)
//                        }
                    })












                    Log.e(TAG, "onSubscribeShowDiver:  ${response.message}")
//                    toastNet()
                }
                is ApiWrapper.UnknownError -> {
                    Log.e(TAG, "onSubscribeShowDiver: ${response.message}")
//                    toastError()
                }


            }


        })


    }


    private fun setUpRecyclerView() {
        adapterHome!!.setHasStableIds(true);
        binding.apply {
            rvMain.apply {
            adapter = adapterHome
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL, false
            )



        }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}