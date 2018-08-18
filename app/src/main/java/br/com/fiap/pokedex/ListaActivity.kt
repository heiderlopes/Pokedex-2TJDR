package br.com.fiap.pokedex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.fiap.pokedex.api.getPokemonApi
import br.com.fiap.pokedex.model.Pokemon
import br.com.fiap.pokedex.model.PokemonResponse
import kotlinx.android.synthetic.main.activity_lista.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        getPokemons()
    }

    fun exibeNaLista(pokemons: List<Pokemon>) {
        rvPokemons.adapter = ListaPokemonAdapter(pokemons,
                this, {
            val telaDetalhe = Intent(this,
                    DetalheActivity::class.java)

            telaDetalhe.putExtra("POKEMON", it)
            startActivity(telaDetalhe)
        })

        rvPokemons.layoutManager = LinearLayoutManager(this)
    }

    fun exibeMensagemErro(t: Throwable?) {
        Toast.makeText(this, t?.message, Toast.LENGTH_LONG).show()
    }

    fun getPokemons() {
        getPokemonApi()
                .listaPokemons()
                .enqueue(object : Callback<PokemonResponse> {
                    override fun onFailure(call: Call<PokemonResponse>?, t: Throwable?) {
                        exibeMensagemErro(t)
                    }

                    override fun onResponse(call: Call<PokemonResponse>?, response: Response<PokemonResponse>?) {
                        if(response!!.isSuccessful) {
                            exibeNaLista(response?.body()!!.content)
                        }
                    }
                })
    }
}
