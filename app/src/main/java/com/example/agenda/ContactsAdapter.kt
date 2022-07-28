package com.example.agenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private val contactsList: List<Contacts>) : RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContactsViewHolder(layoutInflater.inflate(R.layout.item_contacts, parent, false))
    }
    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val item = contactsList[position]
        holder.render(item)
    }
    override fun getItemCount(): Int = contactsList.size
}