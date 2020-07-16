package br.com.petsappmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_dados_empresa.*

class DadosEmpresaActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_empresa)

        button_ver_mais.setOnClickListener(this)
        ver_servicos.setOnClickListener(this)

    }


    override fun onClick(view: View) {

        val id = view.id

        if (id == R.id.button_ver_mais){
            var intent = Intent(this, DetalhesServicosActivity::class.java)
            startActivity(intent)

        } else if(id == R.id.ver_servicos) {
            var intent = Intent(this, DetalhesServicosActivity::class.java)
            startActivity(intent)
        }

    }

}
