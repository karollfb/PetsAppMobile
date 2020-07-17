package br.com.petsappmobile.model

class Empresa() {

    var id: Int = 0
    var nome_fantasia: String = ""
    var telefone_empresa: String = ""
    var rua: String = ""
    var numero: String = ""
    var cidade: String = ""
    var uf: String = ""
    var transporte: Int = 0
    var categorias: String = ""
    var nota: Int = 0

    override fun toString(): String {
        return "Empresa(id=$id, razao_social='$nome_fantasia', telefone_empresa='$telefone_empresa', " +
                "rua='$rua', numero='$numero', cidade='$cidade', uf='$uf', transporte=$transporte, categorias=$categorias,  nota='$nota')"
    }


}