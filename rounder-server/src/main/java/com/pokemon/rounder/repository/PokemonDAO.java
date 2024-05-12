package com.pokemon.rounder.repository;

import java.util.List;

import com.pokemon.rounder.entity.PokemonEntity;

public interface PokemonDAO {

   void save(PokemonEntity pokemon);

   void update(PokemonEntity pokemon);

   PokemonEntity findById(Integer id);

   List<PokemonEntity> findAll();

   void delete(Integer id);

   int deleteAll();
}
