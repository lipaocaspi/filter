package com.examen.models.pais.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.examen.models.pais.application.PaisService;
import com.examen.models.pais.domain.Pais;

public class PaisConsoleAdapter {
    private final PaisService paisService;

    public PaisConsoleAdapter(PaisService paisService) {
        this.paisService = paisService;
    }


    public void showMenu() {
        int option;
        String menuPaises = """
            1. Agregar Pais
            2. Editar Pais
            3. Eliminar Pais
            4. Listar Paises
            5. Salir
                """;

        System.out.println(menuPaises);
        System.out.println("Ingrese una opción: ");
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
                
        switch (option) {
            case 1:
                createPais();
                break;

            case 2:
                updatePais();
                break;

            case 3:
                deletePais();
                break;
            case 4:
                listPais();
                break;
            case 5:
                break;
        }
    }

    public void createPais () {
        System.out.println("Ingrese la descripción del país: ");
        Scanner sc = new Scanner(System.in);
        String desc = sc.nextLine();
        Pais pais = new Pais();
        pais.setDescripcion(desc);
        paisService.savePais(pais);
    }

    public void updatePais () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del país que desea editar: ");
        int id = sc.nextInt();
        Optional<Pais> paisFound = paisService.findById(id);
        sc.nextLine();
        paisFound.ifPresentOrElse(
            spottedPais -> {
                System.out.println("Ingrese la descripción del país: ");
                String desc = sc.nextLine();
                Pais pais = new Pais();
                pais.setId(spottedPais.getId());
                pais.setDescripcion(desc);
                paisService.updatePais(pais);
            }, 
            () -> {
                System.out.println("No se encontró país");
            });
        
    }

    public void deletePais () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del país que desea eliminar: ");
        int id = sc.nextInt();
        Optional<Pais> paisFound = paisService.findById(id);
        paisFound.ifPresentOrElse(
            spottedPais -> {
                paisService.deletePais(id);
            }, 
            () -> {
                System.out.println("No se encontró país");
            });
    }

    public void listPais () {
        List<Pais> listPais = paisService.findAll();
        for (Pais pais : listPais) {
            System.out.println(pais.getId() + " - " + pais.getDescripcion());
        }
    }
}