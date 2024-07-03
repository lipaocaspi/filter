package com.examen.models.formato.adapter.in;

import java.text.Normalizer.Form;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.examen.models.formato.application.FormatoService;
import com.examen.models.formato.domain.Formato;
import com.examen.models.tipoActor.application.TipoActorService;
import com.examen.models.tipoActor.domain.TipoActor;

public class FormatoConsoleAdapter {
     private final FormatoService formatoService;

    public FormatoConsoleAdapter(FormatoService formatoService) {
        this.formatoService = formatoService;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean isActive = true;

        while (isActive) {
            String menuFormato = """
            1. Agregar Formato
            2. Editar Formato
            3. Eliminar Formato
            4. Listar Formato
            5. Salir
                """;

                System.out.println(menuFormato);
                System.out.println("Ingrese una opción: ");
                int option = sc.nextInt();
                        
                switch (option) {
                    case 1:
                        createFormato();
                        break;

                    case 2:
                        updateFormato();
                        break;

                    case 3:
                        deleteFormato();
                        break;
                    case 4:
                        listFormato();
                        break;
                    case 5:
                        isActive = false;
                        break;
                }
        }
        
    }

    public void createFormato () {
        System.out.println("Ingrese la descripción del formato: ");
        Scanner sc = new Scanner(System.in);
        String desc = sc.nextLine();
        Formato formato = new Formato();
        formato.setDescripcion(desc);
        formatoService.saveFormato(formato);
    }

    public void updateFormato () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del formato que desea editar: ");
        int id = sc.nextInt();
        Optional<Formato> formatoFound = formatoService.findById(id);
        sc.nextLine();
        formatoFound.ifPresentOrElse(
            spottedFormato -> {
                System.out.println("Ingrese la descripción del formato: ");
                String desc = sc.nextLine();
                Formato formato = new Formato();
                formato.setId(spottedFormato.getId());
                formato.setDescripcion(desc);
                formatoService.updateFormato(formato);
            }, 
            () -> {
                System.out.println("No se encontró tipo actor");
            });
        
    }

    public void deleteFormato () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del formato que desea eliminar: ");
        int id = sc.nextInt();
        Optional<Formato> formatoFound = formatoService.findById(id);
        formatoFound.ifPresentOrElse(
            spottedFormato -> {
                formatoService.deleteFormato(id);
            }, 
            () -> {
                System.out.println("No se encontró el formato");
            });
    }

    public void listFormato () {
        List<Formato> listFormato = formatoService.findAll();
        for (Formato formato : listFormato) {
            System.out.println(formato.getId() + " - " + formato.getDescripcion());
        }
    }
}