package com.campuslands.project.clases;

import java.util.ArrayList;
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
        int totalGoles = totalGolesAnotados();
        return equipos.size() > 0 ? (double) totalGoles / equipos.size() : 0;
    }

    public void imprimirTabla() {
        System.out.println(String.format("%-10s %2s %2s %2s %2s %2s %2s %2s",
                "Equipo", "PJ", "PG", "PP", "PE", "GF", "GC", "TP"));
        System.out.println("-----------------------------------------------------");

        for (Equipo equipo : equipos) {
            System.out.println(String.format("%-10s %2d %2d %2d %2d %2d %2d %2d",
                    equipo.getNombre(), equipo.getPJ(), equipo.getPG(), equipo.getPP(), equipo.getPE(),
                    equipo.getGF(), equipo.getGC(), equipo.getTP()));
        }

        System.out.println("\nPartidos:");
        for (Partido partido : partidos) {
            System.out.println(String.format("%s: %s %d - %d %s",
                    partido.getFecha(), partido.getLocal(), partido.getGolesLocal(), partido.getGolesVisitante(), partido.getVisitante()));
        }
    }
    
}
