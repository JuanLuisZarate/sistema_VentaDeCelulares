package com.arquitecturaTresCapas;

import com.arquitecturaTresCapas.negocio.AdministradorInventario;
import com.arquitecturaTresCapas.negocio.AdministradorVentas;
import com.arquitecturaTresCapas.presentacion.VentaCelularesUI;
public class Main {
    public static void main(String[] args) {
        // Creación de la instancia del Administrador de Inventario
        AdministradorInventario administradorInventario = new AdministradorInventario();

        // Creación de la instancia del Administrador de Ventas
        AdministradorVentas administradorVentas = new AdministradorVentas(administradorInventario);

        // Creación e inicialización de la interfaz de usuario
        VentaCelularesUI ui = new VentaCelularesUI(administradorVentas, administradorInventario);
        ui.iniciar();
    }
}
