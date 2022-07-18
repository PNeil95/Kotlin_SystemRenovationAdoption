package com.example.app_adoption_system

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.app_adoption_system.controlador.ArregloOrganismo
import com.example.app_adoption_system.controlador.ArrregloStatusDocumento
import com.example.app_adoption_system.entidad.Organismo

class DatosActivity:AppCompatActivity(), View.OnClickListener {

    lateinit var tvCodigoD:TextView
    lateinit var edtOrganismoD:EditText
    lateinit var edtRucD:EditText
    lateinit var edtFechaD:EditText
    lateinit var edtContactoD:EditText
    lateinit var edtEmailD:EditText
    lateinit var edtFonoNacD:EditText
    lateinit var edtFonoInternacD:EditText
    lateinit var edtDireccionD:EditText
    lateinit var edtPaisD:EditText
    lateinit var spnModalidadD: Spinner
    lateinit var spnEstadoD: Spinner
    lateinit var spnStatusDocD:Spinner

    lateinit var btnActualizarD: Button
    lateinit var btnEliminarD: Button
    lateinit var btnRegresarD: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        //persistentState: PersistableBundle?---, persistentState
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        tvCodigoD=findViewById(R.id.tvCodigoD)
        edtOrganismoD=findViewById(R.id.edtOrganismoD)
        edtRucD=findViewById(R.id.edtRucD)
        edtFechaD=findViewById(R.id.edtFechaD)
        edtContactoD=findViewById(R.id.edtContactoD)
        edtEmailD=findViewById(R.id.edtEmailD)
        edtFonoNacD=findViewById(R.id.edtFonoNacD)
        edtFonoInternacD=findViewById(R.id.edtFonoInternacD)
        edtDireccionD=findViewById(R.id.edtDireccionD)
        edtPaisD=findViewById(R.id.edtPaisD)
        spnModalidadD=findViewById(R.id.spnModalidadD)
        spnEstadoD=findViewById(R.id.spnEstadoD)
        spnStatusDocD=findViewById(R.id.spnStatusDocD)
        btnActualizarD=findViewById(R.id.btnActualizarD)
        btnEliminarD=findViewById(R.id.btnEliminarD)
        btnRegresarD=findViewById(R.id.btnRegresarD)

        btnActualizarD.setOnClickListener(this);
        btnEliminarD.setOnClickListener(this);
        btnRegresarD.setOnClickListener(this);
        mostrarStatusDoc()
        datos()

    }
    override fun onClick(v: View) {
        if(v==btnActualizarD){
            var idOrganismo = tvCodigoD.text.toString().toInt()
            var nombOrganismo = edtOrganismoD.text.toString()
            var rucOrganismo = edtRucD.text.toString()
            var fechaActualizacion = edtFechaD.text.toString()
            var contactoOrganismo = edtContactoD.text.toString()
            var emailOrganismo = edtEmailD.text.toString()
            var telefNacional = edtFonoNacD.text.toString()
            var telefInternacional = edtFonoInternacD.text.toString()
            var direccion = edtDireccionD.text.toString()
            var paisOrigen = edtPaisD.text.toString()
            var modalidad = spnModalidadD.selectedItem.toString()
            var estado = spnEstadoD.selectedItem.toString()
            var codStadoc = spnStatusDocD.selectedItemPosition+1
            //Creando objeto de la Clase Organismo
            val bean = Organismo(idOrganismo,nombOrganismo,rucOrganismo,fechaActualizacion,contactoOrganismo,emailOrganismo,telefNacional,
                telefInternacional,direccion,paisOrigen,modalidad,estado,"",codStadoc)
            //Invocando el metodo AdicionarOrganismo
            var salida = ArregloOrganismo().modificarOrganismo(bean)
            //Validar
            if(salida!= -1)
                Toast.makeText(this,"Organismo Actualizado", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"Error en la actualización", Toast.LENGTH_LONG).show()
        }
        if(v==btnEliminarD){
            var codigo = tvCodigoD.text.toString().toInt()
            var salida = ArregloOrganismo().eliminarOrganismo(codigo)
            //Validar
            if(salida!= -1)
                Toast.makeText(this,"Organismo Eliminado", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"Error en la eliminación", Toast.LENGTH_LONG).show()
        }
        if(v==btnRegresarD){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun datos(){
        //Recuperar la clave organismo que es de tipo Clase Organismo
        val bean = intent.getSerializableExtra("organismo") as Organismo
        //Mostrando en los controles los atributos del objeto "bean"
        tvCodigoD.setText(bean.idOrganismo.toString())
        edtOrganismoD.setText(bean.nombOrganismo)
        edtRucD.setText(bean.nroRuc)
        edtFechaD.setText(bean.fechaActualizacion)
        edtContactoD.setText(bean.contactOrganismo)
        edtEmailD.setText(bean.emailOrganismo)
        edtFonoNacD.setText(bean.telefNacional)
        edtFonoInternacD.setText(bean.telefInternacional)
        edtDireccionD.setText(bean.direccionInternacional)
        edtPaisD.setText(bean.paisOrigen)
        //Obteniendo la modalidad y estado del Organismo actual
        var modalidad = bean.modalidadAdopcion
        var estado = bean.estado
        var posModalidad = -1;
        var posEstado = -1;
        //Obteniendo el estado del Organismo actual
        val adapterModalidad = spnModalidadD.adapter
        val adapterEstado = spnEstadoD.adapter
        //Bucle para realizar el recorrido sobre adapter
        for(i in 0 until adapterModalidad.count){
            if(adapterModalidad.getItem(i).equals(modalidad))
                posModalidad=i
        }
        for(i in 0 until adapterEstado.count){
            if(adapterEstado.getItem(i).equals(modalidad))
                posEstado=i
        }
        //Mostar el sexo actual segun la posición
        spnModalidadD.setSelection(posModalidad)
        spnEstadoD.setSelection(posEstado)
        spnStatusDocD.setSelection(bean.codigoDocumento-1)
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
        spnStatusDocD.adapter = adapter
    }
}