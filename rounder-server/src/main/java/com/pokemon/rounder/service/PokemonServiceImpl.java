package com.pokemon.rounder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokemon.rounder.entity.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {

    private RestTemplate restTemplate;

    @Autowired
    public PokemonServiceImpl(RestTemplate theRestTemplate){
        restTemplate = theRestTemplate;
    }

    @Override
    public Pokemon getPokemon(Integer id){
       String resourceUrl  = "https://pokeapi.co/api/v2/pokemon/" + id;

       PokemonApiResponse response = requestUrl(resourceUrl);
       
       return createPokemon(response);
    }

    @Override
    public PokemonApiResponse requestUrl(String url){
        return restTemplate.getForObject(url, PokemonApiResponse.class);
    }

    private Pokemon createPokemon(PokemonApiResponse response){
        Pokemon pokemon = new Pokemon();
        pokemon.setId(response.getId());
        pokemon.setName(response.getName());
        pokemon.setImage(response.getSprites().getOther().getDream_world().getFront_default());
        pokemon.setRank(0);
        return pokemon;
    }
}
