package com.pokemon.rounder.services;

import java.util.List;

import com.pokemon.rounder.entity.PokemonEntity;
import com.pokemon.rounder.models.PokemonApiResponse;

public interface PokemonService {
   PokemonEntity getPokemon(Integer id);

   PokemonEntity createPokemon(PokemonApiResponse response);

   void updatePokemon(PokemonEntity pokemon);

   List<PokemonEntity> getAllPokemon();
}
