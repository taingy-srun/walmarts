package com.taingy.walmarts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.taingy.walmarts.model.Product

class ProductAdapter(val context: Context, private val dataSet: List<Product>, val isCartView: Boolean) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_product, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.title.text = dataSet[position].productName
        viewHolder.description.text = dataSet[position].productDescription
        viewHolder.price.text = "$${dataSet[position].cost}"
        viewHolder.image.setImageDrawable(context.getDrawable(dataSet[position].image))

        if (isCartView)
            viewHolder.btAdd.visibility = View.GONE

        viewHolder.btAdd.setOnClickListener {
            ProductListActivity.productsInCart.add(dataSet[position])
            Toast.makeText(context, "Added to cart!", Toast.LENGTH_LONG).show()
        }

        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("name", dataSet[position].productName)
            intent.putExtra("description", dataSet[position].productDescription)
            intent.putExtra("price", dataSet[position].cost)
            intent.putExtra("image", dataSet[position].image)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val description: TextView
        val price: TextView
        val image : ImageView
        val btAdd : Button

        init {
            title = view.findViewById(R.id.tv_title)
            description = view.findViewById(R.id.tv_description)
            price = view.findViewById(R.id.tv_price)
            image = view.findViewById(R.id.iv_image)
            btAdd = view.findViewById(R.id.bt_add_to_cart)
        }
    }
}
