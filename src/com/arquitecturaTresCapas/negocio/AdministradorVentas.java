package com.arquitecturaTresCapas.negocio;

import com.arquitecturaTresCapas.datos.Inventario;

public class AdministradorVentas {
    private Inventario inventario;
    private EstadoVenta estadoVenta;

    public AdministradorVentas(Inventario inventario) {
        this.inventario = inventario;
        this.estadoVenta = new PreparandoVenta(); // Estado inicial
    }

    // Cambio en la firma del método para aceptar Producto directamente
    public void procesarVenta(Producto producto, int cantidad) {
        estadoVenta.manejar(this); // Preparando la venta

        if (producto != null && producto.getStock() >= cantidad) {
            producto.actualizarStock(cantidad);  // Asegúrate de que este método resta la cantidad
            double totalVenta = producto.obtenerPrecio() * cantidad;
            System.out.println("Venta procesada: " + cantidad + "x " + producto.getMarca() + " " + producto.getModelo() + " a Bs " + totalVenta);
            estadoVenta = new VentaExitosa();
        } else {
            System.out.println("Stock insuficiente o producto no encontrado.");
            estadoVenta = new VentaFallida();
        }
        estadoVenta.manejar(this); // Maneja el estado final de la venta (éxito o fallo)
    }
}

