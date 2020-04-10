package com.idea.xxx.kwarantariusz

import android.app.Activity
import android.app.DownloadManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.AsyncTask
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.idea.xxx.kwarantariusz.Adapters.OrderRecyclerViewAdapter
import com.idea.xxx.kwarantariusz.DTO.Order.OrdersListFromCityWithGivenIDDTO
import com.idea.xxx.kwarantariusz.Data.OrderItemData
import kotlinx.android.synthetic.main.tableorder_fragment.*
import org.json.JSONArray
import org.json.JSONObject



class TableOrderFragment : Fragment() {

    lateinit var context: FragmentActivity
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var orderRecyclerViewAdapter: OrderRecyclerViewAdapter
    val orderArray= ArrayList<OrderItemData>()
    lateinit var queue: RequestQueue

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tableorder_fragment, container, false)
    }

    override fun onAttach(activity: Activity) {
        context = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.shopping_lists) + ": Glasgow"  // This line changes the title in the top bar

        linearLayoutManager = LinearLayoutManager(context)
        tableorder_recyclerview.layoutManager = linearLayoutManager

//        val bundle = this.arguments
//        val level = bundle?.getString("level")
//        val subject = bundle?.getString("subject")


//        val tempProductList1: ArrayList<String> = arrayListOf("8 relek papieru toaletowego", "2 mleka", "masło")
//        orderArray.add(OrderItemData(3,4, "Stanisław Fizykowski", "123123123", 5, "Andrzej Pomocny", tempProductList1, "Jestem starszą osobą", 100, "waiting", "Polna 2"))
//        val tempProductList2: ArrayList<String> = arrayListOf("3 wody", "2 chleby")
//        orderArray.add(OrderItemData(4,5, "Zofia Mak", "444555666", 6, "Olaf Dobry", tempProductList2, "Zaplace 10 zloty", 200, "waiting", "Cicha 3"))
//        val tempProductList3: ArrayList<String> = arrayListOf("makaron", "leki", "cukier", "ldbfkk l;kfdgl;hkdf llkdfl;hf lklfdh ldfgl;kdf dlfhl;fl ldkflhfk ldkhl;k")
//        orderArray.add(OrderItemData(5,6, "Stanisław Fizykows", "888999888", 7, "Mateusz Superowski", tempProductList3, "Jestem starszą osobą", 50, "waiting", "Rewolucji 158"))



        val tempProductList1: ArrayList<String> = arrayListOf("10 rolls of toilet paper", "4 milks", "cereals", "flour", "mayonnaise", "pizza", "orange juice")
        orderArray.add(OrderItemData(3, 4, "Emily Smith", "999888777", 5, "Andrzej Pomocny", tempProductList1, "I'm senior", 50, "new", "Hope St. 38"))

        val tempProductList2: ArrayList<String> = arrayListOf("4 mineral waters", "ham", "sliced bread", "butter")
        orderArray.add(OrderItemData(3, 4, "Stan Barnes", "123123123", 5, "Andrzej Pomocny", tempProductList2, "Shopping from Costco", 30, "new", "Castle St. 2"))

        val tempProductList3: ArrayList<String> = arrayListOf("4 kilos of chicken", "2 sliced breads", "butter", "2 milks", "cereals", "cocoa")
        orderArray.add(OrderItemData(3, 4, "John Bean", "456456456", 5, "Andrzej Pomocny", tempProductList3, "I am disabled", 80, "new", "Duck St. 112"))

        val tempProductList4: ArrayList<String> = arrayListOf("tee", "sugar", "spaghetti pasta", "spaghetti sauce")
        orderArray.add(OrderItemData(3, 4, "Hillary June", "321321321", 5, "Andrzej Pomocny", tempProductList4, "please help", 40, "new", "North St. 19"))

        val tempProductList5: ArrayList<String> = arrayListOf("3 kilos of chicken", "beef", "headache medicine", "stock cubes", "pasta", "3 juices", "1 kilo of cake")
        orderArray.add(OrderItemData(3, 4, "Mark Lee", "654654654", 5, "Andrzej Pomocny", tempProductList5, "I'm very ill. :(", 80, "new", "Royal St. 73"))


//        val city_id: Long = 5
//        MainActivity.client.getAllOrderFromCityWithGivenID(city_id)
//            .enqueue(object : Callback<OrdersListFromCityWithGivenIDDTO> {
//
//                override fun onFailure(call: Call<OrdersListFromCityWithGivenIDDTO>, t: Throwable) {
////                    Toast.makeText(
////                        context,
////                        "Error in Order Table Fragment",
////                        Toast.LENGTH_SHORT
////                    ).show()
//                }
//
//                override fun onResponse(
//                    call: Call<OrdersListFromCityWithGivenIDDTO>,
//                    response: retrofit2.Response<OrdersListFromCityWithGivenIDDTO>
//                ) {
//                    val ordersDTO = response.body()?.orders
//                    for (order in ordersDTO!!)
//                    {
//                        orderArray.add(
//                            OrderItemData
//                            (
//                                order.id_order,
//                                order.id_needy,
//                                order.needy_name,
//                                order.phone,
//                                order.id_quaranteer,
//                                order.quaranteer_name,
//                                order.products,
//                                order.description,
//                                order.max_spend,
//                                order.status,
//                                order.address
//                            )
//                        )
//                    }
//                    orderRecyclerViewAdapter = OrderRecyclerViewAdapter(orderArray, context)
//                    tableorder_recyclerview.adapter = orderRecyclerViewAdapter
//
//                }
//
//            }
//        )



        // Volley
        queue = Volley.newRequestQueue(context)
        val URL: String = "https://my-json-server.typicode.com/typicode/demo/posts"


        val stringRequest = StringRequest(Request.Method.GET, URL,
            Response.Listener<String> { response ->

                val post = Gson().fromJson(response, Array<Post>::class.java)
                Toast.makeText(context, post[2].title, Toast.LENGTH_SHORT ).show()
            },
            Response.ErrorListener {
                Toast.makeText(context, "Volley does not work.", Toast.LENGTH_SHORT ).show()
            })

        queue.add(stringRequest)



        orderRecyclerViewAdapter = OrderRecyclerViewAdapter(orderArray, context)
        tableorder_recyclerview.adapter = orderRecyclerViewAdapter


        val fragmentManager: FragmentManager = context.supportFragmentManager
        val registerFragment = RegisterFragment()

    }

}

data class Post(val id: Int, val title: String = "")
