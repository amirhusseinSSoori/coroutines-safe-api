package com.amirhusseinsoori.template.ui.Adapter

import android.R.attr.*
import android.annotation.SuppressLint
import android.app.ActionBar
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.api.responses.response.Transaction
import com.amirhusseinsoori.template.util.SetTime
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_item_main.view.*


class HomeAdapter(var time: SetTime, val picasso: Picasso) :
    RecyclerView.Adapter<HomeAdapter.BlackListHolder>() {

    inner class BlackListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlackListHolder {
        return BlackListHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_item_main,
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeAdapter.BlackListHolder, position: Int) {
        val currentItem = differ.currentList[position]





        when (currentItem.transaction!!.view_type) {
            1 -> {


                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_description.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }else{
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }
                }

                holder.itemView.txt_homeF_request.text = "ارسال از"


                currentItem.transaction.description?.let {
                    holder.itemView.txt_homeF_about_cost.text = it
                }

                currentItem.transaction.amount?.let {
                    holder.itemView.txt_homeF_cost.text = it.toString()
                }

                currentItem.transaction.creation_time?.let {
                    holder.itemView.txt_homeF_history.text = time.setTime(it.toString())
                }


                currentItem.properties?.getOrNull(0)?.values?.user_fullname?.let {
                    holder.itemView.txt_homeF_name.text = it.toString()
                }

                currentItem.user_avatars?.getOrNull(0)?.url?.let {
                    picasso.load(it)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }

            }
            2 -> {
                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_description.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }else{
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }
                }


                holder.itemView.txt_homeF_request.text = "دریافت از"
                holder.itemView.txt_homeF_cost.setTextColor(Color.parseColor("#0AB571"))
                currentItem.transaction.description?.let {
                    holder.itemView.txt_homeF_about_cost.text = it
                }

                currentItem.transaction.amount?.let {
                    holder.itemView.txt_homeF_cost.text = "$it+"
                }

                currentItem.transaction.creation_time?.let {
                    holder.itemView.txt_homeF_history.text = time.setTime(it.toString())
                }


                currentItem.properties?.getOrNull(0)?.values?.user_fullname?.let {
                    holder.itemView.txt_homeF_name.text = it.toString()
                }

                currentItem.user_avatars?.getOrNull(0)?.url?.let {
                    picasso.load(it)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }

            }
            3 -> {
                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_description.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }else{
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }
                }

                holder.itemView.txt_homeF_name.text = "شارژ دایور"
                holder.itemView.txt_homeF_cost.setTextColor(Color.parseColor("#0AB571"))
//                holder.itemView.txt_homeF_description.visibility = View.GONE
//                holder.itemView.txt_homeF_request.visibility = View.GONE
//                holder.itemView.txt_homeF_about_cost.visibility=View.GONE
                picasso.load(R.drawable.diver_cash)
                    .placeholder(R.drawable.user).error(R.drawable.user)
                    .into(holder.itemView.img_homeF_profile)


            }


            4 -> {
                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_description.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }else{
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }
                }

                holder.itemView.txt_homeF_request.text = "برداشت از دایور"
                currentItem.transaction.description?.let {
                    holder.itemView.txt_homeF_about_cost.text = it
                }

                currentItem.transaction.amount?.let {
                    holder.itemView.txt_homeF_cost.text = it.toString()
                }

                currentItem.transaction.creation_time?.let {
                    holder.itemView.txt_homeF_history.text = time.setTime(it.toString())
                }


                currentItem.properties?.getOrNull(0)?.values?.user_fullname?.let {
                    holder.itemView.txt_homeF_name.text = it.toString()
                }

                currentItem.user_avatars?.getOrNull(0)?.url?.let {
                    picasso.load(it)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }
            }

            5 -> {
                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_description.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }else{
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }
                }

                holder.itemView.txt_homeF_request.text = " درخواست  شمااز"
                holder.itemView.txt_homeF_request.setTextColor(Color.parseColor("#0AB571"))
                currentItem.transaction.description?.let {
                    holder.itemView.txt_homeF_about_cost.text = it
                }

                currentItem.transaction.amount?.let {
                    holder.itemView.txt_homeF_cost.text = it.toString()
                }

                currentItem.transaction.creation_time?.let {
                    holder.itemView.txt_homeF_history.text = time.setTime(it.toString())
                }


                currentItem.properties?.getOrNull(0)?.values?.user_fullname?.let {
                    holder.itemView.txt_homeF_name.text = it.toString()
                }

                currentItem.user_avatars?.getOrNull(0)?.url?.let {
                    picasso.load(it)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }

            }
            6 -> {
                holder.itemView.txt_homeF_request.text = " درخواست "
                holder.itemView.txt_homeF_request.setTextColor(Color.parseColor("#F93737"))
                currentItem!!.transaction!!.status.let {
                    if (checkStatus(it!!) == "رد شده") {
                        holder.itemView.txt_homeF_description.setTextColor(Color.parseColor("#F93737"))
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }else{
                        holder.itemView.txt_homeF_description.text = checkStatus(it!!)
                    }
                }

                currentItem.transaction.amount?.let {
                    holder.itemView.txt_homeF_cost.text = it.toString()
                }

                currentItem.transaction.creation_time?.let {
                    holder.itemView.txt_homeF_history.text = time.setTime(it.toString())
                }


                currentItem.properties?.getOrNull(0)?.values?.user_fullname?.let {
                    holder.itemView.txt_homeF_name.text = it.toString()
                }

                currentItem.user_avatars?.getOrNull(0)?.url?.let {
                    picasso.load(it)
                        .placeholder(R.drawable.user).error(R.drawable.user)
                        .into(holder.itemView.img_homeF_profile)
                }

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


    private fun checkStatus(type:Int):String{
        return when(type){
            0->"درخواست جدید"
            1->"تکمیل شده"
            2->"در انتظار"
            3->"رد شده"
            else -> ""
        }

    }


}