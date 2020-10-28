package br.com.byteabyte.cicloviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*


open class DebugActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = "CVA"
    private val className: String
        get() {
            var name = javaClass.name
            return name.substring(name.lastIndexOf("."))
    }

    var drawerLayout: DrawerLayout? = null
    var navView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className onCreate() executado")
    }

    protected fun configuraMenuLateral(){
        var toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar_view,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){

            R.id.inicial -> {
                var intent = Intent(this, IndexActivity::class.java)
                startActivity(intent)
            }
            R.id.pecas -> {
                var intent = Intent(this, PecasActivity::class.java)
                var nome = "Peças"

                intent.putExtra("nome", nome)
                startActivity(intent)
            }
            R.id.servico -> {
                var intent = Intent(this, TelaActivity::class.java)
                var nome = "Serviços"

                intent.putExtra("nome", nome)
                startActivity(intent)

            }
            R.id.contato -> {
                var intent = Intent(this, TelaActivity::class.java)
                var nome = "Contato"

                intent.putExtra("nome", nome)
                startActivity(intent)

            }

            R.id.action_configurations -> {
                var intent = Intent(this, ConfigActivity::class.java)
                startActivity(intent)
            }
            R.id.exit -> {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }

        drawerLayout?.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$className onStart() executado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$className onRestart() executado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$className onResume() executado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$className onStop() executado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$className onDestroy() executado")
    }
}