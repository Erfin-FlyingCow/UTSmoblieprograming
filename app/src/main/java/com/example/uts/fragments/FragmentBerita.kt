package com.example.uts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.uts.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentBerita : Fragment() {


    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>

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
        return inflater.inflate(R.layout.fragment_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi ListView
        listView = view.findViewById(R.id.BeritaListView)

        // Contoh data untuk ListView
        val data = listOf("Berita 1", "Berita 2", "Berita 3", "Berita 4")

        // Inisialisasi Adapter
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, data)

        // Set Adapter ke ListView
        listView.adapter = adapter

        // Tambahkan listener jika diperlukan
        listView.setOnItemClickListener { parent, view, position, id ->
            val item = adapter.getItem(position)
            Toast.makeText(requireContext(), "Clicked: $item", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentBerita().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
