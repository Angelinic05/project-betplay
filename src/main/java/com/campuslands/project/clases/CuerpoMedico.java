package com.campuslands.project.clases;

public class CuerpoMedico {
    private String nombre;
    private String rol;

    public CuerpoMedico(String nombre, String rol) {
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
