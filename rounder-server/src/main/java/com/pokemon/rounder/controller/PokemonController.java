package com.pokemon.rounder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.rounder.entity.Pokemon;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class PokemonController {
  private List<Pokemon> pokemon;

  // load the pokemon data (only once)
  @PostConstruct
  public void loadData() {
    pokemon = new ArrayList<>();

    // Request data from Pokemon apis
    // Update database with data
  }

  // define endpoint for "/pokemon" - return two pokemon for comparison
  @GetMapping("/pokemon")
  public List<Pokemon> getPokemon() {
    // Generate two random numbers between 1 - 151
    // Get the pokemon from database
    return pokemon;
  }

  // define endpoint for "/rankings" - return list of pokemon
  @GetMapping("/pokemon/ranking")
  public List<Pokemon> getRankings() {
    return pokemon;
  }

  // define endpoint for "/pokemon/{pokemonId}" - update pokemon ranking using id
  @PostMapping("/pokemon/{pokemonId}")
  public Pokemon getStudent(@PathVariable int pokemonId) {
    List<Pokemon> pokemon = new ArrayList<>();

    // Update pokemon ranking in database using id

    return pokemon.get(pokemonId);
  }
}
