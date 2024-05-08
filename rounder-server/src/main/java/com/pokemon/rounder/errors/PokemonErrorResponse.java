package com.pokemon.rounder.errors;

import lombok.Data;

@Data
public class PokemonErrorResponse {
  private int status;
  private String message;
  private long timeStamp;
}
