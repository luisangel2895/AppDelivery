package io.saphi.delivery.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.telecom.Conference
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController

import io.saphi.delivery.R
import io.saphi.delivery.model.Shop
import kotlinx.android.synthetic.main.fragment_shop_detail.*

/**
 * A simple [Fragment] subclass.
 */
class ShopDetailFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tollbarInterShopDetail.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_back)
        tollbarInterShopDetail.setTitleTextColor(Color.BLACK)
        tollbarInterShopDetail.setNavigationOnClickListener{
            findNavController().navigate(R.id.shopsFragment)
        }

        val shop = arguments?.getSerializable("shop") as Shop
        tollbarInterShopDetail.title = shop.name
        //llenamos los datos de la tienda con el objeto shop

        //luego traemos un shop e imprimirlo en un recicler view de los productos



    }


}
