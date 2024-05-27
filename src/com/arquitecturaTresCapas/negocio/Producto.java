package com.arquitecturaTresCapas.negocio;

public abstract class Producto implements Vendible {
    protected String marca;
    protected String modelo;
    protected double precio;
    protected int stock;

    public Producto(String marca, String modelo, double precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    @Override
    public double obtenerPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }

    public void actualizarStock(int cantidadVendida) {
        if (cantidadVendida > 0 && this.stock >= cantidadVendida) {
            this.stock -= cantidadVendida;
        } else {
            System.out.println("Error: cantidad de venta inválida o stock insuficiente.");
        }
    }

}