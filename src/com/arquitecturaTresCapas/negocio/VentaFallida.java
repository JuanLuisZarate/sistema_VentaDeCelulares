package com.arquitecturaTresCapas.negocio;
public class VentaFallida implements EstadoVenta {
    public void manejar(AdministradorVentas administradorVentas) {
        System.out.println("Venta fallida. Revisar inventario o datos de entrada.");
    }
}