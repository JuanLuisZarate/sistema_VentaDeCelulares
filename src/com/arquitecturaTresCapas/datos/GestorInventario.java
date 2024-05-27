package com.arquitecturaTresCapas.datos;

import com.arquitecturaTresCapas.negocio.Producto;

import java.util.List;
public interface GestorInventario {
    void agregarProducto(Producto producto);
    List<Producto> buscarPorMarca(String marca);
}