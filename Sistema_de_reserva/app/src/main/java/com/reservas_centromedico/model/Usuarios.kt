package com.reservas_centromedico.model

data class Usuarios(
    val ci: String,
    val nombre:String,
    val apellido:String,
    val correo:String,
    val fecha: String,
    val ciudad: String,
    val contraseña: String){
    constructor(): this("","","","","","","")
}