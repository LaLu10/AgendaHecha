package com.example.agenda

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.databinding.ItemContactsBinding

class ContactsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val b = ItemContactsBinding.bind(view)
    @SuppressLint("SetTextI18n")
    fun render(ContactsModel: Contacts){
        b.tvId.text= "ID: "+ ContactsModel.id
        b.tvName.text = "Name: "+ ContactsModel.name
        b.tvApellido.text = "Apellido: "+ ContactsModel.surname
        b.tvPhone.text = "Teléfono: "+ ContactsModel.phone
        b.tvEmail.text = "Email: "+ ContactsModel.email

    }
}