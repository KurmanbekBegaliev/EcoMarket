package com.example.ecomarket.ui.fragments.products.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecomarket.data.models.ProductsItem
import com.example.ecomarket.databinding.ProductsItemBinding
import com.example.ecomarket.tools.showImage

class ProductsAdapter(
    private val onClick: () -> Unit
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private var products = arrayListOf<ProductsItem>()


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(it: List<ProductsItem>) {
        products = it as ArrayList<ProductsItem>
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ProductsItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductsItem) {
             binding.apply {
                 tvTitleProduct.text = product.title
                 tvPriceCounter.text = product.price
                 imgProduct.showImage(product.image)
             }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ProductsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }
}