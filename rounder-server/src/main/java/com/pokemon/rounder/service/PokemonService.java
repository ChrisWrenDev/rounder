package com.pokemon.rounder.service;

import com.pokemon.rounder.entity.Pokemon;

public interface PokemonService {
   Pokemon getPokemon(Integer id);
   PokemonApiResponse requestUrl(String url);
}
