package com.kanyideveloper.onboardingscreensdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kanyideveloper.onboardingscreensdemo.databinding.MyBeerRowBinding

class BeersAdapter : ListAdapter<Beers.BeersItem,BeersAdapter.MyViewHolder>(MyDiffUtil) {
    object MyDiffUtil : DiffUtil.ItemCallback<Beers.BeersItem>(){
        override fun areItemsTheSame(oldItem: Beers.BeersItem, newItem: Beers.BeersItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Beers.BeersItem,
            newItem: Beers.BeersItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }
    inner class MyViewHolder(private val binding: MyBeerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(beer: Beers.BeersItem?) {
            binding.beerName.text = beer?.name
            binding.beerDescription.text = beer?.description
            Glide.with(binding.beerImage)
                .load(beer?.imageUrl)
                .into(binding.beerImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(MyBeerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val beer = getItem(position)
        holder.bind(beer)
    }
}