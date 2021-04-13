package io.saphi.delivery.network

import io.saphi.delivery.model.Product
import io.saphi.delivery.model.Shop
import io.saphi.delivery.network.data.Data

class MongoService {
    //primero nos conectamos a la dd
    val data = Data()

    //luego creamos funciones para mostrar los datos

        //funcion para traer los shops
        fun getShops(type: String, callback: Callback<List<Shop>>){
            //funcion para traer los datos de la db con SecurityManager
            val shops = data.shops
            //funcion de filtrado segun el type
            var shopsType = arrayListOf<Shop>()
            shopsType.clear()
            for (shop in shops){
                if (shop.type == type) {
                    shopsType.add(shop)
                }
        }
            //cuando termine el filtrado se lo enviamos como parametro al callback
            callback.onSuccess(shopsType)
        }

        //funcion para traer los productos de una tienda determinada
        fun getProducts(key_shop: String, callback: Callback<List<Product>>){
            //funcion para traer los datos de la db con SecurityManager
            val shops = data.shops
            //funcion del filtrado segun el id_shop
            var products = arrayListOf<Product>()
            products.clear()

            for (shop in shops){
                if (shop.key == key_shop){
                    for(product in shop.products){
                        products.add(product)
                    }
                }
            }
            //cuando termine el filtrado se lo enviamos como parametro al callback
            callback.onSuccess(products)
        }


}