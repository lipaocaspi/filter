package com.examen.models.peliculaFormato.domain;

public class PeliculaFormato {
    private int idPelicula;
    private int idFormato;
    private int cantidad;
    
    public PeliculaFormato(){}

    public PeliculaFormato(int idPelicula, int idFormato, int cantidad) {
        this.idPelicula = idPelicula;
        this.idFormato = idFormato;
        this.cantidad = cantidad;
    }
    public int getIdPelicula() {
        return idPelicula;
    }
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    public int getIdFormato() {
        return idFormato;
    }
    public void setIdFormato(int idFormato) {
        this.idFormato = idFormato;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}