package com.example.app_adoption_system.controlador

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.app_adoption_system.entidad.Organismo
import com.example.app_adoption_system.entidad.StatusDocumento
import com.example.app_adoption_system.utils.appConfig

class ArrregloStatusDocumento {
    //Metodo listado
    fun listado():ArrayList<StatusDocumento>{
        var data = ArrayList<StatusDocumento>();

        //Abriendo el acceso a la Base de Datos en modo Lectura
        var base:SQLiteDatabase = appConfig.BD.readableDatabase
        var sql = "select*from tb_statusDoc"
        var rs:Cursor = base.rawQuery(sql,null)
        //Bucle
        while(rs.moveToNext()){
            //Crear un objeto de la Clase Organismo y enviar los valores de la fila actual
            var bean = StatusDocumento(rs.getInt(0),rs.getString(1))
            //Adicionar
            data.add(bean)
        }
        return data
    }
}