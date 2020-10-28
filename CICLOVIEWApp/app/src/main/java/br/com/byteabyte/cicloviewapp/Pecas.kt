package br.com.byteabyte.cicloviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "peca")

class Pecas {

    @PrimaryKey
    var id: Long = 0
    var nome = ""
    var imagem = ""
    var marca = ""
    var codigo = ""
    var valor = ""



    override fun toString(): String {
        return "Pecas(nome= $nome)"
    }
}