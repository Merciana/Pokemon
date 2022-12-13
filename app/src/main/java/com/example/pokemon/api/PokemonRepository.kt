package com.example.pokemon.api

import com.example.pokemon.api.model.PokemonApiResult
import com.example.pokemon.api.model.PokemonsApiResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    //https://pokeapi.co/api/v2/pokemon/?limiti=151
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder() // intancia do retrofit inicializada
            .baseUrl("https://pokeapi.co/api/v2/") // url raiz do pokeapi
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java) // implementando todos os metodos da interface
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listPokemons(limit)

        return call.execute().body()
    } //olheeeeee 1:16

    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemon(number) // faz a chamada no http

        return call.execute().body() // retorna o body da chamada
    }



}