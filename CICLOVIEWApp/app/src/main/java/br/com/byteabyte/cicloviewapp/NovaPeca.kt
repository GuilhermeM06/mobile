package br.com.byteabyte.cicloviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nova_peca.*

class NovaPeca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_peca)

        botao_salvar.setOnClickListener {
            var p = Pecas()
            p.nome = campo_nome.text.toString()
            p.imagem = campo_imagem.text.toString()
            p.marca = campo_marca.text.toString()
            p.codigo = campo_codigo.text.toString()
            p.valor = campo_valor.text.toString()




            Thread {
                PecasService.savePeca(p)
                runOnUiThread{
                    finish()
                }
            }.start()

        }
    }
}