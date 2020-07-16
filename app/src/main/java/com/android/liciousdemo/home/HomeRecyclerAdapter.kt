package com.android.liciousdemo.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.android.liciousdemo.BR
import com.android.liciousdemo.databinding.ViewProductItemBinding
import com.android.liciousdemo.model.ViewType

class HomeRecyclerAdapter : RecyclerView.Adapter<HomeRecyclerAdapter.ProductViewHolder>() {

    private var productList = mutableListOf<ViewType<Any>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(ViewProductItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.updateView(productList[position])
    }

    public fun setData(products: List<ViewType< Any>>) {
        products.let {
            productList.apply {
                clear()
                addAll(products)
                notifyDataSetChanged()
            }
        }
    }

    class ProductViewHolder(val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun updateView(viewType: ViewType<Any>) {
            viewDataBinding.setVariable(BR.model, viewType)
            viewDataBinding.executePendingBindings()
        }
    }
}