package com.arquitecturaTresCapas.presentacion;

import com.arquitecturaTresCapas.negocio.AdministradorInventario;
import com.arquitecturaTresCapas.negocio.AdministradorVentas;
import com.arquitecturaTresCapas.negocio.Celular;
import com.arquitecturaTresCapas.negocio.Producto;

import java.util.List;
import java.util.Scanner;

public class VentaCelularesUI {
    private AdministradorVentas administradorVentas;
    private AdministradorInventario administradorInventario;
    private Scanner scanner = new Scanner(System.in);

    public VentaCelularesUI(AdministradorVentas administradorVentas, AdministradorInventario administradorInventario) {
        this.administradorVentas = administradorVentas;
        this.administradorInventario = administradorInventario;
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\nSeleccione que opción desea realizar:");
            System.out.println("1. Ver Productos");
            System.out.println("2. Añadir Producto");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Realizar Venta");
            System.out.println("0. Salir del Menú");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer del scanner

            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    realizarVenta();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void mostrarProductos() {
        // Obtener la lista de productos desde el inventario
        List<Producto> productos = administradorInventario.getListaProductos();

        if (productos.isEmpty()) {
            System.out.println("No existen productos en el inventario.");
        } else {
            System.out.println("\nListado de Productos:");
            System.out.println("-------------------------------");
            int numeroProducto = 1;
            for (Producto producto : productos) {
                System.out.println("Número de Producto: " + numeroProducto);
                System.out.println("Producto: Celular");
                System.out.println("Marca: " + producto.getMarca());
                System.out.println("Modelo: " + producto.getModelo());
                System.out.println("Precio: $" + producto.obtenerPrecio());
                System.out.println("Cantidad: " + producto.getStock());
                System.out.println("-------------------------------");
                numeroProducto++;
            }
        }
    }


    private void agregarProducto() {
        System.out.print("Ingrese la marca del celular: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del celular: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el precio del celular: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad en stock: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer del scanner
        administradorInventario.agregarProducto(new Celular(marca, modelo, precio, cantidad));
        System.out.println("Producto añadido exitosamente.");
    }

    private void buscarProducto() {
        System.out.print("Ingrese la marca del producto a buscar: ");
        String marca = scanner.nextLine();  // Captura la entrada del usuario

        List<Producto> productosEncontrados = administradorInventario.buscarPorMarca(marca);

        if (productosEncontrados.isEmpty()) {
            System.out.println("No se encontraron productos con la marca especificada.");
        } else {
            System.out.println("\nProductos encontrados:");
            System.out.println("-------------------------------");
            for (Producto producto : productosEncontrados) {
                System.out.println("Producto: Celular");  // Asumiendo que todos los productos son celulares
                System.out.println("Marca: " + producto.getMarca());
                System.out.println("Modelo: " + producto.getModelo());
                System.out.println("Precio: $" + producto.obtenerPrecio());
                System.out.println("Cantidad: " + producto.getStock());
                System.out.println("-------------------------------");
            }
        }
    }

    private void realizarVenta() {
        mostrarProductos();
        System.out.print("Ingrese el número del producto que desea comprar: ");
        int numProducto = scanner.nextInt();
        System.out.print("Ingrese la cantidad que desea comprar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner

        List<Producto> productos = administradorInventario.getListaProductos();
        if (numProducto > 0 && numProducto <= productos.size()) {
            Producto productoSeleccionado = productos.get(numProducto - 1);
            if (productoSeleccionado.getStock() >= cantidad) {
                administradorVentas.procesarVenta(productoSeleccionado, cantidad);
            } else {
                System.out.println("No hay suficiente stock disponible. Solo quedan " + productoSeleccionado.getStock() + " unidades.");
            }
        } else {
            System.out.println("Número de producto inválido. Por favor, intente de nuevo.");
        }
    }

}
