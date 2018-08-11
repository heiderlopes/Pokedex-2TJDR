package br.com.fiap.pokedex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.fiap.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        rvPokemons.adapter = ListaPokemonAdapter(getPokemons(),
                this, {
            val telaDetalhe = Intent(this,
                    DetalheActivity::class.java)

            telaDetalhe.putExtra("POKEMON", it)
            startActivity(telaDetalhe)
        })

        rvPokemons.layoutManager = LinearLayoutManager(this)
    }


    fun getPokemons(): List<Pokemon> {
        return listOf(
                getMewtwo()
        )
    }

    fun getMewtwo(): Pokemon {
        return Pokemon(1,
                "Mewtwo",
                "Psy",
                "bla bla",
                R.drawable.mewtwo)
    }
}
