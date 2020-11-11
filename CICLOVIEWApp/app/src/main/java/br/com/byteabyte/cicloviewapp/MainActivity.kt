package br.com.byteabyte.cicloviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        campoUsuario.setText(Prefs.getString("login"))
        campoSenha.setText(Prefs.getString("senha"))
        check_login.isChecked = Prefs.getBoolean("lembrar")


        campoImagem.setImageResource(R.drawable.cicloview_img_login)

        firstText.setText(R.string.mensagem_inicial)

        buttom.setOnClickListener{

            var usuario = campoUsuario.text.toString()
            var senha = campoSenha.text.toString()
            val lembrar = check_login.isChecked
            Prefs.setBoolean("lembrar", lembrar)


            if (lembrar){
                Prefs.setString("login", usuario)
                Prefs.setString("senha", senha)
            } else {
                Prefs.setString("login", "")
                Prefs.setString("senha", "")

            }

            var intent = Intent(this, IndexActivity::class.java)

            if (usuario == "aluno" && senha == "impacta") {

                intent.putExtra("nome", usuario)

                startActivity(intent)


            } else {

                Toast.makeText(this, "Usuário ou Senha incorretos", Toast.LENGTH_LONG).show()
            }







        }

    }
}