package com.example.agenda

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agenda.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private var _binding: FragmentListBinding?=null
    private val binding get()= _binding!!
    private lateinit var friendsDBHelper : MySQLiteHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsDBHelper = MySQLiteHelper(this.requireContext())
        val manager= LinearLayoutManager(this.context)
        val decoration=DividerItemDecoration(this.context,manager.orientation)
        binding.recyclerContacts.layoutManager=manager
        binding.recyclerContacts.addItemDecoration(decoration)
        binding.recyclerContacts.adapter= ContactsAdapter(sqliteToList())



    }
    fun sqliteToList(): MutableList<Contacts>{

        val lista = mutableListOf<Contacts>()
        val db : SQLiteDatabase = friendsDBHelper.readableDatabase
        val cursor = db.rawQuery ("SELECT * FROM ${MySQLiteHelper.TABLE_NAME}", null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Contacts(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        return lista
    }
}