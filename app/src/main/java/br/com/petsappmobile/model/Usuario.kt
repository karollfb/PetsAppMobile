package br.com.petsappmobile.model

data class Usuario (
    var id: Int = 0,
    var nome: String = "",
    var email: String = "",
    var senha: String = "",
    var celular: String = "",
    var tipo_cadastro: Int = 0
)
