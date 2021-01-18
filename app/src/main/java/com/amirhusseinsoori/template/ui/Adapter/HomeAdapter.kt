package com.amirhusseinsoori.template.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.api.responses.response.DiverResponse
import com.amirhusseinsoori.template.api.responses.response.Transaction
import kotlinx.android.synthetic.main.custom_item_main.view.*

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.BlackListHolder>() {

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

    override fun onBindViewHolder(holder: HomeAdapter.BlackListHolder, position: Int) {
        val currentItem = differ.currentList[position]




        when(currentItem.transaction!!.view_type){
            1-> {
                holder.itemView.txt_homeF_name.text= "ارسال مبلغ از طرف شما به شخص دیگر"
                holder.itemView.txt_homeF_about_cost.text= currentItem.transaction.status.toString()
                holder.itemView.txt_homeF_history.text= currentItem.transaction.creation_time.toString()
            }
            2->{
                holder.itemView.txt_homeF_name.text= "دریافت مبلغ از شخص دیگر"
                holder.itemView.txt_homeF_about_cost.text= currentItem.transaction.status.toString()
                holder.itemView.txt_homeF_history.text= currentItem.transaction.creation_time.toString()
            }
            3->{
                holder.itemView.txt_homeF_name.text= "دریافت مبلغ از شخص دیگر"
                holder.itemView.txt_homeF_about_cost.text= currentItem.transaction.status.toString()
                holder.itemView.txt_homeF_history.text= currentItem.transaction.creation_time.toString()
            }
            4->{
                holder.itemView.txt_homeF_name.text= "برداشت از کیف پول و انتقال آن به یک کارت دیگر"
                holder.itemView.txt_homeF_about_cost.text= currentItem.transaction.status.toString()
                holder.itemView.txt_homeF_history.text= currentItem.transaction.creation_time.toString()
            }
            5->{
                holder.itemView.txt_homeF_name.text= "درخواست مبلغی از طرف شما ب شخص دیگر"
                holder.itemView.txt_homeF_about_cost.text= currentItem.transaction.status.toString()
                holder.itemView.txt_homeF_history.text= currentItem.transaction.creation_time.toString()
            }
            6->{
                holder.itemView.txt_homeF_name.text= "درخواست شخص دیگری از شما برای دریافت مبلغی"
                holder.itemView.txt_homeF_about_cost.text= currentItem.transaction.status.toString()
                holder.itemView.txt_homeF_history.text= currentItem.transaction.creation_time.toString()
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


}