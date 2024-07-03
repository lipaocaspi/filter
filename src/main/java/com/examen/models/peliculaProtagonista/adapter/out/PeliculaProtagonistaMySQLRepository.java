package com.examen.models.peliculaProtagonista.adapter.out;

import java.util.List;
import java.util.Optional;

import com.examen.models.peliculaProtagonista.domain.PeliculaProtagonista;
import com.examen.models.peliculaProtagonista.infrastructure.PeliculaProtagonistaRepository;

public class PeliculaProtagonistaMySQLRepository implements PeliculaProtagonistaRepository {

    @Override
    public void save(PeliculaProtagonista peliculaProtagonista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(PeliculaProtagonista peliculaProtagonista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<PeliculaProtagonista> findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PeliculaProtagonista> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}