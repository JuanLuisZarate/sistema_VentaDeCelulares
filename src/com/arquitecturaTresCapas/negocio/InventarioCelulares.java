package com.arquitecturaTresCapas.negocio;

import com.arquitecturaTresCapas.datos.GestorInventario;
import com.arquitecturaTresCapas.datos.Inventario;

import java.util.List;
public class InventarioCelulares implements GestorInventario {
    private Inventario inventario;

    public InventarioCelulares(Inventario inventario) {
        this.inventario = inventario;
    }

    public void agregarProducto(Producto producto) {
        inventario.agregarProducto(producto);
    }

    public List<Producto> buscarPorMarca(String marca) {
        return inventario.buscarPorMarca(marca);
    }
}