*======= GUIA ========*
Este proyecto (sistema) se enfoca en el modulo de venta de celulares.
requisitos tener java (se recomienda la version actual), jdk o sdk instalado dependiendo el id que utilizara.
ID Se utilizao IntelliJ IDEA comunity 2023.2.2, si tiene otro tambien podria clonarlo.

Si quieres hacer correr el proyecto debes de clonar este proyecto en tu computadora utilizando git (github)
Debes ejecutar es (Run) en  'sistema_VentaDeCelulares/src/com/arquitecturaTresCapas/Main'
Te dezplazara un menu con todas las operaciones siguelas y podras probar todas las funcionalidades:

El módulo que estamos utilizando es la venta de celulares.
Este sistema maneja la administración de inventarios, ventas de celulares, con funcionalidades como:

1. Agregar Celulares al Inventario: Añadir nuevos modelos de celulares al sistema con detalles como marca, modelo, precio y cantidad en stock.

2. Buscar Celulares: Permitir la búsqueda de celulares en el inventario por marca o modelo.

3 . Procesar Ventas: Realizar ventas de celulares, actualizar el inventario y mostrar el estado de la factura.
   

 APLICANDO PRINCIPIOS S.O.L.I.D
===============

*1. Principio de Responsabilidad Única (SRP)*
     
-Capa de Datos:
Inventario: Define claramente las operaciones que se pueden realizar sobre el inventario.

ProductoFactory, CelularFactory. Cada fábrica se centra en la creación de un tipo específico de producto.

-Capa de Negocio:

AdministradorInventario, Se ocupa exclusivamente de la gestión del inventario.

AdministradorVentas: Maneja todas las operaciones relacionadas con las ventas.

-Capa de Presentación:

VentaCelularesUI, Se dedica únicamente a la interacción con el usuario, mostrando menús y recogiendo entradas.



   *2. Principio de Abierto/Cerrado (OCP)*
      
Capa de Datos: Las interfaces como Inventario.java permiten que nuevas implementaciones del manejo de inventario sean añadidas sin alterar el código existente.

Capa de Negocio: EstadoVenta.java y sus implementaciones permiten que el proceso de venta incorpore nuevos estados sin necesidad de modificar los estados existentes.

Capa de Presentación: VentaCelularesUI.java podría ser extendida con nuevas funcionalidades de menú sin necesidad de modificar las funcionalidades existentes.

 
   
   *3. Principio de Sustitución de Liskov (LSP)*
      
Capa de Datos: ProductoFactory y sus implementaciones como CelularFactory aseguran que los productos creados sean intercambiables bajo el mismo tipo base.

Capa de Negocio: Producto, Celular: Celular puede sustituir Producto en cualquier función que requiera un Producto.

  
   
   *4. Principio de Segregación de la Interfaz (ISP)*
      
Capa de Datos: Inventario proporciona solo los métodos necesarios para las operaciones de inventario, lo que evita que las clases implementadoras tengan que implementar métodos irrelevantes.

Capa de Negocio: Interfaces como Vendible aseguran que los objetos que deben ser vendidos implementen solo los métodos necesarios para esa función.
  
  
   
   *5. Principio de Inversión de Dependencias (DIP)*

Capa de Datos: No hay una instancia directa, pero la separación de las interfaces y las implementaciones sugiere que se podría aplicar si las clases de datos dependen de abstracciones en lugar de concretos.

Capa de Negocio: AdministradorVentas depende de la abstracción Inventario y no de una implementación concreta, lo que facilita el mantenimiento y la extensibilidad.

Capa de Presentación: Main ,configura y lanza la interfaz de usuario dependiendo de las abstracciones y no de las clases concretas de las capas de datos o negocio.


PATRONES DE DISEÑO:
==================
*Patrón Creacional : Abstract factory*

Producto y Celular son parte del inventario y pueden beneficiarse de una fábrica abstracta que crea diferentes tipos de productos vendibles.

-Interfaz ProductoFactory: Define el método para crear productos.

- Clases Concretas CelularFactory: Implementa ProductoFactory para crear instancias de Celular.

*Patrón Estructural : Bridge*
AdministradorInventario y AdministradorVentas pueden ser abstraídos de la implementación específica del inventario.

-Interface GestorInventario: Una abstracción para la gestión del inventario.

-Implementación Concreta InventarioCelulares: Implementa GestorInventario manejando el inventario específico de celulares.

*Patrón de comportamiento: State*

Para el sistema de ventas, AdministradorVentas puede tener diferentes estados de venta, como PreparandoVenta, VentaExitosa, y VentaFallida.

-Interface EstadoVenta y clases concretas para cada estado del proceso de ventas.


ARQUITECTURA EN 3 CAPAS:
========================

 *- Capa de acceso a datos: datos*
   
CelularFactory: Fábrica para crear instancias de Celular, posiblemente con diferentes configuraciones o especificaciones.

ProductoFactory: Similar a CelularFactory, pero para otros productos.

GestorInventario: Si interactúa directamente con la base de datos o maneja la persistencia del estado del inventario.

Inventario: Si su función es principalmente mantener el estado de los inventarios, podría ir aquí o en negocio dependiendo de cómo se implemente el acceso a datos.


 *- Capa de negocio: negocio*
   
AdministradorInventario: Gestiona las operaciones del inventario.

AdministradorVentas: Maneja las operaciones de ventas.

Celular: Define la estructura y comportamiento de los objetos Celular.

InventarioCelulares: Específica para operaciones sobre el inventario de celulares.

Producto: Podría representar diferentes tipos de productos gestionados en el sistema, no solo celulares.

EstadoVenta: Enumeración que podría manejar diferentes estados de una venta ( PreparandoVenta, VentaExitosa, VentaFallida).


 *- Capa de presentación: presentacion*
   
SistemaVentaCelulares: Clase principal que puede actuar como controlador en una interfaz de usuario, maneja la interacción entre la UI y la lógica de negocio.
