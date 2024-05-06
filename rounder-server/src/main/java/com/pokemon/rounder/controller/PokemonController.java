package com.pokemon.rounder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.rounder.entity.Pokemon;
import com.pokemon.rounder.repository.PokemonDAO;
import com.pokemon.rounder.service.PokemonService;

@RestController
@RequestMapping("/api")
public class PokemonController {
  private PokemonDAO pokemonDAO;
  private PokemonService pokemonService;

  @Autowired
  public PokemonController(PokemonDAO thePokemonDAO, PokemonService thePokemonService){
    pokemonDAO = thePokemonDAO;
    pokemonService = thePokemonService;
  }

  // define endpoint for "/pokemon" - return list of pokemon
  @GetMapping("/pokemon")
  public List<Pokemon> getAllPokemon() {
    return pokemonDAO.findAll();
  }

  // define endpoint for "/pokemon/{pokemonId}" - return pokemon using id
  @GetMapping("/pokemon/{pokemonId}")
  public Pokemon getPokemon(@PathVariable int pokemonId) {
    // First check database
    Pokemon pokemonDB = pokemonDAO.findById(pokemonId);
    if(pokemonDB != null){
      return pokemonDB;
    }
    // Second request from endpoint (pokemonService) 
    Pokemon pokemonAPI = pokemonService.getPokemon(pokemonId);
    // Add to databse with 0 rank
    pokemonDAO.update(pokemonAPI);
    return pokemonAPI;
  }

  // define endpoint for "/pokemon" - update pokemon using payload
  @PostMapping("/pokemon")
  public void getStudent(@RequestBody Pokemon pokemon) {
    pokemonDAO.update(pokemon);
  }
}
