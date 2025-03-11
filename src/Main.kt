fun main() {
    val lstProductos = mutableListOf<Producto>()


    do {
        println(
            """
              MENU DE OPCIONES
               1. Crear producto
               2. Vender producto
               3. Reponer stock
               4. Aplicar descuento
               5. Mostrar informacion
               6. Aumentar precio
               7. Calcular valor total en inventario
               8. Eliminar producto por codigo 
               9. Salir
              Seleccione opcion:
          """.trimIndent()
        )

        val opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("Ingrese codigo del producto:")
                val codigoProducto = readln()
                println("Ingrese nombre del producto:")
                val nombreProducto = readln()
                println("Ingrese cantidad en stock del producto:")
                val cantidadStock = readln().toInt()
                println("Ingrese precio del producto:")
                val precioProducto = readln().toDouble()
                lstProductos.add(Producto(codigoProducto, nombreProducto, cantidadStock, precioProducto))
                println("Producto registrado")
            }
            2 -> {
                println("Ingrese el codigo del producto:")
                val codigoProducto = readln()
                val producto = lstProductos.find { producto -> producto.codigoProducto == codigoProducto }


                if (producto != null) {
                    print("Cantida a vender: ")
                    val cantidadVender = readln().toInt()
                    if (producto.venderProducto(cantidadVender)) {
                        println("Producto vendido: ${producto.nombreProducto} (${cantidadVender})");
                    }
                } else {
                    println("Producto no encontrado.")
                }
            }
            3 -> {
                println("Ingrese el codigo del producto:")
                val codigoProducto = readln()
                val producto = lstProductos.find { producto -> producto.codigoProducto == codigoProducto }


                if (producto != null) {
                    print("Cantidad a reponer: ")
                    val cantidadAReponer = readln().toInt()
                    producto.reponerStock(cantidadAReponer)
                    println("Stock repuesto exitosamente para el producto ${producto.nombreProducto}.")
                } else {
                    println("Producto no encontrado.")
                }
            }
            4 -> {
                println("Ingrese el codigo del producto:")
                val codigoProducto = readln()
                val producto = lstProductos.find { producto -> producto.codigoProducto == codigoProducto }


                if (producto != null) {
                    producto.aplicarDescuento(2.0)
                    println("Descuento aplicadoal producto ${producto.nombreProducto}.")
                } else {
                    println("Producto no encontrado.")
                }
            }
            5 -> {
                println("Ingrese el codigo del producto:")
                val codigoProducto = readln()
                val producto = lstProductos.find { producto -> producto.codigoProducto == codigoProducto }


                if (producto != null) {
                    println("Información del Producto ")
                    producto.mostrarInformacion()
                } else {
                    println("Producto no encontrado.")
                }
            }
            6 ->{
                println("Ingrese el codigo del producto:")
                val codigoProducto = readln()
                val producto = lstProductos.find { producto -> producto.codigoProducto == codigoProducto }


                if (producto != null) {
                    producto.aumentarPrecio(6.0)
                    println("Precio aumentado para el producto ${producto.nombreProducto}.")
                } else {
                    println("Producto no encontrado.")
                }
            }
            7 ->{
                var valorTotalInventario = 0.0
                for (producto in lstProductos) {
                    valorTotalInventario += producto.calcularValorTotalInventario()
                }
                println("Valor total en inventario: $valorTotalInventario")
            }
            8 -> {
                println("Ingrese el codigo del producto:")
                val codigoProducto = readln()
                val producto = lstProductos.find { producto -> producto.codigoProducto == codigoProducto }


                if (lstProductos.removeIf { producto -> producto.codigoProducto == codigoProducto }){
                    println("Producto eliminado.")
                } else {
                    println("Producto no encontrado.")
                }
            }
            9 -> println("Saliendo del programa...")

            else -> println("Opción no válida, intente de nuevo.")
        }

    } while (opcion != 9)
}