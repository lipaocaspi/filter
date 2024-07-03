package com.examen.models.pelicula.domain;

public class Pelicula {
    private int id;
    private String codInterno; 
    private String nombre;
    private String duracion;
    private String sinopsis;

    public Pelicula(){}

    public Pelicula(int id, String codInterno, String nombre, String duracion, String sinopsis) {
        this.id = id;
        this.codInterno = codInterno;
        this.nombre = nombre;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(String codInterno) {
        this.codInterno = codInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    
}
