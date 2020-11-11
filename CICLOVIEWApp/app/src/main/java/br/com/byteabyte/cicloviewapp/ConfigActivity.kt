package br.com.byteabyte.cicloviewapp

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_config.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*


class ConfigActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        this.drawerLayout = layoutMenuLateral
        this.navView = menu_lateral

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Configurações"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
    }
}