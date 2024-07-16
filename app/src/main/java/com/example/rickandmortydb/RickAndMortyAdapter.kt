package com.example.rickandmortydb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortydb.databinding.ItemProfileCardBinding


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
        }
    }
}