package com.idea.xxx.kwarantariusz

import android.app.Activity
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
import android.telecom.Call
import com.idea.xxx.kwarantariusz.Adapters.OrderRecyclerViewAdapter
import com.idea.xxx.kwarantariusz.Data.OrderItemData
import kotlinx.android.synthetic.main.tableorder_fragment.*
import javax.security.auth.callback.Callback


class TableOrderFragment : Fragment() {

    lateinit var context: FragmentActivity
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var orderRecyclerViewAdapter: OrderRecyclerViewAdapter
    val orderArray= ArrayList<OrderItemData>()

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
            getString(R.string.shopping_lists) + ": Koluszki"  // This line changes the title in the top bar

        linearLayoutManager = LinearLayoutManager(context)
        tableorder_recyclerview.layoutManager = linearLayoutManager

        val bundle = this.arguments
        val level = bundle?.getString("level")
        val subject = bundle?.getString("subject")


        val tempProductList1: ArrayList<String> = arrayListOf("8 relek papieru toaletowego", "2 mleka", "masło")
        orderArray.add(OrderItemData(3,4, "Stanisław Fizykowski", "123123123", 5, "Andrzej Pomocny", tempProductList1, "Jestem starszą osobą", 100, "waiting", "Polna 2"))
        val tempProductList2: ArrayList<String> = arrayListOf("3 wody", "2 chleby")
        orderArray.add(OrderItemData(4,5, "Zofia Mak", "444555666", 6, "Olaf Dobry", tempProductList2, "Zaplace 10 zloty", 200, "waiting", "Cicha 3"))
        val tempProductList3: ArrayList<String> = arrayListOf("makaron", "leki", "cukier", "ldbfkk l;kfdgl;hkdf llkdfl;hf lklfdh ldfgl;kdf dlfhl;fl ldkflhfk ldkhl;k")
        orderArray.add(OrderItemData(5,6, "Stanisław Fizykows", "888999888", 7, "Mateusz Superowski", tempProductList3, "Jestem starszą osobą", 50, "waiting", "Rewolucji 158"))

        orderRecyclerViewAdapter = OrderRecyclerViewAdapter(orderArray, context)
        tableorder_recyclerview.adapter = orderRecyclerViewAdapter

//        MainActivity.client.getOfferBySubjectAndLevel(subject.toString(), level.toString())
//            .enqueue(object : Callback<OffersDto> {
//                override fun onResponse(
//                    call: Call<OffersDto>,
//                    response: retrofit2.Response<OffersDto>
//                ) {
//                    val offersDto = response.body()?.offers
//                    for (offer in offersDto!!) {
//                        orderArray.add(
//                            OrderItemData(
//                                offer.ID,
//                                offer.price_per_hour.toString(),
//                                offer.rate.toString(),
//                                "null", //TODO dorobić
//                                offer.description
//                            )
//                        )
//                    }
//                    orderRecyclerViewAdapter = OrderRecyclerViewAdapter(orderArray, context)
//                    tableorder_recyclerview.adapter = orderRecyclerViewAdapter
//
//                }
//
//                override fun onFailure(call: Call<OffersDto>, t: Throwable) {
//                    Toast.makeText(
//                        context,
//                        "Error in Order Table Fragment",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            })


        val fragmentManager: FragmentManager = context.supportFragmentManager
        val registerFragment = RegisterFragment()

    }

}
