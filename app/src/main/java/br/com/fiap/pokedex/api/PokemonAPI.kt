package br.com.fiap.pokedex.api

import br.com.fiap.pokedex.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonAPI {

    @GET("/api/pokemon")
    fun listaPokemons(): Call<PokemonResponse>

}