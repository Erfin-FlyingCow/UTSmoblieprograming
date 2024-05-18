package com.example.uts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)

        val sharedPrefences = getSharedPreferences("Data", Context.MODE_PRIVATE)
        val email = findViewById<TextInputEditText>(R.id.inputEmail)
        val pass = findViewById<TextInputEditText>(R.id.inputPass)
        val btn = findViewById<Button>(R.id.btnLogin)

        btn.setOnClickListener() {

            if ((email.text.toString() == "muhammad.irfan.noufal.tik22@mhsw.pnj.ac.id") && (pass.text.toString() == "12345678")) {
                val editor = sharedPrefences.edit()
                editor.putString("email", "muhammad.irfan.noufal.tik22@mhsw.pnj.ac.id")
                editor.putString("nama", "Muhammad Irfan Noufal")
                editor.putString("nim", "2207411025")
                editor.putString("kelas", "TI 4A")
                editor.apply()
                goTohome()
            }
            else{
                Toast.makeText(this, "Data tidak sesuai", Toast.LENGTH_SHORT).show()
            }

        }

    }
    fun goTohome () {
        Intent(this,Home::class.java).also {
            startActivity(it)
            finish()
        }
    }
}