package com.examen.models.pelicula.infrastructure;

import java.util.List;
import java.util.Optional;

import com.examen.models.pelicula.domain.Pelicula;

public interface PeliculaRepository {
    public void save(Pelicula pelicula);
    public void delete(int id);
    public void update(Pelicula pelicula);
    public Optional<Pelicula> findById(int id);
    public List<Pelicula> findAll();
}