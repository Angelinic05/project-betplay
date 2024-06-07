package com.campuslands.project.clases;

public class CuerpoTecnico {
    private String nombre;
    private String rol;

    public CuerpoTecnico(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }
}
