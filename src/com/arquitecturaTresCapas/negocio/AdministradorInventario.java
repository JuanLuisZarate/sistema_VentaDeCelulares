package com.arquitecturaTresCapas.negocio;

import com.arquitecturaTresCapas.datos.Inventario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministradorInventario implements Inventario {
    private List<Producto> productos = new ArrayList<>();

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto añadido: " + producto.getMarca() + " " + producto.getModelo()+ " Precio "+ producto.obtenerPrecio());
    }
    @Override
    public List<Producto> buscarPorMarca(String marca) {
        return productos.stream().filter(p -> p.getMarca().equalsIgnoreCase(marca)).collect(Collectors.toList());
    }
    public List<Producto> getListaProductos() {
        return new ArrayList<>(productos);  // Devuelve una copia de la lista de productos
    }
}
