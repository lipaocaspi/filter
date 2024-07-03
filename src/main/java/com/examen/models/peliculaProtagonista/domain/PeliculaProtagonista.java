package com.examen.models.peliculaProtagonista.domain;

public class PeliculaProtagonista {
    private int idProtagonista;
    private int idPelicula;
    private int idTipoactor;

    public PeliculaProtagonista(){}

    public PeliculaProtagonista(int idProtagonista, int idPelicula, int idTipoactor) {
        this.idProtagonista = idProtagonista;
        this.idPelicula = idPelicula;
        this.idTipoactor = idTipoactor;
    }
    public int getIdProtagonista() {
        return idProtagonista;
    }
    public void setIdProtagonista(int idProtagonista) {
        this.idProtagonista = idProtagonista;
    }
    public int getIdPelicula() {
        return idPelicula;
    }
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    public int getIdTipoactor() {
        return idTipoactor;
    }
    public void setIdTipoactor(int idTipoactor) {
        this.idTipoactor = idTipoactor;
    }

    
}