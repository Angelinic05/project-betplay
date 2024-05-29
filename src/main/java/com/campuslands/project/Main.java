package com.campuslands.project;

import java.util.Scanner;

import com.campuslands.project.clases.Liga;

public class Main {
    public static void main(String[] args) {
        Liga liga = new Liga();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("");
            System.out.println("---------------MENU PRINCIPAL---------------");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Registrar partido");
            System.out.println("3. Generar reportes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("--------------------------------------------");

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del equipo: ");
                    String nombreEquipo = scanner.nextLine();
                    liga.registrarEquipo(nombreEquipo);
                    break;
                case 2:
                    System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Ingrese el nombre del equipo local: ");
                    String local = scanner.nextLine();
                    System.out.print("Ingrese el nombre del equipo visitante: ");
                    String visitante = scanner.nextLine();
                    System.out.print("Ingrese los goles del equipo local: ");
                    int golesLocal = scanner.nextInt();
                    System.out.print("Ingrese los goles del equipo visitante: ");
                    int golesVisitante = scanner.nextInt();
                    liga.registrarPartido(fecha, local, visitante, golesLocal, golesVisitante);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("-----------------REPORTES--------------------");
                    liga.imprimirTabla();
                    System.out.println("");
                    System.out.println("Equipo que más goles anotó: " + liga.equipoMasGoles());
                    System.out.println("Equipo con más puntos: " + liga.equipoMasPuntos());
                    System.out.println("Equipo que más partidos ganó: " + liga.equipoMasPartidosGanados());
                    System.out.println("Total de goles anotados por todos los equipos: " + liga.totalGolesAnotados());
                    System.out.println(String.format("Promedio de goles anotados en el torneo: %.0f", liga.promedioGolesAnotados()));
                    System.out.println("---------------------------------------------");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
