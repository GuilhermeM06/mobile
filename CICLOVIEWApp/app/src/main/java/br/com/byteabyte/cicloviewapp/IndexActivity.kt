package br.com.byteabyte.cicloviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*
import kotlin.concurrent.schedule

class IndexActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val args = intent.extras
        val nome = args?.getString("nome")

        Toast.makeText(this, "Bem-vindo, $nome", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Cadastro de Bicicletas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super .onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_search){
            Toast.makeText(this, "Botão Buscar", Toast.LENGTH_LONG).show()

        } else if (id == R.id.action_update) {
            Toast.makeText(this, "Botão atualizar", Toast.LENGTH_LONG).show()
            progressBar.visibility = View.VISIBLE
            Timer().schedule(10000){
                progressBar.visibility = View.INVISIBLE
            }

        } else if (id == R.id.action_add) {
            Toast.makeText(this, "Botão Adicionar", Toast.LENGTH_LONG).show()
            var intent = Intent(this, Tela_cadastro::class.java)
            startActivity(intent)

        } else if (id == R.id.action_configurations) {
            Toast.makeText(this, "Botão Configurações", Toast.LENGTH_LONG).show()
            var intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)

        } else if (id == android.R.id.home){
            finish()
        } else if (id == R.id.pecas) {
            var intent = Intent(this, TelaActivity::class.java)
            var nome = "Peças"

            intent.putExtra("nome", nome)
            startActivity(intent)

        } else if (id == R.id.servico) {
            var intent = Intent(this, TelaActivity::class.java)
            var nome = "Serviços"

            intent.putExtra("nome", nome)
            startActivity(intent)

        } else if (id == R.id.contato) {
            var intent = Intent(this, TelaActivity::class.java)
            var nome = "Contato"

            intent.putExtra("nome", nome)
            startActivity(intent)

        }



        return super.onOptionsItemSelected(item)
    }


}



