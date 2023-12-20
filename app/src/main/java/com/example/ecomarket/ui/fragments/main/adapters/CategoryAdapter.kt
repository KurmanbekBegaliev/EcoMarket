package com.example.ecomarket.ui.fragments.main.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecomarket.data.models.CategoryItem
import com.example.ecomarket.databinding.CategoryItemBinding
import com.example.ecomarket.tools.showImage

class CategoryAdapter(
    private val onClick : (id: Int) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var categories = arrayListOf<CategoryItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(it: List<CategoryItem>) {
        categories = it as ArrayList<CategoryItem>
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryItem: CategoryItem) {
            binding.apply {
                tvTitle.text = categoryItem.name
                image.showImage(categoryItem.image)
            }

            itemView.setOnClickListener {
                categoryItem.id?.toString()?.let { it1 -> onClick(it1.toInt()) }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }


}