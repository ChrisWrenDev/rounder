package com.pokemon.rounder.collaborator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PokemonCollaborator {
    public void getProducts(String url) {
        RestTemplate restTemplate = new RestTemplate(); // Bean - config class

        // String resourceUrl = "http://localhost:8080/products";

        // Fetch response as List wrapped in ResponseEntity
        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);

        List<Pokemon> pokemon = response.getBody();
        System.out.println(products);
    }
}
