package com.example.app_adoption_system.entidad

import java.io.Serializable

class Organismo (
    var idOrganismo:Int,
    var nombOrganismo:String,
    var nroRuc:String,
    var fechaActualizacion:String,
    var contactOrganismo:String,
    var emailOrganismo:String,
    var telefNacional:String,
    var telefInternacional:String,
    var direccionInternacional:String,
    var paisOrigen:String,
    var modalidadAdopcion:String, //spinner
    var estado:String, //spinner
    var foto:String,
    var codigoDocumento:Int
        ):Serializable{

}