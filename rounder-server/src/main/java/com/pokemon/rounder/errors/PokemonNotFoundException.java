package com.pokemon.rounder.errors;

public class PokemonNotFoundException  extends RuntimeException {
  public PokemonNotFoundException(String message){
    super(message);
  }
}