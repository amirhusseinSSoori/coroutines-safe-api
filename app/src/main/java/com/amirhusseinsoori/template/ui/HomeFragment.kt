package com.amirhusseinsoori.template.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.amirhusseinsoori.template.R

import com.amirhusseinsoori.template.db.DiverEntity
import com.amirhusseinsoori.template.db.subdiver.*
import com.amirhusseinsoori.template.ui.Adapter.HomeAdapter
import com.amirhusseinsoori.template.ui.viewmodel.ProfileViewModel
import com.amirhusseinsoori.template.util.CalendarTool
import com.example.template.api.safe.ApiWrapper

import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : MainFragment(R.layout.fragment_home), HomeAdapter.PortData {
    private val TAG = "ProfileFragment"


    private val viewModel: ProfileViewModel by viewModels()

    @Inject
    lateinit var picasso: Picasso


    var adapterHome: HomeAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterHome = HomeAdapter(this)
        showDiver()
        onSubscribeShowDiver()
        setUpRecyclerView()

    }


    private fun showDiver() {
        viewModel.showDetailsNetworkDiver()
    }

    private fun onSubscribeShowDiver() {
        viewModel.getShowDetailsDiver.observe(viewLifecycleOwner, { response ->
            when (response) {
                is ApiWrapper.Success -> {
                    response.data.let {

                        viewModel.insertAllDataProfileViewModel(DiverEntity(
                            it!!.receiptUuId,
                            it.responseCode,
                            it.responseValue,
                            it.transactions?.map { entity ->
                                TransactionSubEntity(
                                    ChatSubEntity(
                                        entity.chat?.chatID,
                                        entity.chat?.message,
                                        entity.chat?.status,
                                        entity.chat?.tranId,
                                        entity.chat?.updateTime,
                                        entity.chat?.userId
                                    ),
                                    ContactSubEntity(
                                        entity.contact?.contactId,
                                        entity.contact?.firstName,
                                        entity.contact?.isRegistered,
                                        entity.contact?.lastName,
                                        entity.contact?.phone,
                                        entity.contact?.userId
                                    ),
                                    entity.properties?.map { property ->
                                        PropertySubEntity(
                                            property.code,
                                            property.propertyID,
                                            property.tranId,
                                            ValuesSubEntity(
                                                property.values?.passiveFullName,
                                                property.values?.userPhone,
                                                property.values?.userFullName,
                                                property.values?.userPhone
                                            )
                                        )
                                    }, TransactionXSubEntity(
                                        entity.transaction?.amount,
                                        entity.transaction?.creationTime,
                                        entity.transaction?.description,
                                        entity.transaction?.status,
                                        entity.transaction?.tranId,
                                        entity.transaction?.updateTime,
                                        entity.transaction?.userId,
                                        entity.transaction?.viewType
                                    ), UserSubEntity(
                                        entity.user?.about_me,
                                        entity.user?.firstName,
                                        entity.user?.lastName,
                                        entity.user?.phone,
                                        entity.user?.userID,
                                        entity.user?.userName
                                    ),
                                    entity.userAvatars?.map {avatar->
                                        UserAvatarSubEntity(
                                            avatar.avatarId,
                                            avatar.updateTime,
                                            avatar.url,
                                            avatar.userId
                                        )
                                    }


                                )
                            }


                        ))

                        viewModel.getAllDataProfileViewModel().observe(viewLifecycleOwner, {
                            setThrowable {
                                Log.e("Tag", "onSubscribeShowDiver: ${it}")
                                adapterHome!!.differ.submitList(it.transactions)

                            }
                        })

                    }
                    Log.e(TAG, "onSubscribeShowDiver:  ${response.data!!}")
                }
                is ApiWrapper.ApiError -> {
                    Log.e(TAG, "onSubscribeShowDiver:${response.totalError} ")
                    toastError()
                }
                is ApiWrapper.NetworkError -> {


                    viewModel.getAllDataProfileViewModel().observe(viewLifecycleOwner, {
                        setThrowable {
                            Log.e("Tag", "onSubscribeShowDiver: ${it}")
                            adapterHome!!.differ.submitList(it.transactions)
                        }
                    })












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


    private fun setUpRecyclerView() {
        adapterHome!!.setHasStableIds(true);
        rvMain.apply {
            adapter = adapterHome
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL, false
            )


        }
    }

    override fun sendData(
        txtName: TextView,
        txtStatus: TextView,
        txtRequest: TextView,
        txtAboutCost: TextView,
        txtCost: TextView,
        txtHistory: TextView,
        txtPlus: TextView,
        txtDiver: TextView,
        imgProfile: CircleImageView,
        currentItem: TransactionSubEntity
    ) {
        when (currentItem.transaction!!.viewType) {
            1 -> {
                currentItem.transaction.status.let {
                    if (checkStatus(it!!) == requireContext().resources.getString(R.string.rejected)) {
                        txtStatus.setTextColor(
                            Color.parseColor(
                                requireContext().resources.getString(
                                    R.string.redtxt
                                )
                            )
                        )
                        txtStatus.text = checkStatus(it)
                    } else {
                        txtStatus.text = checkStatus(it)
                    }
                }

                txtRequest.text = requireContext().resources.getString(R.string.send_to)
                txtAboutCost.text = currentItem.transaction.description
                txtCost.text = currentItem.transaction.amount.toString()
                txtHistory.text = convertGregorianDateTimeToIranianDateTime(currentItem.transaction.creationTime.toString())
                txtName.text = currentItem.properties?.getOrNull(0)?.value?.userFullName
                picasso.load(currentItem.userAvatars?.getOrNull(0)?.url).resize(515, 400)
                    .centerCrop()
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(imgProfile)
            }
            2 -> {
                currentItem.transaction.status.let {
                    if (checkStatus(it!!) == requireContext().resources.getString(R.string.rejected)) {
                        txtStatus.setTextColor(
                            Color.parseColor(
                                requireContext().resources.getString(
                                    R.string.redtxt
                                )
                            )
                        )
                        txtStatus.text = checkStatus(it)
                    } else {
                        txtStatus.text = checkStatus(it)
                    }
                }
                txtRequest.text = requireContext().resources.getString(R.string.receive_to)
                txtCost.setTextColor(Color.parseColor(requireContext().resources.getString(R.string.greentxt)))
                txtPlus.visibility = View.VISIBLE
                txtPlus.setTextColor(Color.parseColor(requireContext().resources.getString(R.string.greentxt)))
                txtAboutCost.text = currentItem.transaction.description
                txtCost.text = currentItem.transaction.amount.toString()
                txtHistory.text = convertGregorianDateTimeToIranianDateTime(currentItem.transaction.creationTime.toString())
                txtName.text =
                    currentItem.properties?.getOrNull(0)?.value?.userFullName
                picasso.load(currentItem.userAvatars?.getOrNull(0)?.url).resize(515, 400)
                    .centerCrop()
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(imgProfile)
            }
            3 -> {
                txtRequest.text = requireContext().resources.getString(R.string.cashIn)
                txtPlus.visibility = View.VISIBLE
                txtPlus.setTextColor(Color.parseColor(requireContext().resources.getString(R.string.greentxt)))
                txtDiver.visibility = View.VISIBLE
                txtName.visibility = View.GONE
                txtAboutCost.visibility = View.GONE
                txtRequest.visibility = View.GONE
                txtStatus.visibility = View.GONE
                txtHistory.text=convertGregorianDateTimeToIranianDateTime(currentItem.transaction.creationTime.toString())

                txtCost.setTextColor(Color.parseColor(requireContext().resources.getString(R.string.greentxt)))
                picasso.load(R.drawable.diver_cash).resize(515, 400)
                    .centerCrop()
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(imgProfile)
            }


            4 -> {
                currentItem.transaction!!.status.let {
                    if (checkStatus(it!!) == requireContext().resources.getString(R.string.rejected)) {
                        txtStatus.setTextColor(
                            Color.parseColor(
                                requireContext().resources.getString(
                                    R.string.redtxt
                                )
                            )
                        )
                        txtStatus.text = checkStatus(it)
                    } else {
                        txtStatus.text = checkStatus(it)
                    }
                }
                txtRequest.text = requireContext().resources.getString(R.string.cashOut)
                txtAboutCost.text = currentItem.transaction.description
                txtCost.text = currentItem.transaction.amount.toString()
                txtHistory.text = convertGregorianDateTimeToIranianDateTime(currentItem.transaction.creationTime.toString())
                picasso.load(currentItem.properties?.getOrNull(0)?.value?.userFullName)
                    .resize(515, 400)
                    .centerCrop()
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(imgProfile)
            }

            5 -> {
                currentItem.transaction.status.let {
                    if (checkStatus(it!!) == requireContext().resources.getString(R.string.rejected)) {
                        txtStatus.setTextColor(
                            Color.parseColor(
                                requireContext().resources.getString(
                                    R.string.redtxt
                                )
                            )
                        )
                        txtStatus.text = checkStatus(it)
                    } else {
                        txtStatus.text = checkStatus(it)
                    }
                }

                txtRequest.text = requireContext().resources.getString(R.string.requestFromYou)
                txtRequest.setTextColor(Color.parseColor(requireContext().resources.getString(R.string.greentxt)))
                txtPlus.setTextColor(Color.parseColor(requireContext().resources.getString(R.string.greentxt)))
                txtCost.setTextColor(Color.parseColor(requireContext().resources.getString(R.string.greentxt)))
                txtPlus.visibility = View.VISIBLE
                txtAboutCost.text = currentItem.transaction!!.description
                txtHistory.text =convertGregorianDateTimeToIranianDateTime(currentItem.transaction.creationTime.toString())
                txtName.text = currentItem.properties?.getOrNull(0)?.value?.userFullName
                picasso.load(currentItem.userAvatars?.getOrNull(0)?.url).resize(515, 400)
                    .centerCrop()
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(imgProfile)
            }
            6 -> {
                currentItem.transaction.status.let {
                    if (checkStatus(it!!) == requireContext().resources.getString(R.string.rejected)) {
                        txtStatus.setTextColor(
                            Color.parseColor(
                                requireContext().resources.getString(
                                    R.string.redtxt
                                )
                            )
                        )
                        txtStatus.text = checkStatus(it)
                    } else {
                        txtStatus.text = checkStatus(it)
                    }
                }
                txtRequest.text = requireContext().resources.getString(R.string.Request)
                txtRequest.setTextColor(Color.parseColor(requireContext().resources.getString(R.string.greentxt)))
                txtCost.text = currentItem.transaction.amount.toString()
                txtHistory.text = convertGregorianDateTimeToIranianDateTime(currentItem.transaction.creationTime.toString())

                txtName.text = currentItem.properties?.getOrNull(0)?.value?.userFullName
                picasso.load(currentItem.userAvatars?.getOrNull(0)?.url).resize(515, 400)
                    .centerCrop()
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(imgProfile)
            }

        }
    }

    private fun checkStatus(type: Int): String {
        return when (type) {
            0 -> requireContext().resources.getString(R.string.newRequest)
            1 -> requireContext().resources.getString(R.string.completed)
            2 -> requireContext().resources.getString(R.string.watting)
            3 -> requireContext().resources.getString(R.string.rejected)
            else -> ""
        }

    }

   private fun convertGregorianDateTimeToIranianDateTime(dateStr: String): String {

        val date: Date = SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).parse(dateStr)
        val cal = CalendarTool()
        cal.setGregorianDate(date)
        Calendar.getInstance().time = date
        val hour: Int = Calendar.getInstance().get(Calendar.HOUR)
        val min: Int = Calendar.getInstance().get(Calendar.MINUTE)
        return "${cal.iranianDay} ${cal.iranianMonthStr} ${cal.iranianYear} $hour:$min"
    }

}