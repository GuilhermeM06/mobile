package br.com.byteabyte.cicloviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela)

        this.drawerLayout = layoutMenuLateral
        this.navView = menu_lateral

        val args = intent.extras
        val nome = args?.getString("nome")

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "$nome"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        val peca = intent?.getSerializableExtra("peça")

        Toast.makeText(this, "Peça: $peca", Toast.LENGTH_LONG).show()


    }


}