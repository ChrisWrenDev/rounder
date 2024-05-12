package com.pokemon.rounder.models;

import lombok.Data;

@Data
public class PokemonApiResponse {
    private Integer id;
    private String name;
    private PokemonApiSprites sprites;
}
