package com.plcoding.jetpackcomposepokedex.repository

import com.plcoding.jetpackcomposepokedex.data.remote.PokeApi
import com.plcoding.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.plcoding.jetpackcomposepokedex.data.remote.responses.PokemonList
import com.plcoding.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val pokeApi: PokeApi
) {

    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Resource<PokemonList> {
        val response = try {
            pokeApi.getPokemonList(limit, offset)
        } catch (exception: Exception) {
            return Resource.Error(exception.message ?: "Algo deu errado")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            pokeApi.getPokemonInfo(pokemonName)
        } catch (exception: Exception) {
            return Resource.Error(exception.message ?: "Algo deu errado")
        }
        return Resource.Success(response)
    }

}