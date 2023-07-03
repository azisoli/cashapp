package com.example.cashappproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cashappproject.model.Stock
import java.text.SimpleDateFormat
import java.util.*

class StockAdapter(private val itemList: List<Stock>) :
    RecyclerView.Adapter<StockAdapter.ListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_layout,
            parent,
            false
        )
        return ListItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.ticker.text = currentItem.ticker
        holder.name.text = currentItem.name
        holder.price.text = currentItem.current_price_cents.toString()
        holder.quantity.text = currentItem.quantity.toString()
        holder.stamp.text = convertTimestampToDate(currentItem.current_price_timestamp.toLong())
        holder.currency.text = currentItem.currency
    }

    fun convertTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp)
        val format = SimpleDateFormat("yyyy-MM-dd  HH:mm:ss", Locale.getDefault())
        return format.format(date)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
    class ListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ticker:TextView
        val name:TextView
        val currency:TextView
        val price:TextView
        val quantity:TextView
        val stamp:TextView
        init{
            ticker = view.findViewById(R.id.ticker)
            name = view.findViewById(R.id.name)
            currency = view.findViewById(R.id.currency)
            price = view.findViewById(R.id.price)
            quantity = view.findViewById(R.id.quantity)
            stamp = view.findViewById(R.id.stamp)
        }
    }
}
