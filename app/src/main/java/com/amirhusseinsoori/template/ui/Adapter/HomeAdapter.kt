package com.amirhusseinsoori.template.ui.Adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.util.SetTime
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_item_main.view.*


class HomeAdapter(var time: SetTime, val picasso: Picasso) :
    RecyclerView.Adapter<HomeAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)


    private val differCallback = object : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(
            oldItem: Transaction,
            newItem: Transaction
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: Transaction,
            newItem: Transaction
        ): Boolean = oldItem == newItem
    }


    val differ = AsyncListDiffer(this, differCallback)

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
        val currentItem = differ.currentList[position]
        when (currentItem.transaction!!.view_type) {
            1 -> {
                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_status.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_status.text = checkStatus(it)
                    } else {
                        holder.itemView.txt_homeF_status.text = checkStatus(it)
                    }
                }
                holder.itemView.txt_homeF_request.text = " ارسال از"
                holder.itemView.txt_homeF_about_cost.text = currentItem.transaction.description
                holder.itemView.txt_homeF_cost.text = currentItem.transaction.amount.toString()
                holder.itemView.txt_homeF_history.text =
                    time.time(currentItem.transaction.creation_time.toString())
                holder.itemView.txt_homeF_name.text =
                    currentItem.properties?.getOrNull(0)?.values?.user_fullname
                picasso.load(currentItem.user_avatars?.getOrNull(0)?.url)
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(holder.itemView.img_homeF_profile)
            }
            2 -> {
                currentItem!!.transaction!!.status.let {
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
                holder.itemView.txt_homeF_about_cost.text = currentItem.transaction.description
                holder.itemView.txt_homeF_cost.text = currentItem.transaction.amount.toString()
                holder.itemView.txt_homeF_history.text =
                    time.time(currentItem.transaction.creation_time.toString())
                holder.itemView.txt_homeF_name.text =
                    currentItem.properties?.getOrNull(0)?.values?.user_fullname
                picasso.load(currentItem.user_avatars?.getOrNull(0)?.url)
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
                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_status.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                    } else {
                        holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                    }
                }
                holder.itemView.txt_homeF_request.text = "برداشت از دایور"
                holder.itemView.txt_homeF_about_cost.text = currentItem.transaction.description
                holder.itemView.txt_homeF_cost.text = currentItem.transaction.amount.toString()
                holder.itemView.txt_homeF_history.text =
                    time.time(currentItem.transaction.creation_time.toString())
                picasso.load(currentItem.properties?.getOrNull(0)?.values?.user_fullname)
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(holder.itemView.img_homeF_profile)
            }

            5 -> {
                currentItem!!.transaction!!.status.let {
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
                holder.itemView.txt_homeF_about_cost.text = currentItem.transaction.description
                holder.itemView.txt_homeF_history.text =
                    time.time(currentItem.transaction.creation_time.toString())
                holder.itemView.txt_homeF_name.text =
                    currentItem.properties?.getOrNull(0)?.values?.user_fullname
                picasso.load(currentItem.user_avatars?.getOrNull(0)?.url)
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(holder.itemView.img_homeF_profile)
            }
            6 -> {
                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_status.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                    } else {
                        holder.itemView.txt_homeF_status.text = checkStatus(it!!)
                    }
                }
                holder.itemView.txt_homeF_request.text = "درخواست"
                holder.itemView.txt_homeF_request.setTextColor(Color.parseColor("#F93737"))
                holder.itemView.txt_homeF_cost.text = currentItem.transaction.amount.toString()
                holder.itemView.txt_homeF_history.text =
                    time.time(currentItem.transaction.creation_time.toString())
                holder.itemView.txt_homeF_name.text =
                    currentItem.properties?.getOrNull(0)?.values?.user_fullname
                picasso.load(currentItem.user_avatars?.getOrNull(0)?.url)
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(holder.itemView.img_homeF_profile)
            }

        }


    }


    override fun getItemCount(): Int {
        return differ.currentList.size
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


}