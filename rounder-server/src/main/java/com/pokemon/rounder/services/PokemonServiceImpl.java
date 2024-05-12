package com.pokemon.rounder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.rounder.controller.PokemonHttpController;
import com.pokemon.rounder.entity.PokemonEntity;
import com.pokemon.rounder.models.PokemonApiResponse;
import com.pokemon.rounder.repository.PokemonDAO;

@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonHttpController pokemonHttpController;
    private PokemonDAO pokemonDAO;

    @Autowired
    public PokemonServiceImpl(PokemonHttpController thePokemonHttpController, PokemonDAO thePokemonDAO) {
        pokemonHttpController = thePokemonHttpController;
        pokemonDAO = thePokemonDAO;
    }

    @Override
    public PokemonEntity getPokemon(Integer id) {
        // Check database for existing Pokemon
        PokemonEntity pokemonDB = pokemonDAO.findById(id);
        if (pokemonDB != null)
            return pokemonDB;
        // Call Pokemon API to get Pokemon
        PokemonApiResponse response = pokemonHttpController.getPokemon(id);
        // Create Pokemon from API response
        PokemonEntity pokemonAPI = createPokemon(response);
        // Update database with new Pokemon
        pokemonDAO.save(pokemonAPI);

        return pokemonAPI;
    }

    public PokemonEntity createPokemon(PokemonApiResponse response) {
        PokemonEntity pokemon = new PokemonEntity();
        pokemon.setId(response.getId());
        pokemon.setName(response.getName());
        pokemon.setImage(response.getSprites().getOther().getDream_world().getFront_default());
        pokemon.setRank(0);
        return pokemon;
    }

    public void updatePokemon(PokemonEntity pokemon) {
        pokemonDAO.update(pokemon);
    }

    public List<PokemonEntity> getAllPokemon() {
        return pokemonDAO.findAll();
    }

}
