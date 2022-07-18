package com.example.app_adoption_system

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.app_adoption_system.controlador.ArregloOrganismo
import com.example.app_adoption_system.controlador.ArrregloStatusDocumento
import com.example.app_adoption_system.entidad.StatusDocumento
import com.example.app_adoption_system.entidad.Organismo

class NuevoActivity:AppCompatActivity(),View.OnClickListener{
    //lateinit var edtCodigoA:EditText
    lateinit var edtOrganismoA:EditText
    lateinit var edtRucA:EditText
    lateinit var edtFechaA:EditText
    lateinit var edtContactoA:EditText
    lateinit var edtEmailA:EditText
    lateinit var edtFonoNacA:EditText
    lateinit var edtFonoInternacA:EditText
    lateinit var edtDireccionA:EditText
    lateinit var edtPaisA:EditText
    lateinit var spnModalidadA:Spinner
    lateinit var spnEstadoA:Spinner
    lateinit var spnStatusDocA:Spinner

    lateinit var btnRegistrar:Button
    lateinit var btnRegresar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo)

        edtOrganismoA = findViewById(R.id.edtOrganismoA)
        edtRucA = findViewById(R.id.edtRucA)
        edtFechaA = findViewById(R.id.edtFechaA)
        edtContactoA = findViewById(R.id.edtContactoA)
        edtEmailA = findViewById(R.id.edtEmailA)
        edtFonoNacA = findViewById(R.id.edtFonoNacA)
        edtFonoInternacA = findViewById(R.id.edtFonoInternacA)
        edtDireccionA = findViewById(R.id.edtDireccionA)
        edtPaisA = findViewById(R.id.edtPaisA)
        spnModalidadA = findViewById(R.id.spnModalidadA)
        spnEstadoA = findViewById(R.id.spnEstadoA)
        spnStatusDocA = findViewById(R.id.spnStatusDocA)

        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnRegresar = findViewById(R.id.btnRegresar)
        btnRegistrar.setOnClickListener(this)
        btnRegresar.setOnClickListener(this)
        mostrarStatusDoc()

    }

    override fun onClick(v: View?) {
        if(v==btnRegistrar){
            //Leyendo cajas
            var nombOrganismo = edtOrganismoA.text.toString()
            var rucOrganismo = edtRucA.text.toString()
            var fechaActualizacion = edtFechaA.text.toString()
            var contactoOrganismo = edtContactoA.text.toString()
            var emailOrganismo = edtEmailA.text.toString()
            var telefNacional = edtFonoNacA.text.toString()
            var telefInternacional = edtFonoInternacA.text.toString()
            var direccion = edtDireccionA.text.toString()
            var paisOrigen = edtPaisA.text.toString()
            var modalidad = spnModalidadA.selectedItem.toString()
            var estado = spnEstadoA.selectedItem.toString()
            //Obteniendo el codigo del StatusDocumento segun el valor seleccionado
            var codStadoc = spnStatusDocA.selectedItemPosition+1
            //Creando objeto de la Clase Organismo
            val bean = Organismo(0,nombOrganismo,rucOrganismo,fechaActualizacion,contactoOrganismo,emailOrganismo,telefNacional,
                telefInternacional,direccion,paisOrigen,modalidad,estado,"",codStadoc)
            //val bean = Organismo(0,nombOrganismo,rucOrganismo,fechaActualizacion,contactoOrganismo,emailOrganismo,telefNacional,
            //   telefInternacional,direccion,paisOrigen,modalidad,estado,"",)
            //Invocando el metodo AdicionarOrganismo
            var salida = ArregloOrganismo().adicionarOrganismo(bean)
            //Validar
            if(salida!= -1)
                Toast.makeText(this,"Error en el Registro", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"Organismo Registrado", Toast.LENGTH_LONG).show()
        }
        else if(v==btnRegresar){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun mostrarStatusDoc(){
        //Arreglo de objeto
        var datos = ArrregloStatusDocumento().listado();
        //Arreglo de tipo String o cadena
        var lista = ArrayList<String>();
        //Bucle
        for (bean in datos){
            lista.add(bean.getNombreStatusDoc())
        }
        //Creando ArrayAdapter
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
        spnStatusDocA.adapter = adapter
    }
}