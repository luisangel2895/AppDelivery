package io.saphi.delivery.model

import java.io.Serializable

data class Product(var id: Int, var name: String, var quantity: Int, var url: String, var price: Double): Serializable