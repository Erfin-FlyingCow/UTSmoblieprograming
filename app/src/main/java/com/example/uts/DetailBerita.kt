package com.example.uts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class DetailBerita : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



            val gambar = intent.getIntExtra("gambar", R.drawable.cnn)
            val judul = intent.getStringExtra("judul")
            val deskripsi = intent.getStringExtra("deskripsi")


//            binding.detailgambar.setImageResource(gambar)
//            binding.detailjudul.text = judul
//            binding.detaildeskripsi.text= deskripsi



    }
}
