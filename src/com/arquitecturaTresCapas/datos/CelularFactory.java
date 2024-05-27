package com.arquitecturaTresCapas.datos;
import com.arquitecturaTresCapas.negocio.Celular;
import com.arquitecturaTresCapas.negocio.Producto;

public class CelularFactory implements ProductoFactory {
    public Producto crearProducto(String marca, String modelo, double precio, int stock) {
        return new Celular(marca, modelo, precio, stock);
    }
}
