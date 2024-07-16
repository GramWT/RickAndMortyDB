package com.example.rickandmortydb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortydb.R
import com.example.rickandmortydb.model.ResultsItem
import com.example.rickandmortydb.databinding.ItemProfileCardBinding
import com.example.rickandmortydb.utils.ViewUtils.gone
import com.example.rickandmortydb.utils.ViewUtils.visible


class RickAndMortyAdapter() : RecyclerView.Adapter<RickAndMortyAdapter.ViewHolder>() {

    private var itemList: ArrayList<ResultsItem?> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ViewHolder(holder.itemView).bind(itemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_profile_card, parent, false
            )
        )
    }

    override fun getItemCount(): Int = itemList.size

    fun setData(dataList: ArrayList<ResultsItem?>) {
        this.itemList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemBinding = ItemProfileCardBinding.bind(itemView)

        fun bind(data: ResultsItem?) {
            itemBinding.nameTextView.text = data?.name

            Glide.with(itemView.context)
                .load(data?.image)
                .into(itemBinding.profileImageView)


            val colorStateList = when(data?.status?.lowercase()){
                "alive" -> {
                    ContextCompat.getColorStateList(itemView.context, R.color.green_50)
                }
                "unknown" -> {
                    ContextCompat.getColorStateList(itemView.context, R.color.gray_df)
                }
                "dead" -> {
                    ContextCompat.getColorStateList(itemView.context, R.color.red_e4)
                }
                else -> {
                    ContextCompat.getColorStateList(itemView.context, R.color.gray_df)
                }
            }
            itemBinding.statusImageView.backgroundTintList = colorStateList
            data?.status?.also {
                itemBinding.statusTextView.text = it
                itemBinding.statusTextView.visible()
                itemBinding.statusImageView.visible()
            }?:{
                itemBinding.statusTextView.gone()
                itemBinding.statusImageView.gone()
            }
        }
    }
}