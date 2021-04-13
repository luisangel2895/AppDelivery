package io.saphi.delivery.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.saphi.delivery.R
import io.saphi.delivery.model.Shop


class ShopAdapter(val shopListener: ShopListener): RecyclerView.Adapter<ShopAdapter.ViewHolder>() {
    var listShops = ArrayList<Shop>()

    fun updateData(data: List<Shop>){
        listShops.clear()
        listShops.addAll(data)
        notifyDataSetChanged()
    }

    //cuantos elementos tendra nuestra lista
    override fun getItemCount(): Int {
        return listShops.size
    }

    //definimos el item para este recicler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_shop, parent, false))
    }

    //como enlazar los xmls
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemShopName = itemView.findViewById<TextView>(R.id.tvItemShopName)
        val tvItemShopDescription = itemView.findViewById<TextView>(R.id.tvItemShopDescription)
        val ivItemShopLogo = itemView.findViewById<ImageView>(R.id.ivItemShopLogo)

    }


    //datos a cargar
    override fun onBindViewHolder(holder: ShopAdapter.ViewHolder, position: Int) {
        val shop = listShops[position] as Shop

        holder.tvItemShopName.text = shop.name
        holder.tvItemShopDescription.text = shop.description
        Glide.with(holder.itemView.context)// con la libreria glide convertimos las url en imagenes para el holder
            .load(shop.url_shop)
            .into(holder.ivItemShopLogo)


        // implementamos la interfaz mandando la conferencia y la posicion del click esto para el detalle
        holder.itemView.setOnClickListener {
            shopListener.onShopClicked(shop, position)
        }

    }



}