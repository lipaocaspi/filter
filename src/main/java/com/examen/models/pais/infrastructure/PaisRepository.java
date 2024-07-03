package com.examen.models.pais.infrastructure;

import java.util.List;
import java.util.Optional;

import com.examen.models.pais.domain.Pais;

public interface PaisRepository {
    public void save(Pais pais);
    public void delete(int id);
    public void update(Pais pais);
    public Optional<Pais> findById(int id);
    public List<Pais> findAll();
}