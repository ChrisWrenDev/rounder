package com.pokemon.rounder.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pokemon.rounder.entity.Pokemon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PokemonDAOImpl implements PokemonDAO {
  private EntityManager entityManager;

  @Autowired
  public PokemonDAOImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  @Override
  @Transactional
  public void save(Pokemon pokemon) {
    entityManager.persist(pokemon);
  }

  @Override
  @Transactional
  public void update(Pokemon pokemon) {
    entityManager.merge(pokemon);
  }

  @Override
  public Pokemon findById(Integer id){
    return entityManager.find(Pokemon.class, id);
  }

  @Override
  public List<Pokemon> findAll() {
    TypedQuery<Pokemon> theQuery = entityManager.createQuery("FROM Pokemon", Pokemon.class);
    return theQuery.getResultList();
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    Pokemon pokemon = entityManager.find(Pokemon.class, id);
    entityManager.remove(pokemon);
  }

  @Override
  @Transactional
  public int deleteAll() {
    int numRowsDeleted = entityManager.createQuery("DELETE FROM Pokemon").executeUpdate();
    return numRowsDeleted;
  }
}
