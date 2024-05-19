package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(private val context: Context, private val arrayList: ArrayList<Data>) : ArrayAdapter<Data>(context,
    R.layout.list_item,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item,null)

        val imageView : ImageView = view.findViewById(R.id.imageitem)
        val judulView :TextView = view.findViewById(R.id.judulitem)
        val deskripsiView : TextView = view.findViewById(R.id.deskripsiitem)

        imageView.setImageResource(arrayList[position].gambar)
        judulView.text = arrayList[position].judul
        deskripsiView.text = arrayList[position].deskripsi

        return view
    }

}
