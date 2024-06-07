package com.campuslands.project.clases;

import java.time.LocalDate;

public class Jugador {
    private String nombre;
    private int dorsal;
    private String posicion;
    private String nacionalidad;
    private LocalDate fechaIngreso;
    private int golesAnotados;
    private int tarjetasRojas;
    private int tarjetasAmarillas;

    public Jugador(String nombre, int dorsal, String posicion, String nacionalidad, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.golesAnotados = 0;
        this.tarjetasRojas = 0;
        this.tarjetasAmarillas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void anotarGol() {
        this.golesAnotados++;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void recibirTarjetaRoja() {
        this.tarjetasRojas++;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void recibirTarjetaAmarilla() {
        this.tarjetasAmarillas++;
    }
}
