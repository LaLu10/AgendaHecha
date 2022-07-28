package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.agenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId){
                R.id.opLista -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.listFragment)
                    true
                }
                R.id.opNew -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.newFragment)
                    true
                }
                R.id.opUpdate -> {
                    binding.fragmentContainerView.findNavController()
                        .navigate(R.id.updateFragment)
                    true
                }
                R.id.opDelete ->{
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.deleteFragment)
                    true
                }
                else -> false
            }

        }

    }
}