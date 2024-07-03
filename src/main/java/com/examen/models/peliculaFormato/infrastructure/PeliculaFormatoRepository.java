package com.examen.models.peliculaFormato.infrastructure;

import java.util.List;
import java.util.Optional;

import com.examen.models.peliculaFormato.domain.PeliculaFormato;

public interface PeliculaFormatoRepository {
    public void save(PeliculaFormato peliculaFormato);
    public void delete(int id);
    public void update(PeliculaFormato peliculaFormato);
    public Optional<PeliculaFormato> findById(int id);
    public List<PeliculaFormato> findAll();
}