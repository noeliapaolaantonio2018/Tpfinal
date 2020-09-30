package com.example.tpfinal;

public class inmueble {
    private int foto;
    private String direccion;
    private double precio;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public inmueble(int foto, String direccion, double precio) {
        this.foto = foto;
        this.direccion = direccion;
        this.precio = precio;
    }
}
