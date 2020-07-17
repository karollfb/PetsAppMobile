package br.com.petsappmobile.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.petsappmobile.R
import br.com.petsappmobile.adapter.EmpresaRecyclerAdapter
import br.com.petsappmobile.http.HttpHelper
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var empresaRecyclerAdapter: EmpresaRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val inflated = inflater.inflate(R.layout.fragment_home, container, false)

        showRecyclerView()

        return inflated
    }

    private fun showRecyclerView() {

        doAsync {
            val http = HttpHelper()

            try {
                val lista = http.getEmpresas()

                uiThread {
                    rvEmpresas.layoutManager =
                        LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                    empresaRecyclerAdapter = EmpresaRecyclerAdapter(lista)
                    rvEmpresas.adapter = empresaRecyclerAdapter
                }
            } catch(e: Exception) {
                uiThread {
                    println(">>>>>>>>>>>>>>>>>>>>>>> Network Exception: $e")
                }
            }
        }
    }
}
