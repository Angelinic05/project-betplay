package com.campuslands.project;

import java.util.Scanner;

import com.campuslands.project.clases.Liga;
import com.campuslands.project.clases.Jugador;
import com.campuslands.project.clases.CuerpoTecnico;
import com.campuslands.project.clases.CuerpoMedico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Liga liga = new Liga();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

                    // Agregar jugadores
                    System.out.println("¿Cuántos jugadores desea registrar para " + nombreEquipo + "?");
                    int numJugadores = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    for (int i = 0; i < numJugadores; i++) {
                        System.out.print("Ingrese el nombre del jugador: ");
                        String nombreJugador = scanner.nextLine();
                        System.out.print("Ingrese el dorsal del jugador: ");
                        int dorsal = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Ingrese la posición del jugador: ");
                        String posicion = scanner.nextLine();
                        System.out.print("Ingrese la nacionalidad del jugador: ");
                        String nacionalidad = scanner.nextLine();
                        System.out.print("Ingrese la fecha de ingreso del jugador (YYYY-MM-DD): ");
                        LocalDate fechaIngreso = LocalDate.parse(scanner.nextLine(), formatter);
                        Jugador jugador = new Jugador(nombreJugador, dorsal, posicion, nacionalidad, fechaIngreso);
                        liga.agregarJugadorAEquipo(nombreEquipo, jugador);
                    }

                    // Agregar cuerpo técnico
                    System.out.print("Ingrese el nombre del técnico: ");
                    String nombreTecnico = scanner.nextLine();
                    CuerpoTecnico tecnico = new CuerpoTecnico(nombreTecnico, "Técnico");
                    liga.agregarCuerpoTecnicoAEquipo(nombreEquipo, tecnico);

                    System.out.print("Ingrese el nombre del asistente técnico: ");
                    String nombreAsistente = scanner.nextLine();
                    CuerpoTecnico asistente = new CuerpoTecnico(nombreAsistente, "Asistente Técnico");
                    liga.agregarCuerpoTecnicoAEquipo(nombreEquipo, asistente);

                    System.out.print("Ingrese el nombre del preparador físico: ");
                    String nombrePreparador = scanner.nextLine();
                    CuerpoTecnico preparador = new CuerpoTecnico(nombrePreparador, "Preparador Físico");
                    liga.agregarCuerpoTecnicoAEquipo(nombreEquipo, preparador);

                    // Agregar cuerpo médico
                    System.out.print("Ingrese el nombre del fisioterapeuta: ");
                    String nombreFisioterapeuta = scanner.nextLine();
                    CuerpoMedico fisio = new CuerpoMedico(nombreFisioterapeuta, "Fisioterapeuta");
                    liga.agregarCuerpoMedicoAEquipo(nombreEquipo, fisio);

                    System.out.print("Ingrese el nombre del médico: ");
                    String nombreMedico = scanner.nextLine();
                    CuerpoMedico medico = new CuerpoMedico(nombreMedico, "Médico");
                    liga.agregarCuerpoMedicoAEquipo(nombreEquipo, medico);

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
                    System.out.println(String.format("Promedio de goles anotados en el torneo: %.2f", liga.promedioGolesAnotados()));
                    System.out.println("---------------------------------------------");

                    System.out.println("\nLista de Jugadores por Equipo:");
                    liga.imprimirJugadoresPorEquipo();

                    System.out.println("\nLista del Cuerpo Técnico por Equipo:");
                    liga.imprimirCuerpoTecnicoPorEquipo();

                    System.out.println("\nLista del Cuerpo Médico por Equipo:");
                    liga.imprimirCuerpoMedicoPorEquipo();

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
