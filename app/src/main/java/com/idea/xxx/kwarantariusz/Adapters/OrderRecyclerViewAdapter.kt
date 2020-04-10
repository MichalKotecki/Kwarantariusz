package com.idea.xxx.kwarantariusz.Adapters

import android.os.Bundle
import android.view.View

import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.idea.xxx.kwarantariusz.Data.OrderItemData
import com.idea.xxx.kwarantariusz.R
import kotlinx.android.synthetic.main.single_order_in_recyclerview_layout.view.*
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.annotation.SuppressLint
import android.net.Uri


class OrderRecyclerViewAdapter (private val OrderList: ArrayList<OrderItemData>, context: FragmentActivity)  : RecyclerView.Adapter<OrderRecyclerViewAdapter.OrderHolder>() {

    private  var context: FragmentActivity = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        // to uruchomi Extension Function z ExtensionsOrder
        val inflatedView = parent.inflate(R.layout.single_order_in_recyclerview_layout, false)
        return OrderHolder(inflatedView, context)
    }

    override fun getItemCount(): Int {
        return OrderList.size
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        val itemOrder = OrderList[position]
        holder.bindOrder(itemOrder)
    }



    class OrderHolder(v: View, context: FragmentActivity) : RecyclerView.ViewHolder(v), View.OnClickListener {

        override fun onClick(p0: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        private var view: View = v
        private  var context: FragmentActivity = context
        private var order: OrderItemData? = null
        val bundle=Bundle()
        var id_order: Long = 0

        init {
            v.setOnClickListener(this)
        }

        @SuppressLint("MissingPermission")
        fun bindOrder(order: OrderItemData){
            this.order = order
            view.order_street_textView.text = order.address
            view.order_max_spent_textView.text = order.max_spend.toString() + " " + context.resources.getString(com.idea.xxx.kwarantariusz.R.string.currency)
            view.order_name_textView.text = order.first_name + " " + order.last_name
            view.order_phone_textView.text = context.resources.getString(com.idea.xxx.kwarantariusz.R.string.countrycallingcode) + " " + order.phone
            view.order_description_textView.text = order.description
            view.order_products_textView.text = order.getProductNames().joinToString()




            bundle.putLong("id_order", id_order)

//            view.order_call_button.setOnClickListener {
//                val callIntent = Intent(Intent.ACTION_CALL)
//                callIntent.data = Uri.parse("tel:" + order.needy_phone)
//                context.startActivity(callIntent)
//            }

            view.order_help_button.setOnClickListener {
                val fragmentManager: FragmentManager =  context.supportFragmentManager

//                val tableCommentFragment = TableCommentFragment()
//                tableCommentFragment.arguments=bundle
//                fragmentManager.beginTransaction()
//                    .setCustomAnimations(R.anim.in_up, R.anim.out_down)
//                    .replace(R.id.containerForFragment, tableCommentFragment).commit()
            }

        }
    }


}