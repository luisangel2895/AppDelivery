package io.saphi.delivery.view.adapter

import io.saphi.delivery.model.Shop

interface ShopListener {
    fun onShopClicked(shop: Shop, position: Int)
}