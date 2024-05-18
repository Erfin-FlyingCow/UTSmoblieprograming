package com.example.uts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.uts.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Tombol : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_tombol, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val home = view.findViewById<Button>(R.id.btnhome)
        val berita = view.findViewById<Button>(R.id.btnberita)
        val profile = view.findViewById<Button>(R.id.btnprofile)

        home.setOnClickListener {
            val fragment = Tentangapk.newInstance()
            replaceFragment(fragment)
        }

        berita.setOnClickListener {
            // Replace with the Berita Fragment
            val fragment = FragmentBerita.newInstance()
            replaceFragment(fragment)
        }

        profile.setOnClickListener {
            // Replace with the Profile Fragment
           // val fragment = ProfileFragment.newInstance()
           // replaceFragment(fragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentteksapk, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tombol().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
