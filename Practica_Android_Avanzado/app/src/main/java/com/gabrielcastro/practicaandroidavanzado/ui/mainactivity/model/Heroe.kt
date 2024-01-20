package com.gabrielcastro.practicaandroidavanzado.ui.mainactivity.model

data class Heroe(
    val id: String,
    val name: String,
    val picture : String,
    val description : String,
    var isFavourite : Boolean
)