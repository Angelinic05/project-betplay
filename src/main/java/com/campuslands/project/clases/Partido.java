package com.campuslands.project.clases;

public class Partido {
    private String fecha;
    private String local;
    private String visitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String fecha, String local, String visitante, int golesLocal, int golesVisitante) {
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLocal() {
        return local;
    }

    public String getVisitante() {
        return visitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }
}
