package com.campuslands.project.clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Liga {
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public Liga() {
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void registrarEquipo(String nombre) {
        equipos.add(new Equipo(nombre));
    }

    public void agregarJugadorAEquipo(String nombreEquipo, Jugador jugador) {
        Equipo equipo = buscarEquipo(nombreEquipo);
        if (equipo != null) {
            equipo.agregarJugador(jugador);
        } else {
            System.out.println("Equipo no encontrado.");
        }
    }

    public void agregarCuerpoTecnicoAEquipo(String nombreEquipo, CuerpoTecnico tecnico) {
        Equipo equipo = buscarEquipo(nombreEquipo);
        if (equipo != null) {
            equipo.agregarCuerpoTecnico(tecnico);
        } else {
            System.out.println("Equipo no encontrado.");
        }
    }

    public void agregarCuerpoMedicoAEquipo(String nombreEquipo, CuerpoMedico medico) {
        Equipo equipo = buscarEquipo(nombreEquipo);
        if (equipo != null) {
            equipo.agregarCuerpoMedico(medico);
        } else {
            System.out.println("Equipo no encontrado.");
        }
    }

    public void registrarPartido(String fecha, String local, String visitante, int golesLocal, int golesVisitante) {
        Equipo equipoLocal = buscarEquipo(local);
        Equipo equipoVisitante = buscarEquipo(visitante);

        if (equipoLocal != null && equipoVisitante != null) {
            equipoLocal.incrementarPJ();
            equipoVisitante.incrementarPJ();
            equipoLocal.incrementarGF(golesLocal);
            equipoVisitante.incrementarGF(golesVisitante);
            equipoLocal.incrementarGC(golesVisitante);
            equipoVisitante.incrementarGC(golesLocal);

            if (golesLocal > golesVisitante) {
                equipoLocal.incrementarPG();
                equipoVisitante.incrementarPP();
            } else if (golesLocal < golesVisitante) {
                equipoLocal.incrementarPP();
                equipoVisitante.incrementarPG();
            } else {
                equipoLocal.incrementarPE();
                equipoVisitante.incrementarPE();
            }

            partidos.add(new Partido(fecha, local, visitante, golesLocal, golesVisitante));
        } else {
            System.out.println("Uno o ambos equipos no existen.");
        }
    }

    private Equipo buscarEquipo(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    public String equipoMasGoles() {
        Equipo maxGolesEquipo = null;
        for (Equipo equipo : equipos) {
            if (maxGolesEquipo == null || equipo.getGF() > maxGolesEquipo.getGF()) {
                maxGolesEquipo = equipo;
            }
        }
        return maxGolesEquipo != null ? maxGolesEquipo.getNombre() : null;
    }

    public String equipoMasPuntos() {
        Equipo maxPuntosEquipo = null;
        for (Equipo equipo : equipos) {
            if (maxPuntosEquipo == null || equipo.getTP() > maxPuntosEquipo.getTP()) {
                maxPuntosEquipo = equipo;
            }
        }
        return maxPuntosEquipo != null ? maxPuntosEquipo.getNombre() : null;
    }

    public String equipoMasPartidosGanados() {
        Equipo maxPGEquipo = null;
        for (Equipo equipo : equipos) {
            if (maxPGEquipo == null || equipo.getPG() > maxPGEquipo.getPG()) {
                maxPGEquipo = equipo;
            }
        }
        return maxPGEquipo != null ? maxPGEquipo.getNombre() : null;
    }

    public int totalGolesAnotados() {
        int totalGoles = 0;
        for (Equipo equipo : equipos) {
            totalGoles += equipo.getGF();
        }
        return totalGoles;
    }

    public double promedioGolesAnotados() {
        return partidos.isEmpty() ? 0 : (double) totalGolesAnotados() / partidos.size();
    }

    public void imprimirTabla() {
        Collections.sort(equipos, Comparator.comparingInt(Equipo::getTP).reversed());
        System.out.printf("%-20s %-4s %-4s %-4s %-4s %-4s %-4s %-4s\n", "Equipo", "PJ", "PG", "PE", "PP", "GF", "GC", "TP");
        for (Equipo equipo : equipos) {
            System.out.printf("%-20s %-4d %-4d %-4d %-4d %-4d %-4d %-4d\n", equipo.getNombre(), equipo.getPJ(), equipo.getPG(), equipo.getPE(), equipo.getPP(), equipo.getGF(), equipo.getGC(), equipo.getTP());
        }
    }

    public void imprimirJugadoresPorEquipo() {
        for (Equipo equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (Jugador jugador : equipo.getJugadores()) {
                System.out.printf("Nombre: %-20s Dorsal: %-4d Posición: %-10s\n", jugador.getNombre(), jugador.getDorsal(), jugador.getPosicion());
            }
        }
    }

    public void imprimirCuerpoTecnicoPorEquipo() {
        for (Equipo equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (CuerpoTecnico tecnico : equipo.getCuerpoTecnico()) {
                System.out.printf("Nombre: %-20s Rol: %-20s\n", tecnico.getNombre(), tecnico.getRol());
            }
        }
    }

    public void imprimirCuerpoMedicoPorEquipo() {
        for (Equipo equipo : equipos) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (CuerpoMedico medico : equipo.getCuerpoMedico()) {
                System.out.printf("Nombre: %-20s Rol: %-20s\n", medico.getNombre(), medico.getRol());
            }
        }
    }
}