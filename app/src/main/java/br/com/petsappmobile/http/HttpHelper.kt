package br.com.petsappmobile.http

import br.com.petsappmobile.model.Empresa
import br.com.petsappmobile.model.RespostaLogin
import br.com.petsappmobile.model.Usuario
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONArray

class HttpHelper {

    fun login(email: String, password: String) : RespostaLogin{

        //criando url do endpoint no servidor
        val URL = "http://192.168.1.104:8000/api/v1/login"

        //criando um cliente http
        val client = OkHttpClient()

        val gson = Gson()

        val usuarioRequest = Usuario()
        usuarioRequest.email = email
        usuarioRequest.password = password

        val requestBody = gson.toJson(usuarioRequest)
        println(">>>>>>>>>>>>>>>>$$$$$$$$$$$" + requestBody)

        //construindo a requisição http para o servidor
        val headerHttp = MediaType.parse("application/json; charset=utf-8")
        val body = RequestBody.create(headerHttp, requestBody)

        val request = Request.Builder().url(URL).post(body).build()
        val response = client.newCall(request).execute()

        //extraindo o json do body da resposta
        val responseBody = response.body()?.string()

        var respostaLogin = RespostaLogin()

        //transformando em uma classe do kotlin
        respostaLogin = gson.fromJson(responseBody, RespostaLogin::class.java)

        println(responseBody)
        return respostaLogin
    }

    fun post (json: String): String {

        //criando url do endpoint no servidor
        val URL = "http://192.168.1.104:8000/api/v1/users/"

        //definindo o cabeçalho
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        //criando um cliente http
        val client = OkHttpClient()

        //criando o body da requisição
        val body = RequestBody.create(headerHttp, json)

        //construindo a requisição post para o servidor
        val request = Request.Builder().url(URL).post(body).build()

        //utilizando o cliente para fazer a requisição e receber a resposta
        val response = client.newCall(request).execute()

        return response.body().toString()

    }

    fun getEmpresas(): ArrayList<Empresa>{

        // determinando a URL do endpoint no servidor
        val URL = "http://192.168.1.104:8000/api/v1/empresas"

        // criando um cliente Http
        val client = OkHttpClient()

        // construindo a requisição http para o servidor
        val request = Request.Builder().url(URL).get().build()

        // criando a resposta do servidor
        val response = client.newCall(request).execute()

        // extraindo o json do body da resposta
        val responseBody = response.body()

        //criando uma lista de empresas
        var listaEmpresa = ArrayList<Empresa>()

        if (responseBody != null){
            var empresasJson = responseBody.string()
            var empresasArray = JSONArray(empresasJson)

            for (i in 0 until empresasArray.length()){
                val empresaJson = empresasArray.getJSONObject(i)

                val empresa = Empresa(
                    empresaJson.getInt("id"),
                    empresaJson.getString("")
                )

                listaEmpresa.add(empresa)
            }
        }
        return listaEmpresa
    }

}