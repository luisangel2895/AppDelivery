package io.saphi.delivery.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.saphi.delivery.R
import io.saphi.delivery.model.Product



class ProductAdapter(val productListener: ProductListener): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    var listProducts = ArrayList<Product>()

    fun updateData(data: List<Product>){
        listProducts.clear()
        listProducts.addAll(data)
        notifyDataSetChanged()
    }

    //cuantos elementos tendra nuestra lista
    override fun getItemCount(): Int {
        return listProducts.size
    }

    //definimos el item para este recicler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))
    }

    //como enlazar los xmls
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemProductName = itemView.findViewById<TextView>(R.id.tvItemProductName)
        val tvItemProductQuantity = itemView.findViewById<TextView>(R.id.tvItemProductQuantity)
        val tvItemProductPrice = itemView.findViewById<TextView>(R.id.tvItemProductPrice)
        val ivItemProductImage = itemView.findViewById<ImageView>(R.id.ivItemProductImage)

    }


    //datos a cargar
    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val product = listProducts[position] as Product

        holder.tvItemProductName.text = product.name
        holder.tvItemProductQuantity.text = product.quantity.toString()
        holder.tvItemProductPrice.text = product.price.toString()

        Glide.with(holder.itemView.context)// con la libreria glide convertimos las url en imagenes para el holder
            .load(product.url)
            .into(holder.ivItemProductImage)


        // implementamos la interfaz mandando la conferencia y la posicion del click esto para el detalle
        holder.itemView.setOnClickListener {
            productListener.onProductClicked(product, position)
        }

    }
}