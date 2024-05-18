package com.example.uts.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.uts.Login
import com.example.uts.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OptionMenu.newInstance] factory method to
 * create an instance of this fragment.
 */
class OptionMenu : Fragment() {

    lateinit var sharedPreferences : SharedPreferences
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    // Flag untuk mengabaikan pemanggilan pertama
    private var isFirstSelection = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner: Spinner = view.findViewById(R.id.dropdown_menu)

        val items = arrayOf("Tambah Data", "Data Alumni", "Logout")

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (isFirstSelection) {
                    isFirstSelection = false // Abaikan pemanggilan pertama
                    return
                }

                when (position) {
                    0 -> goToTambahData()
                    1 -> goToDataAlumni()
                    2 -> {
                        goToLogout()
                        deleteData()

                    }
                }

                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(requireContext(), "Anda memilih: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Tidak melakukan apa-apa
            }

            fun deleteData(){
                sharedPreferences = requireActivity().getSharedPreferences("Data", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                Toast.makeText(requireContext(), "Data tehapus", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun goToTambahData() {
        // Fungsi untuk menangani navigasi ke layar Tambah Data
        Toast.makeText(requireContext(), "Navigasi ke layar Tambah Data", Toast.LENGTH_SHORT).show()
        // Implementasi navigasi ke layar Tambah Data
    }

    private fun goToDataAlumni() {
        // Fungsi untuk menangani navigasi ke layar Data Alumni
        Toast.makeText(requireContext(), "Navigasi ke layar Data Alumni", Toast.LENGTH_SHORT).show()
        // Implementasi navigasi ke layar Data Alumni
    }

    private fun goToLogout() {
        val intent = Intent(requireActivity(), Login::class.java)
        startActivity(intent)
    }


}
