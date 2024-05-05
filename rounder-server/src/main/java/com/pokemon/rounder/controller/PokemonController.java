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

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class PokemonController {
  private PokemonDAO pokemonDAO;

  @Autowired
  public PokemonController(PokemonDAO thePokemonDAO){
    pokemonDAO = thePokemonDAO;
  }

  // Request the pokemon data on load to populate database
  @Autowired
  @PostConstruct
  public void loadData(PokemonService pokemonService) {
    // Request data from Pokemon apis
    // Pokemon pokemon = new Pokemon(1,"full name","image url", 0);
    List<Pokemon> pokemons = pokemonService.getAllPokemon();
    // Update database with data
    for(Pokemon pokemon : pokemons){
      pokemonDAO.save(pokemon);
    }
  }

  // define endpoint for "/pokemon" - return list of pokemon
  @GetMapping("/pokemon")
  public List<Pokemon> getAllPokemon() {
    return pokemonDAO.findAll();
  }

  // define endpoint for "/pokemon/{pokemonId}" - return pokemon using id
  @GetMapping("/pokemon/{pokemonId}")
  public Pokemon getPokemon(@PathVariable int pokemonId) {
    return pokemonDAO.findById(pokemonId);
  }

  // define endpoint for "/pokemon" - update pokemon using payload
  @PostMapping("/pokemon")
  public void getStudent(@RequestBody Pokemon pokemon) {
    pokemonDAO.update(pokemon);
  }
}
