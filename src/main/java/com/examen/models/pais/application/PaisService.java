package com.examen.models.pais.application;

import java.util.List;
import java.util.Optional;

import com.examen.models.pais.domain.Pais;
import com.examen.models.pais.infrastructure.PaisRepository;

public class PaisService {
    private final PaisRepository PaisRepository;

    public PaisService(PaisRepository PaisRepository){
        this.PaisRepository = PaisRepository;
    }
    
    public void savePais(Pais pais){
        this.PaisRepository.save(pais);
    }

    public void updatePais(Pais pais){
        this.PaisRepository.update(pais);
    }

    public void deletePais(int id){
        this.PaisRepository.delete(id);
    }

    public Optional<Pais> findById(int id){
        return PaisRepository.findById(id);
    }

    public List<Pais> findAll() {
        return PaisRepository.findAll();
    }
}