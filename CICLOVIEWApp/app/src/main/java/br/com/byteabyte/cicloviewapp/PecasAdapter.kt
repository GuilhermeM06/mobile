package br.com.byteabyte.cicloviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PecasAdapter(val pecas: List<Pecas>,
                   val onClick: (Pecas) -> Unit): RecyclerView.Adapter<PecasAdapter.PecasViewHolder>() {

    class PecasViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_peca)
        }
    }

    override fun getItemCount() = this.pecas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PecasViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_pecas, parent, false)
            val holder = PecasViewHolder(view)

            return holder
        }

    override fun onBindViewHolder(holder: PecasViewHolder, position: Int) {
        val context = holder.itemView.context

        val peca = this.pecas[position]

        holder.cardNome.text = peca.nome
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(peca.foto).fit().into(
            holder.cardImg,
            object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            }
        )

        }
    }


