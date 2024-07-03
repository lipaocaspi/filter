package com.examen.models.peliculaFormato.application;

import java.util.List;
import java.util.Optional;

import com.examen.models.peliculaFormato.domain.PeliculaFormato;
import com.examen.models.peliculaFormato.infrastructure.PeliculaFormatoRepository;

public class PeliculaFormatoService {
    private final PeliculaFormatoRepository PeliculaFormatoRepository;

    public PeliculaFormatoService(PeliculaFormatoRepository PeliculaFormatoRepository){
        this.PeliculaFormatoRepository = PeliculaFormatoRepository;
    }
    
    public void savepeliculaFormato(PeliculaFormato peliculaFormato){
        this.PeliculaFormatoRepository.save(peliculaFormato);
    }

    public void updatepeliculaFormato(PeliculaFormato peliculaFormato){
        this.PeliculaFormatoRepository.update(peliculaFormato);
    }

    public void deletepeliculaFormato(int id){
        this.PeliculaFormatoRepository.delete(id);
    }

    public Optional<PeliculaFormato> findById(int id){
        return PeliculaFormatoRepository.findById(id);
    }

    public List<PeliculaFormato> findAll() {
        return PeliculaFormatoRepository.findAll();
    }
}