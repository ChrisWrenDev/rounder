package com.pokemon.rounder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllPokemon() throws Exception {
        // Arrange
        String pokemonJson = "{\"id\":\"1\",\"name\":\"bulbasaur\",\"image\":\"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/1.svg\",\"rank\":\"0\",}";

        // Act
        ResultActions result = mockMvc.perform(post("/api/pokemon")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pokemonJson));

        // Assert
        result.andExpect(status().isCreated())
              .andExpect(header().string("Location", "http://localhost/api/pokemon/1"));
  }


  @Test
  public void testGetPokemon() throws Exception {
        // Arrange
        int pokemonId = 1;

        // Act
        ResultActions result = mockMvc.perform(get("/api/pokemon/{id}", pokemonId));

        // Assert
        result.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("$.id").value(pokemonId))
              .andExpect(jsonPath("$.name").value("John Doe"))
              .andExpect(jsonPath("$.image").value("john.doe@example.com"))
              .andExpect(jsonPath("$.rank").value(0));
  }

  @Test
  public void testUpdatePokemon() throws Exception {
    // Arrange
    String userJson = "{\"name\":\"Alice\",\"email\":\"alice@example.com\"}";

    // Act
    ResultActions result = mockMvc.perform(post("/api/pokemon")
        .contentType(MediaType.APPLICATION_JSON)
        .content(userJson));

    // Assert
    result.andExpect(status().isCreated())
        .andExpect(header().string("Location", "http://localhost/api/pokemon/1"));
  }
}
