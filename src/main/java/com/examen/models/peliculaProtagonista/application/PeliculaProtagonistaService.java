package com.examen.models.peliculaProtagonista.application;

import java.util.List;
import java.util.Optional;

import com.examen.models.peliculaProtagonista.domain.PeliculaProtagonista;
import com.examen.models.peliculaProtagonista.infrastructure.PeliculaProtagonistaRepository;

public class PeliculaProtagonistaService {
    private final PeliculaProtagonistaRepository PeliculaProtagonistaRepository;

    public PeliculaProtagonistaService(PeliculaProtagonistaRepository PeliculaProtagonistaRepository){
        this.PeliculaProtagonistaRepository = PeliculaProtagonistaRepository;
    }
    
    public void savepeliculaProtagonista(PeliculaProtagonista peliculaProtagonista){
        this.PeliculaProtagonistaRepository.save(peliculaProtagonista);
    }

    public void updatepeliculaProtagonista(PeliculaProtagonista peliculaProtagonista){
        this.PeliculaProtagonistaRepository.update(peliculaProtagonista);
    }

    public void deletepeliculaProtagonista(int id){
        this.PeliculaProtagonistaRepository.delete(id);
    }

    public Optional<PeliculaProtagonista> findById(int id){
        return PeliculaProtagonistaRepository.findById(id);
    }

    public List<PeliculaProtagonista> findAll() {
        return PeliculaProtagonistaRepository.findAll();
    }
}