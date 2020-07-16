package br.com.petsappmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.petsappmobile.http.HttpHelper
import br.com.petsappmobile.model.Usuario
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val buttonCadastrar = findViewById<Button>(R.id.buttonCadastro)
        val editTextNome = findViewById<EditText>(R.id.editTextNomeCadastro)
        val editTextCelular = findViewById<EditText>(R.id.editTextCelularCadastro)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmailCadastro)
        val editTextSenha = findViewById<EditText>(R.id.editTextSenhaCadastro)
        val editTextConfirmarSenha = findViewById<EditText>(R.id.editTextConfirmarSenhaCadastro)

        buttonCadastrar.setOnClickListener{
            //criar objeto usuário
            val usuario = Usuario()
            usuario.nome = editTextNome.text.toString()
            usuario.celular = editTextCelular.text.toString()
            usuario.email = editTextEmail.text.toString()
            usuario.password = editTextSenha.text.toString()
            usuario.password_confirmation = editTextConfirmarSenha.text.toString()

            //converter o usuário em json
            val gson = Gson()
            val usuarioJson = gson.toJson(usuario)

            println(">>>>>>>>>>>>>>>>>>>>>>>>>" + usuarioJson)

            doAsync{
                val http = HttpHelper()
                http.post(usuarioJson)

                //se retornar um usuário a autenticação está ok
                    uiThread {
                        println(" >>>>>>>>>>>>>>>> "+usuario)
                        if (usuario.email.isNotEmpty()){
                            abrirMainActivity()
                        } else {
                            toast("E-mail ou senha incorretos! Tente novamente.")
                        }
                    }

            }

        }

    }

    private fun abrirMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
