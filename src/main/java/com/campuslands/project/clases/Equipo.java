package com.campuslands.project.clases;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private int PJ; // Partidos jugados
    private int PG; // Partidos ganados
    private int PP; // Partidos perdidos
    private int PE; // Partidos empatados
    private int GF; // Goles a favor
    private int GC; // Goles en contra
    private int TP; // Total de puntos
    private List<Jugador> jugadores;
    private List<CuerpoTecnico> cuerpoTecnico;
    private List<CuerpoMedico> cuerpoMedico;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.PJ = 0;
        this.PG = 0;
        this.PP = 0;
        this.PE = 0;
        this.GF = 0;
        this.GC = 0;
        this.TP = 0;
        this.jugadores = new ArrayList<>();
        this.cuerpoTecnico = new ArrayList<>();
        this.cuerpoMedico = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getPJ() {
        return PJ;
    }

    public int getPG() {
        return PG;
    }

    public int getPP() {
        return PP;
    }

    public int getPE() {
        return PE;
    }

    public int getGF() {
        return GF;
    }

    public int getGC() {
        return GC;
    }

    public int getTP() {
        return TP;
    }

    public void incrementarPJ() {
        this.PJ++;
    }

    public void incrementarPG() {
        this.PG++;
        this.TP += 3;
    }

    public void incrementarPP() {
        this.PP++;
    }

    public void incrementarPE() {
        this.PE++;
        this.TP++;
    }

    public void incrementarGF(int goles) {
        this.GF += goles;
    }

    public void incrementarGC(int goles) {
        this.GC += goles;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public List<CuerpoTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public List<CuerpoMedico> getCuerpoMedico() {
        return cuerpoMedico;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void agregarCuerpoTecnico(CuerpoTecnico tecnico) {
        cuerpoTecnico.add(tecnico);
    }

    public void agregarCuerpoMedico(CuerpoMedico medico) {
        cuerpoMedico.add(medico);
    }
}
