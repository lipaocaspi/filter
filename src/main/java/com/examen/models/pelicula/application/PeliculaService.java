package com.examen.models.pelicula.application;

import java.util.List;
import java.util.Optional;

import com.examen.models.pelicula.domain.Pelicula;
import com.examen.models.pelicula.infrastructure.PeliculaRepository;

public class PeliculaService {
    private final PeliculaRepository PeliculaRepository;

    public PeliculaService(PeliculaRepository PeliculaRepository){
        this.PeliculaRepository = PeliculaRepository;
    }
    
    public void savePelicula(Pelicula pelicula){
        this.PeliculaRepository.save(pelicula);
    }

    public void updatePelicula(Pelicula pelicula){
        this.PeliculaRepository.update(pelicula);
    }

    public void deletePelicula(int id){
        this.PeliculaRepository.delete(id);
    }

    public Optional<Pelicula> findById(int id){
        return PeliculaRepository.findById(id);
    }

    public List<Pelicula> findAll() {
        return PeliculaRepository.findAll();
    }
}