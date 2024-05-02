package com.pokemon.rounder.dao;

import java.util.List;

import com.pokemon.rounder.entity.Pokemon;

public class PokemonDAO {

   void save(Pokemon pokemon);

   void update(Pokemon pokemon);
   
   List<Pokemon> getRankings();

   void delete(Integer id);

   int deleteAll();
}
