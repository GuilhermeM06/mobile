package br.com.byteabyte.cicloviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.activity_pecas.*
import kotlinx.android.synthetic.main.activity_pecas.layoutMenuLateral
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*
import kotlin.concurrent.schedule

class PecasActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pecas)
        this.drawerLayout = layoutMenuLateral
        this.navView = menu_lateral

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Peças"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerPecas?.layoutManager = LinearLayoutManager(this)
        recyclerPecas?.itemAnimator = DefaultItemAnimator()
        recyclerPecas?.setHasFixedSize(true)

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
            val it = Intent(this, NovaPeca::class.java)
            startActivity(it)
        } else if (id == android.R.id.home){
            finish()
        }


        return super.onOptionsItemSelected(item)
    }


    override fun onResume() {
        super.onResume()
        taskPecas()
    }

    private var pecas = listOf<Pecas>()
    fun taskPecas() {
        Thread {
            pecas = PecasService.getPecas(this)
            runOnUiThread {
                recyclerPecas.adapter =
                    PecasAdapter(pecas) { onClickPeca(it) }
            }
        }.start()
    }


    fun onClickPeca(peca: Pecas) {
        val it = Intent(this, TelaActivity::class.java)
        startActivity(it)

    }
}