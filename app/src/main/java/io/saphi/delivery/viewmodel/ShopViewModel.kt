package io.saphi.delivery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.saphi.delivery.model.Shop
import io.saphi.delivery.network.Callback
import io.saphi.delivery.network.MongoService
import java.lang.Exception

class ShopViewModel : ViewModel(){
    //traemos una instancia del servicio de conexion
    val mongoService = MongoService()
    //creamos una lista de livedata
    var listShop: MutableLiveData<List<Shop>> = MutableLiveData()
    //creamos una variable boleana para actualizar nuestra ui de carga
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(type: String){
        getShopsFromMongo(type)
    }

    fun getShopsFromMongo(type: String) {
        mongoService.getShops(type ,object : Callback<List<Shop>> {
            override fun onSuccess(result: List<Shop>?) {
                listShop.postValue(result)
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