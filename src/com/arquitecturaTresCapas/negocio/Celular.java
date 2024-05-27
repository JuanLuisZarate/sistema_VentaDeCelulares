package com.arquitecturaTresCapas.negocio;

public class Celular extends Producto {
    public Celular(String marca, String modelo, double precio, int stock) {
        super(marca, modelo, precio, stock);
    }

    @Override
    public double obtenerPrecio() {
        return precio;
    }
}
