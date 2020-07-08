package br.com.petsappmobile.model

class RespostaLogin {

    var user = Usuario()
    var token = ""

    override fun toString(): String {
        return "RespostaLogin(user=$user, token='$token')"
    }
}