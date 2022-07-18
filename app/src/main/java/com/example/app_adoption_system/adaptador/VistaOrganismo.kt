package com.example.app_adoption_system.adaptador

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_adoption_system.R

class VistaOrganismo(itemView:View):RecyclerView.ViewHolder(itemView) {
    var tvCodigo:TextView
    var tvOrganismo:TextView
    var tvEmail:TextView
    var tvPais:TextView
    var btnDetalle:Button
    var imgFoto:ImageView

    //Bloque para inicializar
    init{
        tvCodigo = itemView.findViewById(R.id.tvCodigo)
        tvOrganismo = itemView.findViewById(R.id.tvOrganismo)
        tvEmail = itemView.findViewById(R.id.tvEmail)
        tvPais = itemView.findViewById(R.id.tvPais)
        btnDetalle = itemView.findViewById(R.id.btnDetalle)
        imgFoto = itemView.findViewById(R.id.imgFoto)
    }
}

