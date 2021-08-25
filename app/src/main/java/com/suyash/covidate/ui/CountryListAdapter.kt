package com.suyash.covidate.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suyash.covidate.databinding.TextViewItemBinding
import com.suyash.covidate.network.CovidLocal

class CountryListAdapter(val clickListener: OnClickListener) : RecyclerView.Adapter<CountryListAdapter.TextViewHolder>(){

    var data = listOf<CovidLocal>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class TextViewHolder private constructor(val binding: TextViewItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(
            item:CovidLocal,
            clickListener: OnClickListener
        ){
            binding.countryitem.text = item.Country
            binding.clickListener = clickListener
            binding.covid = item

        }
        companion object{
            fun from(parent: ViewGroup):TextViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = TextViewItemBinding.inflate(inflater,parent,false)
                return TextViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder.from(parent)
    }

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(data[position],clickListener)
    }

    class OnClickListener(val clickListener: (item:CovidLocal) -> Unit){
        fun onClick(covid:CovidLocal) = clickListener(covid)
    }}
