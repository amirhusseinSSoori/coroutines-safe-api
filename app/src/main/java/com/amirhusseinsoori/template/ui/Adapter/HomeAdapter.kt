package com.amirhusseinsoori.template.ui.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amirhusseinsoori.template.R
import com.amirhusseinsoori.template.db.subdiver.TransactionSubEntity
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.custom_item_main.view.*


class HomeAdapter( val data: PortData) :
    RecyclerView.Adapter<HomeAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)


    private val differCallback = object : DiffUtil.ItemCallback<TransactionSubEntity>() {
        override fun areItemsTheSame(
            oldItem: TransactionSubEntity,
            newItem: TransactionSubEntity
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: TransactionSubEntity,
            newItem: TransactionSubEntity
        ): Boolean = oldItem.transaction == newItem.transaction
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
        val view = holder.itemView
        data.sendData(
            view.txt_homeF_name,
            view.txt_homeF_status,
            view.txt_homeF_request,
            view.txt_homeF_about_cost,
            view.txt_homeF_cost,
            view.txt_homeF_history,
            view.txt_homeF_plus,
            view.txt_diver,
            view.img_homeF_profile,
            currentItem
        )
    }


    override fun getItemCount(): Int = differ.currentList.size


    override fun getItemViewType(position: Int): Int = position


    override fun getItemId(position: Int): Long = position.toLong()



    interface PortData {

        fun sendData(
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
        )

    }


}