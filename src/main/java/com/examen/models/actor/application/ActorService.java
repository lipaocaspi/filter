package com.examen.models.actor.application;

import java.util.List;
import java.util.Optional;

import com.examen.models.actor.domain.Actor;
import com.examen.models.actor.infrastructure.ActorRepository;

public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void saveActor(Actor actor) {
        this.actorRepository.save(actor);
    }

    public void deleteActor(int id) {
        this.actorRepository.delete(id);
    }

    public void updateActor(Actor actor) {
        this.actorRepository.update(actor);
    }

    public Optional<Actor> findActorById(int id) {
        return actorRepository.findById(id);
    }

    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }
}