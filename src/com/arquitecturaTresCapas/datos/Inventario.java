package com.arquitecturaTresCapas.datos;

import com.arquitecturaTresCapas.negocio.Producto;

import java.util.List;
public interface Inventario {

    void agregarProducto(Producto producto);

    List<Producto> buscarPorMarca(String marca);
}
