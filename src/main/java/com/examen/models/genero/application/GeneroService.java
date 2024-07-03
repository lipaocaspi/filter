package com.examen.models.genero.application;

import java.util.List;
import java.util.Optional;

import com.examen.models.genero.domain.Genero;
import com.examen.models.genero.infrastructure.GeneroRepository;

public class GeneroService {
    private final GeneroRepository GeneroRepository;

    public GeneroService(GeneroRepository GeneroRepository){
        this.GeneroRepository = GeneroRepository;
    }
    
    public void saveGenero(Genero genero){
        this.GeneroRepository.save(genero);
    }

    public void updateGenero(Genero genero){
        this.GeneroRepository.update(genero);
    }

    public void deleteGenero(int id){
        this.GeneroRepository.delete(id);
    }

    public Optional<Genero> findById(int id){
        return GeneroRepository.findById(id);
    }

    public List<Genero> findAll() {
        return GeneroRepository.findAll();
    }
}