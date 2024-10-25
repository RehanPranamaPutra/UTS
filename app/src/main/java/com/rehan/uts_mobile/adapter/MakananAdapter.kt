package com.rehan.uts_mobile.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rehan.uts_mobile.DetailMakananActivity
import com.rehan.uts_mobile.Makanan
import com.rehan.uts_mobile.R
import com.rehan.uts_mobile.model.ModelMakanan

class MakananAdapter(
    val itemList :ArrayList<ModelMakanan>,
    val getActivity: Makanan
): RecyclerView.Adapter<MakananAdapter.MyViewHolder>(){
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var gambarMakanan : ImageView
        var namaMakanan : TextView
        var detailMakanan : TextView

        init {
            gambarMakanan = itemView.findViewById(R.id.gambarMakanan) as ImageView
            namaMakanan = itemView.findViewById(R.id.namaMakanan) as TextView
            detailMakanan = itemView.findViewById(R.id.detailMakanan) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_makanan, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.gambarMakanan.setImageResource(itemList[position].gambarMakanan)
        holder.namaMakanan.setText(itemList[position].namaMakanan)
        holder.detailMakanan.setText(itemList[position].detailMakanan)

        holder.itemView.setOnClickListener() {
            val intent = Intent(getActivity, DetailMakananActivity::class.java)
            intent.putExtra("gambarMakanan", itemList[position].gambarMakanan)
            intent.putExtra("namaMakanan", itemList[position].namaMakanan)

            getActivity.startActivity(intent)
        }
    }

}