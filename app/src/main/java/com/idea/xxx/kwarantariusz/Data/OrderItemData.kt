package com.idea.xxx.kwarantariusz.Data

data class OrderItemData (val id_order: String,
                          val id_needy: String,
                          val id_quaranteer: String,
                          val products: List<Product>,
                          val description: String,
                          val max_spend: String,
                          val status: String,
                          val address: String,
                          val payment: String,
                          val id_account: String,
                          val role: String,
                          val phone: String,
                          val password: String,
                          val id_city: String,
                          val first_name: String,
                          val last_name: String,
                          val age: String,
                          val hero_points: String)
{
    fun getProductNames(): List<String>
    {
        val productList: MutableList<String> = mutableListOf()
        for(prod in products)
        {
            productList.add(prod.name)
        }

        return productList
    }
}


data class Product(
 val id_product: String,
 val id_order: String,
 val name: String
)

// do zmiany: niech wszystki id będą zwracane jako liczby, nie stringi
// czy w product list jest potrzebne aż tyle danych?
// payment, id_account, role, password, age, hero_points wywalić
// phone zmienić na needy_phone
// zmienic first name i last name na 1 pole - needy_name oraz dodac pole quaranteer_name

//        "id_order":"1",
//        "id_needy":"1",
//        "id_quaranteer":"0",
//        "description":"0",
//        "max_spend":"50",
//        "payment":"0",
//        "status":"new",
//        "id_account":"1",
//        "role":"needy",
//        "phone":"999888777",
//        "password":"password",
//        "first_name":"Jadwiga",
//        "last_name":"Wrona",
//        "id_city":"842",
//        "age":"48",
//        "address":"Mickiewicza 38",
//        "hero_points":"0",
//        "products":[{"id_product":"1",
//            "id_order":"1","name":"10 rolek papieru toaletowego"},
//        {"id_product":"2","id_order":"1","name":"4 mleka"},
//        {"id_product":"3","id_order":"1","name":"p\u0142atki \u015bniadaniowe"},
//        {"id_product":"4","id_order":"1","name":"m\u0105ka"},
//        {"id_product":"5","id_order":"1","name":"majonez"},
//        {"id_product":"6","id_order":"1","name":"pizza mro\u017cona guseppe"},
//        {"id_product":"7","id_order":"1","name":"tymbrak 2l"}]},