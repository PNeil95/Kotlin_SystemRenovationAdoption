package com.example.app_adoption_system.adaptador

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.app_adoption_system.DatosActivity
import com.example.app_adoption_system.R
import com.example.app_adoption_system.entidad.Organismo


class CustomAdapter(val info:ArrayList<Organismo>):RecyclerView.Adapter<VistaOrganismo>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaOrganismo {
        //Inflar
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_organismo,parent,false)
        return VistaOrganismo(vista)
    }

    override fun onBindViewHolder(holder: VistaOrganismo, position: Int) {
        holder.tvCodigo.text = info.get(position).idOrganismo.toString()
        holder.tvOrganismo.text = info.get(position).nombOrganismo
        holder.tvEmail.text = info.get(position).emailOrganismo
        holder.tvPais.text = info.get(position).paisOrigen

        //Convirtiendo la imagen en un archivo identificador de tipo entero "int"

        //Obteniendo el contexto de la vista actual "Holder"
        var context:Context = holder.itemView.context
        var ID:Int
        //Creando el identificador de imagen segun el valor que almacenan el atributo foto
        ID = context.resources.getIdentifier(info.get(position).foto,"drawable",context.packageName)
        //Asignando el ID al atributo imgFoto
        //holder.imgFoto.setImageResource(ID)
        holder.imgFoto.setImageResource(R.drawable.a0)
        //Asignando el evento Click a los botones "detalle"
        //El boton esta dentro de VistaDocente --> la cual esta dentro de Holder
        holder.btnDetalle.setOnClickListener{
            //Esto es antes como prueba --> Toast.makeText(context,"Prueba",Toast.LENGTH_LONG).show()
            //Crearemos un objeto de la Clase Alert Dialog
            val builder = AlertDialog.Builder(context)
            //inflar el "activity_detalle"
            val view = LayoutInflater.from(context).inflate(R.layout.activity_detalle,null)
            //Se coloco null porque no se enviaran parametros
            //Creando el objeto view --> dentro del objeto Builder
            builder.setView(view)
            //Referenciando  los controles que tiene el Objeto View
            //Codigo para mostrar los detalles del Organismo de Adopcion
            var tvCodigo:TextView = view.findViewById(R.id.tvDetalleCodigo)
            var tvOrganismoR:TextView= view.findViewById(R.id.tvDetalleNombreOrganismo)
            var tvRucR:TextView = view.findViewById(R.id.tvDetalleRuc)
            var tvFechaActualizacionR:TextView = view.findViewById(R.id.tvDetalleFechaActualizacion)
            var tvContactoR:TextView = view.findViewById(R.id.tvDetalleContacto)
            var tvEmailR:TextView = view.findViewById(R.id.tvDetalleEmail)
            var tvTelefNacR:TextView = view.findViewById(R.id.tvDetalleTelefonoNacional)
            var tvTelefInternacR:TextView = view.findViewById(R.id.tvDetalleTelefonoInternacional)
            var tvDireccionR:TextView = view.findViewById(R.id.tvDetalleDireccion)
            var tvPaisR:TextView = view.findViewById(R.id.tvDetallePais)
            var tvModalidadR:TextView = view.findViewById(R.id.tvDetalleModalidad)
            var tvEstadoR:TextView = view.findViewById(R.id.tvDetalleEstado)
            var tvDocumentoR:TextView = view.findViewById(R.id.tvDetalleDocumento)
            var btnCerrar:Button = view.findViewById(R.id.btnCerrar)
            //Mostrando en el objeto View los valores del Organismo
            tvCodigo.setText("Código: " + info.get(position).idOrganismo.toString())
            tvOrganismoR.setText("Organismo: "+info.get(position).nombOrganismo)
            tvRucR.setText("Nro RUC: "+ info.get(position).nroRuc)
            tvFechaActualizacionR.setText("Fecha actualización: "+info.get(position).fechaActualizacion)
            tvContactoR.setText("Contacto: "+info.get(position).contactOrganismo)
            tvEmailR.setText("Email: "+info.get(position).emailOrganismo)
            tvTelefNacR.setText("Telef Nacional: "+info.get(position).telefNacional)
            tvTelefInternacR.setText("Telef Internacional: "+info.get(position).telefInternacional)
            tvDireccionR.setText("Dirección: "+info.get(position).direccionInternacional)
            tvPaisR.setText("Pais de Origen: "+info.get(position).paisOrigen)
            tvModalidadR.setText("Modalidad de Adopción: "+info.get(position).modalidadAdopcion)
            tvEstadoR.setText("Estado: "+info.get(position).estado)
            tvDocumentoR.setText("Codigo Documentario: "+info.get(position).codigoDocumento)

            //Creando el dialog
            val dialog = builder.create();
            //Mostrando el dialog
            dialog.show()

            //Evento click al Boton BtnCerrar
            btnCerrar.setOnClickListener{
                dialog.dismiss()
            }
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(context, DatosActivity::class.java)
            //Crear claves --> para traer todos los datos
            intent.putExtra("organismo",info.get(position))
            ContextCompat.startActivity(context,intent,null)
        }
    }

    override fun getItemCount(): Int {
        return info.size
    }
}
