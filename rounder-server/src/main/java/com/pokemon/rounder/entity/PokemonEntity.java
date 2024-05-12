package com.pokemon.rounder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;

import jakarta.persistence.Column;

@Entity
@Table(name = "pokemon")
@Data
public class PokemonEntity {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "image")
  private String image;

  @Column(name = "rank")
  private int rank;

}