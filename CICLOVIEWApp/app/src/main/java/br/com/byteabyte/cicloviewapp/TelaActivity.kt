package br.com.byteabyte.cicloviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TelaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela)

        val args = intent.extras
        val nome = args?.getString("nome")

        supportActionBar?.title = "$nome"
    }


}