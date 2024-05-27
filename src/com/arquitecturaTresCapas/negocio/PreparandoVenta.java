package com.arquitecturaTresCapas.negocio;
public class PreparandoVenta implements EstadoVenta {
    public void manejar(AdministradorVentas administradorVentas) {
        System.out.println("Preparando la venta...");
    }
}