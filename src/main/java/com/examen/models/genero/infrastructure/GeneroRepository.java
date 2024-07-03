package com.examen.models.genero.infrastructure;

import java.util.List;
import java.util.Optional;

import com.examen.models.genero.domain.Genero;

public interface GeneroRepository {
    public void save(Genero genero);
    public void delete(int id);
    public void update(Genero genero);
    public Optional<Genero> findById(int id);
    public List<Genero> findAll();
}