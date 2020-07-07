package br.com.petsappmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detalhes_servicos.*

class DetalhesServicosActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_servicos)

        button_agendar_servico.setOnClickListener(this)
        button_voltar.setOnClickListener(this)

    }


    override fun onClick(view: View) {

        val id = view.id

        if (id == R.id.button_agendar_servico){
            var intent = Intent(this, AgendarServicoActivity::class.java)
            startActivity(intent)

        } else if(id == R.id.button_voltar) {
            var intent = Intent(this, DadosEmpresaActivity::class.java)
            startActivity(intent)
        }

    }

}
