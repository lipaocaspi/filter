package com.examen.models.formato.application;

import java.util.List;
import java.util.Optional;

import com.examen.models.formato.domain.Formato;
import com.examen.models.formato.infrastructure.FormatoRepository;

public class FormatoService {
    private final FormatoRepository formatoRepository;

    public FormatoService(FormatoRepository formatoRepository){
        this.formatoRepository = formatoRepository;
    }
    
    public void saveFormato(Formato formato){
        this.formatoRepository.save(formato);
    }

    public void updateFormato(Formato formato){
        this.formatoRepository.update(formato);
    }

    public void deleteFormato(int id){
        this.formatoRepository.delete(id);
    }

    public Optional<Formato> findById(int id){
        return formatoRepository.findById(id);
    }

    public List<Formato> findAll() {
        return formatoRepository.findAll();
    }
}