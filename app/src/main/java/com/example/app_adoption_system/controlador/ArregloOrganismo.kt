package com.example.app_adoption_system.controlador

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.app_adoption_system.entidad.Organismo
import com.example.app_adoption_system.utils.appConfig

class ArregloOrganismo {
    //Metodo listado
    fun listado():ArrayList<Organismo>{
        var data = ArrayList<Organismo>();

        //Abriendo el acceso a la Base de Datos en modo Lectura
        var base:SQLiteDatabase = appConfig.BD.readableDatabase
        var sql = "select*from tb_organismo"
        var rs:Cursor = base.rawQuery(sql,null)
        //Bucle
        while(rs.moveToNext()){
            //Crear un objeto de la Clase Organismo y enviar los valores de la fila actual
            var bean = Organismo(rs.getInt(0),
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10),
                rs.getString(11),
                "",
                rs.getInt(12)
            )

            //Adicionar
            data.add(bean)
        }
        return data
    }

    fun adicionarOrganismo(bean:Organismo):Int{
        var estados = -1;
        //Abrir el acceso a la base de datos en modo escritura
        var base:SQLiteDatabase = appConfig.BD.writableDatabase
        //Crear claves --> crea un objeto de la clase Content value
        val valores = ContentValues();
        valores.put("nombOrganismo",bean.nombOrganismo)
        valores.put("rucOrganismo",bean.nroRuc)
        valores.put("fechaActualizacion",bean.fechaActualizacion)
        valores.put("contactoOrganismo",bean.contactOrganismo)
        valores.put("emailOrganismo",bean.emailOrganismo)
        valores.put("telefNacional",bean.telefNacional)
        valores.put("telefInternacional",bean.telefInternacional)
        valores.put("direccion",bean.direccionInternacional)
        valores.put("paisOrigen",bean.paisOrigen)
        valores.put("modalidad",bean.modalidadAdopcion)
        valores.put("estado",bean.estado)
        valores.put("idStatusDoc",bean.codigoDocumento)
        //Lo que nos permitirá guarda --> realizando el proceso de registrar
        base.insert("tb_organismo","idorganismo",valores).toInt()
        return estados;
    }

    fun modificarOrganismo(bean:Organismo):Int{
        var estados = -1;
        //Abrir el acceso a la base de datos en modo escritura
        var base:SQLiteDatabase = appConfig.BD.writableDatabase
        //Crear claves --> crea un objeto de la clase Content value
        val valores = ContentValues();
        valores.put("nombOrganismo",bean.nombOrganismo)
        valores.put("rucOrganismo",bean.nroRuc)
        valores.put("fechaActualizacion",bean.fechaActualizacion)
        valores.put("contactoOrganismo",bean.contactOrganismo)
        valores.put("emailOrganismo",bean.emailOrganismo)
        valores.put("telefNacional",bean.telefNacional)
        valores.put("telefInternacional",bean.telefInternacional)
        valores.put("direccion",bean.direccionInternacional)
        valores.put("paisOrigen",bean.paisOrigen)
        valores.put("modalidad",bean.modalidadAdopcion)
        valores.put("estado",bean.estado)
        valores.put("idStatusDoc",bean.codigoDocumento)
        //Lo que nos permitirá guarda --> realizando el proceso de registrar
        estados = base.update("tb_organismo",valores,"idorganismo=?", arrayOf(bean.idOrganismo.toString()))
        return estados;
    }

    fun eliminarOrganismo(codigo:Int):Int{
        var estados = -1;
        //Abrir el acceso a la base de datos en modo escritura
        var base:SQLiteDatabase = appConfig.BD.writableDatabase
        //Crear claves --> crea un objeto de la clase Content value
        //Lo que nos permitirá guarda --> realizando el proceso de registrar
        estados = base.delete("tb_organismo","idorganismo=?", arrayOf(codigo.toString()))
        return estados;
    }

}