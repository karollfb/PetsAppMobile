package br.com.petsappmobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.petsappmobile.R
import br.com.petsappmobile.model.Empresa
import kotlinx.android.synthetic.main.layout_lista_empresas.view.*

class EmpresaRecyclerAdapter (var lista: List<Empresa>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_lista_empresas, parent, false)


        println(">>>>>>>>>>>>>" + lista)

        return EmpresaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is EmpresaViewHolder -> {
                holder.bind(lista[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class EmpresaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txtNome: TextView = itemView.txt_nome_empresa
        val txtNota: TextView = itemView.txt_nota_empresa

        fun bind(empresa: Empresa){
            txtNome.text = empresa.nome_fantasia
            txtNota.text = empresa.nota.toString()
        }

    }

}