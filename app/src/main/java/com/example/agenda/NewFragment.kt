package com.example.agenda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.agenda.databinding.FragmentNewBinding


class NewFragment : Fragment() {
    private var _binding: FragmentNewBinding? = null
    private val binding get() = _binding!!
    private lateinit var friendsDBHelper : MySQLiteHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsDBHelper = MySQLiteHelper(this.requireContext())
        binding.btnAAdir.setOnClickListener {
            if (binding.etName.text.isNotBlank() &&
                binding.etApellido.text.isNotBlank() &&
                binding.etPhone.text.isNotBlank()&&
                binding.etEmail.text.isNotBlank()){
                friendsDBHelper.addData(binding.etName.text.toString(),
                    binding.etApellido.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etEmail.text.toString())
                binding.etName.text.clear()
                binding.etApellido.text.clear()
                binding.etPhone.text.clear()
                binding.etEmail.text.clear()

                toast("¡Guardado!")

            } else {
                toast("No permitido campos vacíos", Toast.LENGTH_LONG)
            }
        }
    }


}