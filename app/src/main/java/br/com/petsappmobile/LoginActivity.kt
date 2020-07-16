package br.com.petsappmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.petsappmobile.http.HttpHelper
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        //instancia da classe httoHelper
        val httpHelper = HttpHelper()

        println("Karol")

        doAsync {
            //os campos necessarios que serão preenchidos para a autenticação
            val usuario = httpHelper.login(editTextEmail.text.toString(), editTextSenha.text.toString())

            //se retornar um usuário a autenticação está ok
            uiThread {
                println(" >>>>>>>>>>>>>>>> "+usuario)
                if (usuario.user.email.isNotEmpty()){
                    abrirMainActivity()
                } else {
                    toast("E-mail ou senha incorretos! Tente novamente.")
                }
            }
        }
    }

    private fun abrirMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
