package br.com.petsappmobile.util

import br.com.petsappmobile.http.HttpHelper
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DataSource {

    companion object {
        fun createDataset() {

            doAsync {
                var http = HttpHelper()
                var lista = http.getEmpresas()

                uiThread {
                    println("XXXXXXXXXX ---- $lista")
                }
            }

        }
    }

}