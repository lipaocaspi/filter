package com.examen.models.tipoActor.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.examen.models.tipoActor.application.TipoActorService;
import com.examen.models.tipoActor.domain.TipoActor;

public class TipoActorConsoleAdapter {
    private final TipoActorService tipoActorService;

    public TipoActorConsoleAdapter(TipoActorService tipoActorService) {
        this.tipoActorService = tipoActorService;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        boolean isActive = true;

        while (isActive) {
            String menuTipoActor = """
            1. Agregar Tipo Actor
            2. Editar Tipo Actor
            3. Eliminar Tipo Actor
            4. Listar Tipo Actor
            5. Salir
                """;

            System.out.println(menuTipoActor);
            System.out.println("Ingrese una opción: ");
            int option = sc.nextInt();
                    
            switch (option) {
                case 1:
                    createTipoActor();
                    break;

                case 2:
                    updateTipoActor();
                    break;

                case 3:
                    deleteTipoActor();
                    break;
                case 4:
                    listTipoActor();
                    break;
                case 5:
                    isActive = false;
                    break;
            }
        }
    }

    public void createTipoActor () {
        System.out.println("Ingrese la descripción del tipo actor: ");
        Scanner sc = new Scanner(System.in);
        String desc = sc.nextLine();
        TipoActor tipoActor = new TipoActor();
        tipoActor.setDescripcion(desc);
        tipoActorService.savetipoActor(tipoActor);
    }

    public void updateTipoActor () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del tipo actor que desea editar: ");
        int id = sc.nextInt();
        Optional<TipoActor> tipoActorFound = tipoActorService.findById(id);
        sc.nextLine();
        tipoActorFound.ifPresentOrElse(
            spottedTipoActor -> {
                System.out.println("Ingrese la descripción del tipo actor: ");
                String desc = sc.nextLine();
                TipoActor tipoActor = new TipoActor();
                tipoActor.setId(spottedTipoActor.getId());
                tipoActor.setDescripcion(desc);
                tipoActorService.updatetipoActor(tipoActor);
            }, 
            () -> {
                System.out.println("No se encontró tipo actor");
            });
        
    }

    public void deleteTipoActor () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del tipo actor que desea eliminar: ");
        int id = sc.nextInt();
        Optional<TipoActor> tipoActorFound = tipoActorService.findById(id);
        tipoActorFound.ifPresentOrElse(
            spottedPais -> {
                tipoActorService.deletetipoActor(id);
            }, 
            () -> {
                System.out.println("No se encontró tipo actor");
            });
    }

    public void listTipoActor () {
        List<TipoActor> listTipoActor = tipoActorService.findAll();
        for (TipoActor tipoActor : listTipoActor) {
            System.out.println(tipoActor.getId() + " - " + tipoActor.getDescripcion());
        }
    }
}