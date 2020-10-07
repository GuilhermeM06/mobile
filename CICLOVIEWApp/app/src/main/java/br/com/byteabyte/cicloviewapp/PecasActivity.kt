package br.com.byteabyte.cicloviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pecas.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*

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

    override fun onResume() {
        super.onResume()
        taskPecas()
    }

    private var pecas = listOf<Pecas>()
    fun taskPecas() {
        pecas = PecasService.getPecas(this)
        recyclerPecas.adapter = PecasAdapter(pecas) { onClickPeca(it)}
    }
    fun onClickPeca(peca: Pecas) {

    }
}