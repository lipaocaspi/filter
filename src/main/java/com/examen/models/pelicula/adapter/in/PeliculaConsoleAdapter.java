package com.examen.models.pelicula.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.examen.models.genero.domain.Genero;
import com.examen.models.pelicula.application.PeliculaService;
import com.examen.models.pelicula.domain.Pelicula;

public class PeliculaConsoleAdapter {
    private final PeliculaService PeliculaService;

    public PeliculaConsoleAdapter(PeliculaService peliculaService){
        PeliculaService = peliculaService;
    }

    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        boolean isActive = true;

        while (isActive){
            String menuGeneros = """


                ---MENU PELICULAS---
                [1]. Agregar Pelicula
                [2]. Editar Pelicula
                [3]. Eliminar Pelicula
                [4]. Listar Peliculas
                [5]. Salir

                [*] INGRESE UNA OPCION...
                """;
                System.out.println(menuGeneros);
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        createGenero();
                        break;
                    case 2:
                        updateGenero();
                        break;
                    case 3:
                        deleteGenero();
                        break;

                    case 4:
                        listGenero();
                        break;

                    case 5:
                        isActive = false;
                        break;
                    default:
                        System.out.println("[!] OPCION ERRONEA");
                        sc.next();
                        break;
                }
        }
    }
    public void createGenero () {
        Scanner sc = new Scanner(System.in);
        Pelicula pelicula = new Pelicula();
        System.out.println("""
                ---CREAR UNA PELICULA ---

                [*] DIGITE EL CODIGO INTERNO DE LA PELICULA:
                """);
        String codinterno = "";
        codinterno = sc.nextLine();
        pelicula.setCodInterno(codinterno);

        System.out.println("[*] DIGITE EL NOMBRE");
        String nombre = "";
        nombre = sc.nextLine();
        pelicula.setNombre(nombre);

        System.out.println("[*] DURACION DE LA PELICULA");
        String duracion = "";
        duracion = sc.nextLine();
        pelicula.setDuracion(duracion);

        System.out.println("[*] SINOPSIS DE LA PELICULA");
        String sinopsis = "";
        sinopsis = sc.nextLine();
        pelicula.setSinopsis(sinopsis);

        
        PeliculaService.savePelicula(pelicula);
        System.out.println("[!] SE HA AGREGADO CORRECTAMENTE");
        sc.nextLine();
    }

    public void updateGenero () {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ---EDITE UNA PELICULA---

                [*] DIGITE EL ID DE LA PELICULA A EDITAR:
                """);
        int id = sc.nextInt();

        Optional<Pelicula> peliculas = PeliculaService.findById(id);
        peliculas.ifPresentOrElse(
            a -> {
                Pelicula pelicula = new Pelicula();
                sc.nextLine();
                pelicula.setId(a.getId());
                System.out.println("[*] DIGITE EL CODIGO INTERNO");
                String codinterno = "";
                codinterno = sc.nextLine();
                pelicula.setCodInterno(codinterno);

                System.out.println("[*] DIGITE EL NOMBRE");
                String nombre = "";
                nombre = sc.nextLine();
                pelicula.setNombre(nombre);

                System.out.println("[*] DURACION DE LA PELICULA");
                String duracion = "";
                duracion = sc.nextLine();
                pelicula.setDuracion(duracion);

                System.out.println("[*] SINOPSIS DE LA PELICULA");
                String sinopsis = "";
                sinopsis = sc.nextLine();
                pelicula.setSinopsis(sinopsis);

                
                PeliculaService.updatePelicula(pelicula);
                System.out.println("[!] SE HA ACTUALIZADO CORRECTAMENTE");
                sc.nextLine();
            },
            ()-> {
                System.out.println("[!] NO SE ENCONTRO LA PELICULA");
            });
    }

    public void deleteGenero () {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ---ELIMINE UNA PELICULA---

                [*] DIGITE EL ID DE LA A ELIMINAR:
                """);
        int id = sc.nextInt();

        Optional<Pelicula> peliculas = PeliculaService.findById(id);
        peliculas.ifPresentOrElse(
            a -> {
                PeliculaService.deletePelicula(id);
            },
            ()-> {
                System.out.println("[!] NO SE ENCONTRO LA PELICULA");
            });
    }

    public void listGenero () {
        Scanner sc = new Scanner(System.in);
        List<Pelicula> listpeliculas = PeliculaService.findAll();
        for (Pelicula pelicula : listpeliculas) {
            System.out.println(pelicula.getId() + " - " + pelicula.getCodInterno()+ " - " + pelicula.getNombre()+ " - " +pelicula.getDuracion() +" - " + pelicula.getSinopsis());
        }  
        sc.next();
    }
}