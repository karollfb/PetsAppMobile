package br.com.petsappmobile.model

class RespostaCadastro {

    var user = Usuario()
    var token = ""

    override fun toString(): String {
        return "RespostaCadastro(user=$user, token='$token')"
    }


}