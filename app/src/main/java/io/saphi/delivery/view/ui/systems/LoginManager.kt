package io.saphi.delivery.view.ui.systems

import io.saphi.delivery.model.User
import io.saphi.delivery.network.Callback
import io.saphi.delivery.network.data.Data
import java.lang.Exception

class LoginManager {
    //conexion a la db
    val data = Data()


    fun getUser(email: String, password: String, callback: Callback<User>){
        //traemos la db de usuarios con security
        val users = data.users
        //hacemos la autenticacion
        for (user in users){
            if (user.email.equals(email) and user.password.equals(password)){
                //con esto autenticamos y si cumple lo enviamos al callback
                callback.onSuccess(user)
            }
        }
        callback.onFailed(Exception("El usuario o la contrasena son incorrectos"))
    }

    //fun setUser()





}