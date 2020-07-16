package br.com.petsappmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ocultando a barra de título desta atividade
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //mostrando em tela cheia
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        //tempo da splash sera de 4 segundos
        Handler().postDelayed({
            //iniciar main activity
            startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))
            //terminar a atividade apos atingir os 4 segundos
            finish()
        },2000)

    }
}