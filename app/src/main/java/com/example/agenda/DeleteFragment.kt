package com.example.agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.agenda.databinding.FragmentDeleteBinding
import com.example.agenda.databinding.FragmentListBinding


class DeleteFragment : Fragment() {
    private var _binding: FragmentDeleteBinding?=null
    private val binding get()= _binding!!
    private lateinit var friendsDBHelper : MySQLiteHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeleteBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsDBHelper = MySQLiteHelper(requireContext())

        binding.btnDelete.setOnClickListener {
            var affected = 0
            if (binding.etId.text.isNotBlank()){
                affected = friendsDBHelper.deleteData(binding.etId.text.toString().toInt())
                binding.etId.text.clear()

                toast("¡Borrado!")
            }
            toast("Datos borrados: $affected", Toast.LENGTH_LONG)
        }
    }



}