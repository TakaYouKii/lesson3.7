package com.example.lesson37

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson37.databinding.CharacterItemsBinding

import java.text.FieldPosition

class CharacterAdapter(val CharacterList: ArrayList<Character>,val onClick:(position: Int)->Unit ):
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding:CharacterItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = CharacterList[adapterPosition]
            binding.tvName.text = item.name
            binding.tvIsAlive.text = item.isAlive
            binding.tvId.text = (adapterPosition+1).toString()
            item.image?.let { binding.imgItem.loadImage(it) }
            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CharacterItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return CharacterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }


}