package problema01;

public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;

    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setReducicarCantidadEnUno() {
        this.cantidad--;
    }

    public void setAumentarCantidadEnUno() {
        this.cantidad++;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
     
    public void setCalculaDescuentoPorVolumen(int cantidad){
        // Si el precio del producto es mayor o igual a $1000, y el número de productos al menos 10, se aplica un descuento del 10%.
        if (this.precio >= 1000 && cantidad >= 10) {
            this.precio = this.precio * 0.9;
        }else{  
            // Si el precio del producto es menor a $1000, se aplica un descuento del 5%, independientemente del número de productos.
            this.precio = this.precio * 0.95;
        }
    }
    @Override
    public String toString() {
        return "Producto: " + this.nombre + " Cantidad: " + this.cantidad + " Precio: " + this.precio;
    }
}
