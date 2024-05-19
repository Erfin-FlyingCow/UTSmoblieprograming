package com.example.uts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.fragments.OptionMenu
import com.example.uts.fragments.Tombol

class Profile : AppCompatActivity() {

    lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile)

        sharedPreferences = getSharedPreferences("Data",Context.MODE_PRIVATE)

        val vemail = findViewById<TextView>(R.id.email)
        val vnim = findViewById<TextView>(R.id.nim)
        val vnama = findViewById<TextView>(R.id.nama)
        val vkelas = findViewById<TextView>(R.id.kelas)
        val logout = findViewById<Button>(R.id.btnlogut)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmenttombol, Tombol())
                .replace(R.id.fragmentoptionmenu, OptionMenu())
                .commitNow()

        }

        logout.setOnClickListener(){
            Intent(this,Login::class.java).also {
                startActivity(it)
                finish()
            }
        }

        val email = sharedPreferences.getString("email", "defaultEmail")
        val nama = sharedPreferences.getString("nama", "defaultNama")
        val nim = sharedPreferences.getString("nim", "defaultNim")
        val kelas = sharedPreferences.getString("kelas", "defaultKelas")

        vemail.text = email
        vnama.text = nama
        vnim.text = nim
        vkelas.text = kelas
    }
}