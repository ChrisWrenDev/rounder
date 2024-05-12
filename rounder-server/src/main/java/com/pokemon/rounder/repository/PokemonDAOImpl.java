package com.pokemon.rounder.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pokemon.rounder.entity.PokemonEntity;

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
  public void save(PokemonEntity pokemon) {
    entityManager.persist(pokemon);
  }

  @Override
  @Transactional
  public void update(PokemonEntity pokemon) {
    entityManager.merge(pokemon);
  }

  @Override
  public PokemonEntity findById(Integer id) {
    return entityManager.find(PokemonEntity.class, id);
  }

  @Override
  public List<PokemonEntity> findAll() {
    TypedQuery<PokemonEntity> theQuery = entityManager.createQuery("FROM Pokemon", PokemonEntity.class);
    return theQuery.getResultList();
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    PokemonEntity pokemon = entityManager.find(PokemonEntity.class, id);
    entityManager.remove(pokemon);
  }

  @Override
  @Transactional
  public int deleteAll() {
    int numRowsDeleted = entityManager.createQuery("DELETE FROM Pokemon").executeUpdate();
    return numRowsDeleted;
  }
}
