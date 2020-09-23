package br.com.byteabyte.cicloviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class IndexActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val args = intent.extras
        val nome = args?.getString("nome")

        Toast.makeText(this, "Bem-vindo, $nome", Toast.LENGTH_LONG).show()
    }
}