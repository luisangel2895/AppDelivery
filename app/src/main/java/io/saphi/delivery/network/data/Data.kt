package io.saphi.delivery.network.data

import io.saphi.delivery.model.Product
import io.saphi.delivery.model.Shop
import io.saphi.delivery.model.User

class Data {

    val shops: Array<Shop> = arrayOf(
        Shop("cTqU5wGCdj","Don Pepe","food","es la tienda de la propaganda xd", "https://picsum.photos/350/200",
            arrayOf(
                Product(1, "leche", 2, "https://picsum.photos/100",10.4),
                Product(2, "comino", 2, "https://picsum.photos/100",5.5),
                Product(3, "alverjas", 3, "https://picsum.photos/100",4.5),
                Product(3, "cebolla", 1, "https://picsum.photos/100",2.3),
                Product(3, "papa", 4, "https://picsum.photos/100",4.5)
            )
        ),
        Shop("Fi9iWHJjkz","Microsoft","tecnology","viva el imperio del tio Bill >:v", "https://picsum.photos/350/200",
            arrayOf(
                Product(4, "chocolate", 2, "https://picsum.photos/100",4.5),
                Product(5, "cebolla", 3, "https://picsum.photos/100",10.4),
                Product(6, "gaseosa", 4, "https://picsum.photos/100",4.6)
            )
        ),
        Shop("TNEXrbBqND","Apple","tecnology","Adios Steve ;v", "https://picsum.photos/350/200",
            arrayOf(
                Product(4, "macbook", 5, "https://picsum.photos/100", 6.5),
                Product(5, "celular", 3, "https://picsum.photos/100",4.5),
                Product(6, "tigre", 1, "https://picsum.photos/100",2.7)
            )
        ),
        Shop("jLXvVWPi5C","BCP","economy","es la empresa del tio Romero :3", "https://picsum.photos/350/200",
            arrayOf(
                Product(7, "leche", 4, "https://picsum.photos/100",8.4),
                Product(8, "pan", 6, "https://picsum.photos/100",4.5),
                Product(9, "queso", 7, "https://picsum.photos/100",6.8),
                Product(8, "mantequilla", 1, "https://picsum.photos/100",4.5),
                Product(8, "cafe", 3, "https://picsum.photos/100",5.5),
                Product(8, "celular", 5, "https://picsum.photos/100",5.8),
                Product(8, "taza", 7, "https://picsum.photos/100",5.8),
                Product(8, "mesa", 2, "https://picsum.photos/100",5.99),
                Product(8, "laptop", 4, "https://picsum.photos/100",3.76),
                Product(8, "reloj", 20, "https://picsum.photos/100",4.87)
            )
        )
    )


    val users: Array<User> = arrayOf(
        User(1, "luis", "luis@gmail.com","secret_luis", "https://picsum.photos/100"),
        User(2, "cesar", "cesar@gmail.com","secret_cesar", "https://picsum.photos/100")
    )


    fun getDbShops() : Array<Shop>{
        return shops
    }

    fun getDbUsers() : Array<User>{
        return users
    }

}