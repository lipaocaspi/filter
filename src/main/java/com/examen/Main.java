package com.examen;

import java.util.Scanner;

import com.examen.models.actor.adapter.in.ActorConsoleAdapter;
import com.examen.models.actor.adapter.out.ActorMySQLRepository;
import com.examen.models.actor.application.ActorService;
import com.examen.models.formato.adapter.in.FormatoConsoleAdapter;
import com.examen.models.formato.adapter.out.FormatoMySQLRepository;
import com.examen.models.formato.application.FormatoService;
import com.examen.models.genero.adapter.in.GeneroConsoleAdapter;
import com.examen.models.genero.adapter.out.GeneroMySQLRepository;
import com.examen.models.genero.application.GeneroService;
import com.examen.models.pais.adapter.in.PaisConsoleAdapter;
import com.examen.models.pais.adapter.out.PaisMySQLRepository;
import com.examen.models.pais.application.PaisService;
import com.examen.models.pelicula.adapter.in.PeliculaConsoleAdapter;
import com.examen.models.pelicula.adapter.out.PeliculaMySQLRepository;
import com.examen.models.pelicula.application.PeliculaService;
import com.examen.models.peliculaFormato.adapter.out.PeliculaFormatoMySQLRepository;
import com.examen.models.tipoActor.adapter.in.TipoActorConsoleAdapter;
import com.examen.models.tipoActor.adapter.out.TipoActorMySQLRepository;
import com.examen.models.tipoActor.application.TipoActorService;

public class Main {
    public static void main(String[] args) {
        String url =  "jdbc:mysql://localhost:3306/cinecampus";
        String user= "root";
        String password = "123456";

        ActorMySQLRepository actorMySQLRepository = new ActorMySQLRepository(url, user, password);
        FormatoMySQLRepository formatoMySQLRepository = new FormatoMySQLRepository(url, user, password);
        GeneroMySQLRepository generoMySQLRepository = new GeneroMySQLRepository(url, user , password);
        PaisMySQLRepository paisMySQLRepository = new PaisMySQLRepository(url, user, password);
        PeliculaMySQLRepository peliculaMySQLRepository = new PeliculaMySQLRepository(url, user, password);
        PeliculaFormatoMySQLRepository peliculaFormatoMySQLRepository = new PeliculaFormatoMySQLRepository(url, user, password);
        // PeliculaProtagonistaMySQLRepository peliculaProtagonistaMySQLRepository = new PeliculaProtagonistaMySQLRepository(url, user, password);
        TipoActorMySQLRepository tipoActorMySQLRepository = new TipoActorMySQLRepository(url, user, password);
        boolean isActive = true;
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
                ActorService actorService = new ActorService(actorMySQLRepository);
                ActorConsoleAdapter actorConsoleAdapter = new ActorConsoleAdapter(actorService);
                actorConsoleAdapter.showMenu();
            }
            case 2 -> {
                PeliculaService peliculaService = new PeliculaService(peliculaMySQLRepository);
                PeliculaConsoleAdapter peliculaConsoleAdapter = new PeliculaConsoleAdapter(peliculaService);
                peliculaConsoleAdapter.showMenu();
            }
            case 3 -> {
                FormatoService formatoService = new FormatoService(formatoMySQLRepository);
                FormatoConsoleAdapter formatoConsoleAdapter = new FormatoConsoleAdapter(formatoService);
                formatoConsoleAdapter.showMenu();
            }
            case 4 -> {
                
            }
            case 5 -> {
                GeneroService generoService = new GeneroService(generoMySQLRepository);
                GeneroConsoleAdapter generoConsoleAdapter = new GeneroConsoleAdapter(generoService);
                generoConsoleAdapter.showMenu();
                
            }
            case 6 -> {
                PaisService paisService = new PaisService(paisMySQLRepository);
                PaisConsoleAdapter paisConsoleAdapter = new PaisConsoleAdapter(paisService);
                paisConsoleAdapter.showMenu();
            }
            case 7 -> {
                TipoActorService tipoActorService = new TipoActorService(tipoActorMySQLRepository);
                TipoActorConsoleAdapter tipoActorConsoleAdapter = new TipoActorConsoleAdapter(tipoActorService);
                tipoActorConsoleAdapter.showMenu();
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
