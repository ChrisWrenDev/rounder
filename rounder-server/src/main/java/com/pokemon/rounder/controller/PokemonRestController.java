package com.pokemon.rounder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.rounder.entity.PokemonEntity;
import com.pokemon.rounder.repository.PokemonDAO;
import com.pokemon.rounder.services.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonRestController {
  private PokemonService pokemonService;

  @Autowired
  public PokemonRestController(PokemonDAO thePokemonDAO, PokemonService thePokemonService) {
    pokemonService = thePokemonService;
  }

  // define endpoint for "/pokemon" - return list of pokemon
  @GetMapping("/")
  public List<PokemonEntity> getAllPokemon() {
    return pokemonService.getAllPokemon();
  }

  // define endpoint for "/pokemon/{pokemonId}" - return pokemon using id
  @GetMapping("/{pokemonId}")
  public PokemonEntity getPokemon(@PathVariable int pokemonId) {
    return pokemonService.getPokemon(pokemonId);
  }

  // define endpoint for "/pokemon" - update pokemon using payload
  @PostMapping("/")
  public void updatePokemon(@RequestBody PokemonEntity pokemon) {
    pokemonService.updatePokemon(pokemon);
  }
}
