class Producto (

    val codigoProducto: String,
    val nombreProducto: String,
    var cantidadStock: Int,
    var precioProducto: Double
) {
    fun crearProducto (codigoProducto: String, nombreProducto: String, cantidadStock: Int,precioProducto: Double) {
        this.precioProducto = precioProducto
        this.cantidadStock = cantidadStock
    }
    fun venderProducto(cantidad: Int): Boolean {
        return if (cantidadStock >= cantidad) {
            cantidadStock -= cantidad
            true
        } else {
            println("No hay suficiente stock para vender.")
            false
        }
    }
    fun reponerStock(cantidad: Int) {
        cantidadStock += cantidad
    }

    fun aplicarDescuento(porcentaje: Double) {
        precioProducto -= precioProducto * (porcentaje / 100)
    }

    fun mostrarInformacion(): String {
        return "Producto (codigo = '$codigoProducto', nombre = '$nombreProducto', cantidad = '$cantidadStock', precio = '$precioProducto')"
    }

    fun aumentarPrecio(porcentaje: Double) {
        precioProducto += precioProducto * (porcentaje / 100)
    }
    fun calcularValorTotalInventario(): Double {
        return cantidadStock * precioProducto
    }
}
