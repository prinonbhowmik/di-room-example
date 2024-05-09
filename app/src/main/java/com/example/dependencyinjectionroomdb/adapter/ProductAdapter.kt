package com.example.dependencyinjectionroomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dependencyinjectionroomdb.databinding.ProductItemBinding
import com.example.dependencyinjectionroomdb.models.ProductList

class ProductAdapter(private val productList : List<ProductList> ) : RecyclerView.Adapter<ProductAdapter.ItemViewHolder>()  {
    inner class ItemViewHolder(val binding : ProductItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =  ProductItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val product = productList[position]
        holder.apply {

            binding.apply {
                Glide.with(itemView).load(product.image).into(imgShop)
                txtName.text = product.title
                txtDescription.text = product.description
                txtCategory.text = product.category
                txtPresentPrice.text = "$${product.price}"

            }

        }
    }
}