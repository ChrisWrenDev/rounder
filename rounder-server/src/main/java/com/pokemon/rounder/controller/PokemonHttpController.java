package com.pokemon.rounder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.pokemon.rounder.models.PokemonApiResponse;

public class PokemonHttpController {
    private RestTemplate restTemplate;

    @Autowired
    public PokemonHttpController(RestTemplate theRestTemplate) {
        restTemplate = theRestTemplate;
    }

    public PokemonApiResponse getPokemon(Integer id) {
        String resourceUrl = "https://pokeapi.co/api/v2/pokemon/" + id;

        PokemonApiResponse response = requestUrl(resourceUrl);

        return response;
    }

    public PokemonApiResponse requestUrl(String url) {
        return restTemplate.getForObject(url, PokemonApiResponse.class);
    }
}
