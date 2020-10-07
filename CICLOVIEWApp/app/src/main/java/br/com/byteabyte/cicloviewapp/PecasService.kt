package br.com.byteabyte.cicloviewapp

import android.content.Context

object PecasService {

    fun getPecas(context: Context): List<Pecas> {
        val pecas= mutableListOf<Pecas>()

        for (i in 1..10){
            val d= Pecas()
            d.nome= "Peça $i"
            d.valor= "valor $i"
            d.fornecedor= "fornecedor $i"
            d.foto= "https://sc01.alicdn.com/kf/HTB1ZLQwLVXXXXc3XVXX760XFXXXY.png"
            pecas.add(d)
        }

        return pecas
    }
}