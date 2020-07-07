package br.com.petsappmobile.http

import br.com.petsappmobile.model.Usuario
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class HttpHelper {

    fun login(email: String, senha: String) : Usuario{

        //criando url do endpoint no servidor
        val URL = "http://127.0.0.1:8000/api/v1/login"

        //criando um cliente http
        val client = OkHttpClient()

        //construindo a requisição http para o servidor
        val request = Request
            .Builder()
            .url(URL)
            .get()
            .build()

        //criando a resposta do servidor
        val response = client.newCall(request).execute()

        //extraindo o json do body da resposta
        val responseBody = response.body()

        var usuario = Usuario()

        //criando um objeto usuario
        if (responseBody!!.contentLength().toInt() != 0){
            //transformando o corpo da requisição em string
            var json = responseBody.string()
            var gson = Gson()

            //transformando em uma classe do kotlin
            usuario= gson.fromJson(json, Usuario::class.java)
        }

        return usuario
    }
}