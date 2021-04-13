package io.saphi.delivery.view.adapter

import io.saphi.delivery.model.Product


interface ProductListener {
    fun onProductClicked(product: Product, position: Int)
}