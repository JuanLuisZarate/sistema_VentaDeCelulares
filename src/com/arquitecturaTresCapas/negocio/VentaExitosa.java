package com.arquitecturaTresCapas.negocio;
public class VentaExitosa implements EstadoVenta {
    public void manejar(AdministradorVentas administradorVentas) {
        System.out.println("Venta completada con éxito.");
    }
}