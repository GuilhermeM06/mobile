package br.com.byteabyte.cicloviewapp

class Pecas {

    var id: Long = 0
    var nome= ""
    var valor= ""
    var foto= ""
    var fornecedor= ""

    override fun toString(): String {
        return "Pecas(nome= $nome)"
    }
}