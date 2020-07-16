package br.com.petsappmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        button_login.setOnClickListener(this)
        button_cadastro.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        val id = view.id

        if (id == R.id.button_login){
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        } else if(id == R.id.button_cadastro) {
            var intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

    }

}
