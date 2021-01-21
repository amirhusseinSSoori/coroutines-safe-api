package com.amirhusseinsoori.template.ui.Adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.util.SetTime
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_item_main.view.*


class HomeAdapter(var time: SetTime, val picasso: Picasso) :
    PagingDataAdapter<DiverResponse, HomeAdapter.Holder>(DIFF_CALLBACK) {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_item_main,
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeAdapter.Holder, position: Int) {
        val currentItem = getItem(position)
        var tran=currentItem?.transactions?.get(position)!!.transaction
        var property=currentItem?.transactions?.get(position)!!.properties
        var avatars=currentItem?.transactions?.get(position)!!.user_avatars
        if (currentItem != null) {
            when (tran!!.view_type) {
                1 -> {
                    tran!!.status.let {
                        if (checkStatus(it!!) == "رد شده") {
                            holder.itemView.txt_homeF_status.setTextColor(Color.parseColor("#F93737"))
                            holder.itemView.txt_homeF_status.text = checkStatus(it)
                        } else {
                            holder.itemView.txt_homeF_status.text = checkStatus(it)
                        }
                    }
                    holder.itemView.txt_homeF_request.text = " ارسال از"
                    holder.itemView.txt_homeF_about_cost.text = tran.description
                    holder.itemView.txt_homeF_cost.text = tran.amount.toString()
                    holder.itemView.txt_homeF_history.text =
                        time.time(tran.creation_time.toString())
                    holder.itemView.txt_homeF_name.text = property?.getOrNull(0)?.values?.user_fullname
                    picasso.load(avatars?.getOrNull(0)?.url)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }
                2 -> {
                    tran.status.let {
                        if (checkStatus(it!!) == "رد شده") {
                            holder.itemView.txt_homeF_status.setTextColor(Color.parseColor("#F93737"))
                            holder.itemView.txt_homeF_status.text = checkStatus(it)
                        } else {
                            holder.itemView.txt_homeF_status.text = checkStatus(it)
                        }
                    }
                    holder.itemView.txt_homeF_request.text = "دریافت از"
                    holder.itemView.txt_homeF_cost.setTextColor(Color.parseColor("#0AB571"))
                    holder.itemView.txt_homeF_plus.visibility = View.VISIBLE
                    holder.itemView.txt_homeF_plus.setTextColor(Color.parseColor("#0AB571"))
                    holder.itemView.txt_homeF_about_cost.text = tran.description
                    holder.itemView.txt_homeF_cost.text = tran.amount.toString()
                    holder.itemView.txt_homeF_history.text =
                        time.time(tran.creation_time.toString())
                    holder.itemView.txt_homeF_name.text =
                        property?.getOrNull(0)?.values?.user_fullname
                    picasso.load(avatars?.getOrNull(0)?.url)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }
                3 -> {
                    holder.itemView.txt_homeF_request.text = "شارژ دایور"
                    holder.itemView.txt_homeF_plus.visibility = View.VISIBLE
                    holder.itemView.txt_homeF_plus.setTextColor(Color.parseColor("#0AB571"))
                    holder.itemView.txt_diver.visibility = View.VISIBLE
                    holder.itemView.txt_homeF_name.visibility = View.GONE
                    holder.itemView.txt_homeF_about_cost.visibility = View.GONE
                    holder.itemView.txt_homeF_request.visibility = View.GONE
                    holder.itemView.txt_homeF_status.visibility = View.GONE

                    holder.itemView.txt_homeF_cost.setTextColor(Color.parseColor("#0AB571"))
                    picasso.load(R.drawable.diver_cash)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }


                4 -> {
                    tran!!.status.let {
                        if (checkStatus(it!!) == "رد شده") {
                            holder.itemView.txt_homeF_status.setTextColor(Color.parseColor("#F93737"))
                            holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                        } else {
                            holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                        }
                    }
                    holder.itemView.txt_homeF_request.text = "برداشت از دایور"
                    holder.itemView.txt_homeF_about_cost.text = tran.description
                    holder.itemView.txt_homeF_cost.text = tran.amount.toString()
                    holder.itemView.txt_homeF_history.text =
                        time.time(tran.creation_time.toString())
                    picasso.load(property?.getOrNull(0)?.values?.user_fullname)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }

                5 -> {
                    tran!!.status.let {
                        if (checkStatus(it!!) == "رد شده") {
                            holder.itemView.txt_homeF_status.setTextColor(Color.parseColor("#F93737"))
                            holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                        } else {
                            holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                        }
                    }

                    holder.itemView.txt_homeF_request.text = " درخواست شما از "
                    holder.itemView.txt_homeF_request.setTextColor(Color.parseColor("#0AB571"))
                    holder.itemView.txt_homeF_plus.setTextColor(Color.parseColor("#0AB571"))
                    holder.itemView.txt_homeF_cost.setTextColor(Color.parseColor("#0AB571"))
                    holder.itemView.txt_homeF_plus.visibility = View.VISIBLE
                    holder.itemView.txt_homeF_about_cost.text = tran.description
                    holder.itemView.txt_homeF_history.text =
                        time.time(tran.creation_time.toString())
                    holder.itemView.txt_homeF_name.text =
                        property?.getOrNull(0)?.values?.user_fullname
                    picasso.load(avatars?.getOrNull(0)?.url)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }
                6 -> {
                    tran!!.status.let {
                        if (checkStatus(it!!) == "رد شده") {
                            holder.itemView.txt_homeF_status.setTextColor(Color.parseColor("#F93737"))
                            holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                        } else {
                            holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                        }
                    }
                    holder.itemView.txt_homeF_request.text = "درخواست"
                    holder.itemView.txt_homeF_request.setTextColor(Color.parseColor("#F93737"))
                    holder.itemView.txt_homeF_cost.text = tran.amount.toString()
                    holder.itemView.txt_homeF_history.text =
                        time.time(tran.creation_time.toString())
                    holder.itemView.txt_homeF_name.text =
                        property?.getOrNull(0)?.values?.user_fullname
                    picasso.load(avatars?.getOrNull(0)?.url)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }

            }
        }


    }




    private var onItemClickListener: ((HomeAdapter) -> Unit)? = null

    fun setOnItemClickListener(listener: (HomeAdapter) -> Unit) {
        onItemClickListener = listener
    }


    private fun checkStatus(type: Int): String {
        return when (type) {
            0 -> "درخواست جدید"
            1 -> "تکمیل شده"
            2 -> "در انتظار"
            3 -> "رد شده"
            else -> ""
        }

    }
    override fun getItemViewType(position: Int): Int {
        return position
    }


    companion object{
        private val DIFF_CALLBACK=object : DiffUtil.ItemCallback<DiverResponse>() {
            override fun areItemsTheSame(oldItem: DiverResponse, newItem: DiverResponse) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DiverResponse, newItem: DiverResponse) =
                oldItem == newItem
        }


    }

}