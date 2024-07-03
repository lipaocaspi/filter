package com.examen.models.tipoActor.infrastructure;

import java.util.List;
import java.util.Optional;

import com.examen.models.tipoActor.domain.TipoActor;

public interface TipoActorRepository {
    public void save(TipoActor tipoActor);
    public void delete(int id);
    public void update(TipoActor tipoActor);
    public Optional<TipoActor> findById(int id);
    public List<TipoActor> findAll();
}