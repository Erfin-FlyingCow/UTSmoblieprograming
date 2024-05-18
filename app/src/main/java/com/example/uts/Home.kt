package com.example.uts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.DisplayShape
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.fragments.OptionMenu
import com.example.uts.fragments.Tentangapk
import com.example.uts.fragments.Tombol

class Home : AppCompatActivity() {

    private var sharedPreferences: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmenttombol, Tombol())
                .replace(R.id.fragmentoptionmenu, OptionMenu())
                .replace(R.id.fragmentteksapk, Tentangapk())
                .commitNow()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Menginflasi menu; menambahkan item ke action bar jika ada.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Menangani klik pada item menu
        return when (item.itemId) {
            R.id.action_tambahdata -> {
                // Tindakan untuk menu "About"
                true
            }

            R.id.action_dataalumni -> {
                // Tindakan untuk menu "Settings"
                true
            }

            R.id.action_logout -> {

                true
            }

            else -> super.onOptionsItemSelected(item)
        }


    }
}