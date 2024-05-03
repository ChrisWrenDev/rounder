package com.pokemon.rounder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import jakarta.persistence.Column;

@Entity
@Table(name = "pokemon")
public class Pokemon {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "image")
  private String image;

  @Column(name = "rank")
  private int rank;

  public Pokemon(int id, String name, String image, int rank) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.rank = rank;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getRank() {
    return rank;
  }

  public void setEmail(int rank) {
    this.rank = rank;
  }

  @Override
  public String toString() {
    return "Pokemon{"
        + "id=" + id +
        ", name='" + name + '\'' +
        ", image='" + image + '\'' +
        ", rank='" + rank + '\'' + '}';
  }
}