package com.example.app_adoption_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_adoption_system.adaptador.CustomAdapter
import com.example.app_adoption_system.controlador.ArregloOrganismo

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    private lateinit var  rvOrganismo:RecyclerView
    lateinit var btnNuevo:Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvOrganismo = findViewById(R.id.rvOrganismo)
        btnNuevo = findViewById(R.id.btnNuevo)
        btnNuevo.setOnClickListener(this)

        //Invocar al metodo listado
        var lista = ArregloOrganismo().listado()
        //Creando un objeto de la Clase CustomAdapter
        var adaptador = CustomAdapter(lista)
        //Definir el tipo de layout que se debe mostrar en el RecyclerView (En este caso un layout de tipo lineal - tipo fila)
        rvOrganismo.layoutManager = LinearLayoutManager(this)
        //Enviar objeto "adaptador" al RecyclerView
        rvOrganismo.adapter = adaptador
    }



    override fun onClick(v: View) {
        val intent = Intent(this,NuevoActivity::class.java)
        startActivity(intent)
    }


}

