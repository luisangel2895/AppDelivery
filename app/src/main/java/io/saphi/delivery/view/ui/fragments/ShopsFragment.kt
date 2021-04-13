package io.saphi.delivery.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import io.saphi.delivery.R
import io.saphi.delivery.model.Shop
import io.saphi.delivery.view.adapter.ShopAdapter
import io.saphi.delivery.view.adapter.ShopListener
import io.saphi.delivery.viewmodel.ShopViewModel
import kotlinx.android.synthetic.main.fragment_shops.*

class ShopsFragment : Fragment(), ShopListener {
    private lateinit var shopAdapter: ShopAdapter
    private lateinit var viewModel: ShopViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shops, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ShopViewModel::class.java)
        refreshType()

        shopAdapter = ShopAdapter(this)

        rvFragmentShops.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = shopAdapter
        }

        observeViewModel()
    }

    fun refreshType(){
        val type = arguments?.getSerializable("type") as String
        viewModel.refresh(type)
    }

    fun observeViewModel(){
        viewModel.listShop.observe(this, Observer<List<Shop>> { shop ->
            shopAdapter.updateData(shop)
        })
        viewModel.isLoading.observe(this, Observer<Boolean> {
            if (it != null)
                rlFragmentShopsProgressBar.visibility = View.INVISIBLE
        })
    }

    override fun onShopClicked(shop: Shop, position: Int) {
        val bundle = bundleOf("shop" to shop)
        findNavController().navigate(R.id.shopDetailFragment, bundle)
    }


}
