package com.example.app_adoption_system.entidad

class StatusDocumento {
    private var codStatusDoc:Int=0
    private var nomStatusDoc:String=""

    constructor(codStatusDoc:Int,nomStatusDoc:String){
        this.codStatusDoc=codStatusDoc
        this.nomStatusDoc=nomStatusDoc
    }

    fun getCodigoStatusDoc():Int{
        return codStatusDoc
    }

    fun setCodigoStatusDoc(codStatusDoc: Int){
        this.codStatusDoc=codStatusDoc
    }
    fun getNombreStatusDoc():String{
        return nomStatusDoc
    }

    fun setNombreStatusDoc(nomStatusDoc: String){
        this.nomStatusDoc=nomStatusDoc
    }

}