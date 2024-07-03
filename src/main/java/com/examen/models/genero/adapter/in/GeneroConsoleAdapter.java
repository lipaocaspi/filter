package com.examen.models.genero.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.examen.models.genero.application.GeneroService;
import com.examen.models.genero.domain.Genero;

public class GeneroConsoleAdapter {
    

    private final GeneroService GeneroService;

    public GeneroConsoleAdapter(GeneroService generoService){
        GeneroService = generoService;
    }

    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        boolean isActive = true;

        while (isActive){
            String menuGeneros = """


                ---MENU GENEROS---
                [1]. Agregar Genero
                [2]. Editar Genero
                [3]. Eliminar Genero
                [4]. Listar Generos
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
        System.out.println("""
                ---CREAR UN GENERO---

                [*] DIGITE LA DESCRIPCION DEL GENERO A CREAR:
                """);
        String descripcion = "";
        descripcion = sc.nextLine();
        Genero genero = new Genero();
        genero.setDescripcion(descripcion);
        GeneroService.saveGenero(genero);
    }

    public void updateGenero () {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ---EDITE UN GENERO---

                [*] DIGITE EL ID DEL GENERO A EDITAR:
                """);
        int id = sc.nextInt();

        Optional<Genero> generos = GeneroService.findById(id);
        generos.ifPresentOrElse(
            a -> {
                sc.nextLine();
                System.out.println("[*]  INGRESE LA DESCRIPCION DEL GENERO");
                String descripcion ="";
                descripcion = sc.nextLine();
                Genero genero = new Genero();
                genero.setId(a.getId());
                genero.setDescripcion(descripcion);
                GeneroService.updateGenero(genero);
            },
            ()-> {
                System.out.println("[!] NO SE ENCONTRO EL GENERO");
            });
    }

    public void deleteGenero () {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ---ELIMINE UN GENERO---

                [*] DIGITE EL ID DEL GENERO A ELIMINAR:
                """);
        int id = sc.nextInt();

        Optional<Genero> generos = GeneroService.findById(id);
        generos.ifPresentOrElse(
            a -> {
                GeneroService.deleteGenero(id);
            },
            ()-> {
                System.out.println("[!] NO SE ENCONTRO EL GENERO");
            });
    }

    public void listGenero () {
        Scanner sc = new Scanner(System.in);
        List<Genero> listgenero = GeneroService.findAll();
        for (Genero genero : listgenero) {
            System.out.println(genero.getId() + " - " + genero.getDescripcion());
        }  
        sc.next();
    }
}