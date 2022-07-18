package com.example.app_adoption_system.base

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.app_adoption_system.utils.appConfig

class InitBD:SQLiteOpenHelper(appConfig.CONTEXT,
                appConfig.BD_NAME,
                null, //No hay cursor
                appConfig.VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table tb_statusDoc("+
                "idStatusDoc integer primary key autoincrement, "+
                "nombStatusDoc varchar(30))")
        db.execSQL("create table tb_organismo("+
                "idorganismo integer primary key autoincrement, "+
                "nombOrganismo varchar(30),"+
                "rucOrganismo varchar(30),"+
                "fechaActualizacion varchar(30),"+
                "contactoOrganismo varchar(30),"+
                "emailOrganismo varchar(30),"+
                "telefNacional varchar(30),"+
                "telefInternacional varchar(30),"+
                "direccion varchar(30),"+
                "paisOrigen varchar(30),"+
                "modalidad varchar(30),"+
                "estado varchar(30),"+
                "idStatusDoc int references tb_statusDoc(idStatusDoc))")
        //Insertando registro
        db.execSQL("insert into tb_statusDoc values(null,'Inicio de Renovacion')")
        db.execSQL("insert into tb_statusDoc values(null,'Evaluación Documentaria')")
        db.execSQL("insert into tb_statusDoc values(null,'Emisión Resolutiva')")
        db.execSQL("insert into tb_statusDoc values(null,'Aprobación Resolutiva')")
        db.execSQL("insert into tb_statusDoc values(null,'Proceso de Registro')")
        db.execSQL("insert into tb_statusDoc values(null,'Inicio de Renovacion')")
        db.execSQL("insert into tb_organismo values(null,'Hogar San Benito','20503644987','01/02/2022','Pedro Romero Suarez','sanbenitohogar@gmail.com','910652147','+54910261248','Av. Mar del Plata 256','Argentina','Mixto','Activo',1)")
        db.execSQL("insert into tb_organismo values(null,'Hogar Maria Luisa','20583755985','11/03/2022','Juan Quispe Ugarte','hogarmaria@gmail.com','930653155','+51930653155','Av. Miraflores 144','Perú','Regular','Activo',2)")
        db.execSQL("insert into tb_organismo values(null,'Don Bosco','20963755666','13/05/2022','Teresa Ventocilla Rosales','donbosco@gmail.com','937753276','+1958853189','Jr. Toronto 182','Canadá','Especial','Activo',3)")
        db.execSQL("insert into tb_organismo values(null,'Hogar de Dios','201245987815','01/06/2022','Pablo Do Nazario','hogardios@gmail.com','911010302','+55999512211','Viaduto do Chá 145','Brazil','Mixto','Activo',2)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}