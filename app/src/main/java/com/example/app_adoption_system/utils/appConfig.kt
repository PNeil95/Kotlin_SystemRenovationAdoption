package com.example.app_adoption_system.utils

import android.app.Application
import android.content.Context
import com.example.app_adoption_system.base.InitBD

class appConfig:Application() {
    //Variables Globales
    companion object{
        lateinit var CONTEXT:Context
        var BD_NAME="systemadoption.bd"
        var VERSION=1
        lateinit var BD:InitBD
    }

    //Metodo donde se crearan
    override fun onCreate() {
        super.onCreate()
        //Creando el objeto CONTEXT
        CONTEXT = applicationContext
        //Creando el objeto BD
        BD = InitBD()

    }
}