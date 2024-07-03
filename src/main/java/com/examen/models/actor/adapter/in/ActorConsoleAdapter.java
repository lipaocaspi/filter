package com.examen.models.actor.adapter.in;

import java.util.Scanner;

import com.examen.models.actor.application.ActorService;

public class ActorConsoleAdapter {
    private final ActorService ActorService;

    public ActorConsoleAdapter(ActorService actorService) {
        ActorService = actorService;
    }

    public void showMenu() {
        String menuActores = """
            1. Agregar Actor
            2. Editar Actor
            3. Eliminar Actor
            4. Listar Actores
            5. Salir
                """;

        System.out.println(menuActores);
        System.out.println("Ingrese una opción: ");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
                
        switch (option) {
            case 1:
                createActor();
                break;

            case 2:
                updateActor();
                break;

            case 3:
                deleteActor();
                break;
            case 4:
                listActor();
                break;
            case 5:
                break;
        }
    }

    public void createActor () {

    }

    public void updateActor () {

    }

    public void deleteActor () {

    }

    public void listActor () {

    }
}