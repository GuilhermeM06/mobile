package br.com.byteabyte.cicloviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "peca")

class Pecas: Serializable {

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