package com.examen;

import java.util.Scanner;

import com.examen.models.actor.adapter.out.ActorMySQLRepository;
import com.examen.models.formato.adapter.out.FormatoMySQLRepository;
import com.examen.models.genero.adapter.out.GeneroMySQLRepository;
import com.examen.models.pais.adapter.out.PaisMySQLRepository;
import com.examen.models.pelicula.adapter.out.PeliculaMySQLRepository;
import com.examen.models.peliculaFormato.adapter.out.PeliculaFormatoMySQLRepository;
import com.examen.models.peliculaProtagonista.adapter.out.PeliculaProtagonistaMySQLRepository;

public class Main {
    public static void main(String[] args) {
        String url =  "";
        String user= "";
        String password = "";

        ActorMySQLRepository actorMySQLRepository = new ActorMySQLRepository(url, user password);
        PeliculaProtagonistaMySQLRepository

        Scanner sc = new Scanner(System.in);
        String menu ="""
                ---CINE CAMPUS---

                    [1]. GESTION ACTORES
                    [2]. GESTION PELICULAS
                    [3]. GESTION FORMATOS
                    [4]. ASIGNACION DE ACTORES A PELICULAS
                    [5]. GESTION DE GENEROS
                    [6]. GESTION DE PAISES 
                    [7]. GESTION DE TIPOS DE ACTORES 
                    [8]. CONSULTA LA INFORMACION DETALLADA DE UNA PELICULA 
                    [9]. LISTAR ACTORES POR PELICULA
                    [10]. SALIR

                    [*] SELECIONE UNA OPCION...
                """;

        System.out.println(menu);
        int opt = sc.nextInt();

        switch (opt) {
            case 1 ->  {

            }
            case 2 -> {

            }
            case 3 -> {
                
            }
            case 4 -> {
                
            }
            case 5 -> {
                
            }
            case 6 -> {
                
            }
            case 7 -> {
                
            }
            case 8 -> {
                
            }
            case 9 -> {
                
            }
            case 10 -> {
                
            }
            default -> {
                System.out.println("[!] OPCION INVALIDA...");
            }          
        }
    }
}