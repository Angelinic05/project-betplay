package com.campuslands.project.clases;

public class Equipo {
    private String nombre;
    private int PJ; // Partidos jugados
    private int PG; // Partidos ganados
    private int PP; // Partidos perdidos
    private int PE; // Partidos empatados
    private int GF; // Goles a favor
    private int GC; // Goles en contra
    private int TP; // Total de puntos

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.PJ = 0;
        this.PG = 0;
        this.PP = 0;
        this.PE = 0;
        this.GF = 0;
        this.GC = 0;
        this.TP = 0;
    }

    // Getters y Setters para acceder a los atributos


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
}

