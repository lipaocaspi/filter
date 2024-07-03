package com.examen.models.peliculaProtagonista.infrastructure;

import java.util.List;
import java.util.Optional;

import com.examen.models.peliculaProtagonista.domain.PeliculaProtagonista;

public interface PeliculaProtagonistaRepository {
    public void save(PeliculaProtagonista peliculaProtagonista);
    public void delete(int id);
    public void update(PeliculaProtagonista peliculaProtagonista);
    public Optional<PeliculaProtagonista> findById(int id);
    public List<PeliculaProtagonista> findAll();
}