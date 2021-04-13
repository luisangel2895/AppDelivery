package io.saphi.delivery.viewmodel

import androidx.lifecycle.MutableLiveData
import io.saphi.delivery.model.Product
import io.saphi.delivery.network.Callback
import io.saphi.delivery.network.MongoService
import java.lang.Exception

class ProductViewModel {
    //traemos una instancia del servicio de conexion
    val mongoService = MongoService()
    //creamos una lista de livedata
    var listProducts: MutableLiveData<List<Product>> = MutableLiveData()
    //creamos una variable boleana para actualizar nuestra ui de carga
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(type: String){
        getProductsFromMongo(type)
    }

    fun getProductsFromMongo(key: String) {
        mongoService.getProducts(key ,object : Callback<List<Product>> {
            override fun onSuccess(result: List<Product>?) {
                listProducts.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }


}