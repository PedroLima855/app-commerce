package com.my.appcommerce.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.my.appcommerce.ProductDetailActivity
import com.my.appcommerce.R
import com.my.appcommerce.model.Product

class ProductAdatpter (val list: List<Product>, val context: Context) : RecyclerView.Adapter<ProductAdatpter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = list[position]
        holder.title.text = product.title
        holder.imageView.setImageResource(R.drawable.camiseta_mockup)
        holder.cardView.setOnClickListener{
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("PRODUCT", product)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_product_image)
        val title: TextView = itemView.findViewById(R.id.tv_product_title)
        val cardView: CardView = itemView.findViewById(R.id.cv_product_item)
    }

}