import Acciones
fun main() {
    val gestor = Acciones()
    var opcion: Int

    do {
        // Menú de opciones
        println("-----------------------------------------------")
        println("--- Menú de opciones ---")
        println("1. Crear producto")
        println("2. Mostrar productos")
        println("3. Actualizar producto")
        println("4. Eliminar producto")
        println("5. Salir")
        println("Seleccione una opción (1-5): ")

        opcion = readLine()?.toIntOrNull() ?: 0

        println("-----------------------------------------------")

        when (opcion) {
            1 -> gestor.crearProducto() // Crear producto
            2 -> gestor.mostrarProductos() // Mostrar productos
            3 -> gestor.actualizarProducto() // Actualizar producto
            4 -> gestor.eliminarProducto() // Eliminar producto
            5 -> println("¡Hasta luego!") // Salir
            else -> println("Opción no válida. Intente nuevamente.") // Opción no válida
        }
    } while (opcion != 5)
}


