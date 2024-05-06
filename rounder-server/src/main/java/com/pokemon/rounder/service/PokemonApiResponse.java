package com.pokemon.rounder.service;

import lombok.Data;

@Data
public class PokemonApiResponse {
    private Integer id;
    private String name;
    private Sprites sprites;

    @Data
    public static class Sprites {
        private Other other;

        @Data
        public static class Other {
            private DreamWorld dream_world;
            
            @Data
            public static class DreamWorld {
                private String front_default;
            }
        }
    }
}

