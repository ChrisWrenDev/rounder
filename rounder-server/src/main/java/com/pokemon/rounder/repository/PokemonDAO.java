package com.pokemon.rounder.repository;

import java.util.List;

import com.pokemon.rounder.entity.Pokemon;

public interface PokemonDAO {

   void save(Pokemon pokemon);

   void update(Pokemon pokemon);

   Pokemon findById(Integer id);

   List<Pokemon> findAll();

   void delete(Integer id);

   int deleteAll();
}
