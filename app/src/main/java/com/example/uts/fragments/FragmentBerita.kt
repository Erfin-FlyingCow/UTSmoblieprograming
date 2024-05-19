package com.example.uts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.uts.Data
import com.example.uts.R
import com.example.uts.databinding.FragmentBeritaBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentBerita : Fragment() {

    private lateinit var binding: FragmentBeritaBinding
    private lateinit var dataArrayList: ArrayList<Data>

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        binding = FragmentBeritaBinding.bind(view)



        val gambar = intArrayOf(
            R.drawable.cnn,
            R.drawable.detik,
            R.drawable.tempo
        )

        val judul = arrayOf(
            "Elon Musk Dipastikan Ikut Resmikan Starlink di Bali Besok",
            "Ini Sekolah Pertama yang Pakai Starlink, Netizen Salfok Kecepatan Internetnya",
            "Apple Disebut Akan Mulai Produksi Panel Layar iPhone 16 pada Bulan Depan"
        )

        val deskripsi = arrayOf(
            "Musk akan melakukan peresmian layanan internet satelit Starlink ditemani sejumlah pejabat negara seperti Presiden Joko Widodo, Menteri Koordinator Bidang Kemaritiman dan Investasi (Menkomarves) Luhut Binsar Pandjaitan, Menteri Komunikasi dan Informatika (Menkominfo) Budi Arie Setiadi, dan Menteri Kesehatan (Menkes) Budi Gunadi Sadikin",
            "Layanan internet berbasis satelit Starlink milik Elon Musk kini telah digunakan oleh masyarakat Indonesia, salah satunya sekolah di Jawa Timur yang diklaim pertama kali menggunakan layanan Starlink.",
            "Hal tersebut diketahui dari postingan di Instagram milik akun @azhar.adam.abdurrohman yang mengunggah sebuah video yang menunjukkan sekolah bernama Syifaul Qulub (SQ) yang terletak di Gresik, Jawa Timur telah menjajal Starlink."
        )

        dataArrayList = ArrayList()

        for (i in gambar.indices) {

            val data = Data(gambar[i],judul[i],deskripsi[i])
            dataArrayList.add(data)

        }




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

                }
            }
    }
}
