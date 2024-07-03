package com.examen.models.tipoActor.application;

import java.util.List;
import java.util.Optional;

import com.examen.models.tipoActor.domain.TipoActor;
import com.examen.models.tipoActor.infrastructure.TipoActorRepository;

public class TipoActorService {
    private final TipoActorRepository TipoActorRepository;

    public TipoActorService(TipoActorRepository TipoActorRepository){
        this.TipoActorRepository = TipoActorRepository;
    }
    
    public void savetipoActor(TipoActor tipoActor){
        this.TipoActorRepository.save(tipoActor);
    }

    public void updatetipoActor(TipoActor tipoActor){
        this.TipoActorRepository.update(tipoActor);
    }

    public void deletetipoActor(int id){
        this.TipoActorRepository.delete(id);
    }

    public Optional<TipoActor> findById(int id){
        return TipoActorRepository.findById(id);
    }

    public List<TipoActor> findAll() {
        return TipoActorRepository.findAll();
    }
}