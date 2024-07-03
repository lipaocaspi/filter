package com.examen.models.actor.infrastructure;

import java.util.List;
import java.util.Optional;

import com.examen.models.actor.domain.Actor;

public interface ActorRepository {
    public void save(Actor actor);
    public void delete(int id);
    public void update(Actor actor);
    public Optional<Actor> findById(int id);
    public List<Actor> findAll();
}