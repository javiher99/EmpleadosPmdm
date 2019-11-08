package com.example.Deintpruebarecycler.model;

public class Contacto {
    private String nombre, email;

    public Contacto(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
