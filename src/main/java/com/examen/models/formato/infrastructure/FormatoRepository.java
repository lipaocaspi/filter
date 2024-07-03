package com.examen.models.formato.infrastructure;

import java.util.List;
import java.util.Optional;

import com.examen.models.formato.domain.Formato;

public interface FormatoRepository {
    public void save(Formato formato);
    public void delete(int id);
    public void update(Formato formato);
    public Optional<Formato> findById(int id);
    public List<Formato> findAll();
}