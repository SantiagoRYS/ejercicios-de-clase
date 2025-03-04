class Acciones {
    private val productos = mutableListOf<Producto>()
    private var contadorId = 1

    // Función privada para generar un ID único
    private fun generarId(): String {
        return "Prod${contadorId++.toString()}"
    }

    // Metodo para crear un producto
    fun crearProducto() {
        println("Ingrese los datos del producto:")

        print("Nombre: ")
        val nombre = readLine() ?: ""

        print("Precio: ")
        val precio = readLine()?.toFloatOrNull() ?: 0f

        print("Cantidad: ")
        val cantidad = readLine()?.toIntOrNull() ?: 0

        val id = generarId()
        val producto = Producto(id, nombre, precio, cantidad)
        productos.add(producto)

        println("Producto agregado: $producto")
    }

    // Metodo para mostrar un producto
    fun mostrarProductos() {
        if (productos.isEmpty()) {
            println("No hay productos en el inventario.")
        } else {
            println("Productos disponibles:")
            productos.forEach { producto ->
                println("ID: ${producto.id}, Nombre: ${producto.nombre}, Precio: ${producto.precio}, Cantidad: ${producto.cantidad}")
            }
        }
    }

    //Metodo para actualizar un producto
    fun actualizarProducto() {
        println("Ingrese el ID del producto a actualizar:")
        val id = readLine() ?: ""

        val producto = productos.find { it.id == id }
        if (producto != null) {
            println("Producto encontrado.")
            println("Ingrese los nuevos datos (deje en blanco para no cambiar):")

            print("Nuevo nombre (dejar vacío para no cambiar): ")
            val nuevoNombre = readLine()?.takeIf { it.isNotBlank() }

            print("Nuevo precio (dejar vacío para no cambiar): ")
            val nuevoPrecio = readLine()?.toFloatOrNull()

            print("Nueva cantidad (dejar vacío para no cambiar): ")
            val nuevaCantidad = readLine()?.toIntOrNull()

            if (nuevoNombre != null) producto.nombre = nuevoNombre
            if (nuevoPrecio != null) producto.precio = nuevoPrecio
            if (nuevaCantidad != null) producto.cantidad = nuevaCantidad

            println("Producto actualizado: $producto")
        } else {
            println("Producto con ID $id no encontrado.")
        }
    }

    // Metodo para eliminar un producto
    fun eliminarProducto() {
        println("Ingrese el ID del producto a eliminar:")
        val id = readLine() ?: ""

        val producto = productos.find { it.id == id }
        if (producto != null) {
            productos.remove(producto)
            println("Producto eliminado: $producto")
        } else {
            println("Producto con ID $id no encontrado.")
        }
    }
}
