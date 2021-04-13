package io.saphi.delivery.model

import java.io.Serializable

data class Shop(var key: String, var name: String, var type: String, var description: String, var url_shop: String, var products: Array<Product>) : Serializable
