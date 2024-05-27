package com.arquitecturaTresCapas.datos;
import com.arquitecturaTresCapas.negocio.Producto;
public interface ProductoFactory {
    Producto crearProducto(String marca, String modelo, double precio, int stock);
}