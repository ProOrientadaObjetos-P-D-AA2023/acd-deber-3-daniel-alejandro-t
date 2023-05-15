package problema01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import problema01.Producto;

public class main{
    public static void main(String[] args) {
        
        // Creamos el objeto scanner para leer los datos
        Scanner scanner = new Scanner(System.in);
        int entrada = 0;
        List<Producto> productos = new ArrayList<Producto>();

        // Creamos el carrido de compras
        List<Producto> carrito = new ArrayList<Producto>();
        
        // Hacer que el programa se ejecute constantemente hasta que el usuario salga
        do {
            // El usuario ingresa la opción: 
            // 1) Ingresar producto 2) Mostrar productos 3) Hacer compra 4) Salir
            System.out.println("Ingrese la opción: " + "\n" +
                                "1) Ingresar producto" + "\n" +
                                "2) Mostrar productos" + "\n" +
                                "3) Ingresar producto al carrito" + "\n" +
                                "4) Borrar producto del carrito" + "\n" +
                                "5) Realizar compra" + "\n" +
                                "6) Salir");
            
            entrada = scanner.nextInt();
                        
            switch (entrada) {
                case 1:
                    // Pedir los datos del producto
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = scanner.next();
                    scanner.nextLine();  // consume el newline

                    System.out.println("Ingrese la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();  // consume el newline
                    
                    System.out.println("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();

                    // Creamos el objeto producto
                    productos.add( new Producto(nombre, cantidad, precio) );
                    break;
                case 2:
                    mostrarProductos(productos);
                    
                    break;
                case 3: // Ingresar producto al carrito
                    // Requerimiento funcional: 
                    // El programa debe calcular y mostrar el precio final la la compra después de aplicar el descuento.
                    
                    System.out.println("Ingrese el índice del producto que desea comprar: ");
                    int indice = scanner.nextInt();

                    // Obtenemos el producto
                    Producto producto = productos.get(indice);
                    
                    System.out.println("Ingrese la cantidad de productos que desea comprar: ");
                    int cantidadCompra = scanner.nextInt();
                    
                    producto.setCalculaDescuentoPorVolumen(cantidadCompra);
                    
                    // Establecemos a producto la cantidad deseada
                    producto.setCantidad(cantidadCompra);

                    System.out.println("El precio final es: " + producto.getPrecio());

                    break;
                case 4: // Borrar producto del carrito
                    System.out.println("Productos en el carrito: ");
                    mostrarProductos(carrito);
                
                    System.out.println("Ingrese el índice del producto que desea borrar: ");
                    int indiceBorrar = scanner.nextInt();

                    eliminarProductoDelCarrito(productos, carrito, indiceBorrar);
                    break;
                case 5: // Realizar compra
                    // Sumamos todos los items del carrito
                    double total = 0;
                    for (int i = 0; i < carrito.size(); i++) {
                        Producto productoCarrito = carrito.get(i);
                        total += productoCarrito.getPrecio();
                    }

                    System.out.println("El total de la compra es: " + total);

                    // Salimos del programa
                    entrada = 6;

                    break;
                case 6:
                    // Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.err.println("Opción no válida");
                    break;
            }

        
        }while(entrada != 4);  // Si el usuario ingresa 4, el programa se detiene
        
            
    }

    /**
     * Este método muestra todos los productos en la lista proporcionada. 
     * Si la lista está vacía, imprime un mensaje indicando que no hay productos. 
     * Si la lista contiene productos, imprime los índices y la representación de cadena de cada producto.
     *
     * @param productos la lista de productos a mostrar
     */
    public static void mostrarProductos(List<Producto> productos){

        if (productos.size() == 0) {
            System.out.println("No hay productos");
            
        }else{
            // Mostrar los productos recorriendo la lista
            System.out.println("Índice \t Producto");

            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                System.out.println(i + "\t" + producto);
            }
        }
        
    }

    /* Este método muestra todos los productos en el carrito proporcionado. 
    * Si el carrito está vacío, imprime un mensaje indicando que no hay productos en el carrito. 
    * Si el carrito contiene productos, imprime los índices y la representación de cadena de cada producto.
    *
    * @param carrito la lista de productos en el carrito a mostrar
    */
    public static void mostrarProductosDelCarrito(List<Producto> carrito){

        if (carrito.size() == 0) {
            System.out.println("No hay productos en el carrito");
            
        }else{
            // Mostrar los productos recorriendo la lista
            System.out.println("Índice \t Producto");

            for (int i = 0; i < carrito.size(); i++) {
                Producto producto = carrito.get(i);
                System.out.println(i + "\t" + producto);
            }
        }
        
    }

    /**
     * Este método agrega un producto seleccionado desde la lista de productos al carrito. 
     * El producto se selecciona por su índice en la lista de productos.
     *
     * @param productos la lista de productos disponibles
     * @param carrito la lista de productos en el carrito
     * @param indice el índice del producto en la lista de productos que se va a agregar al carrito
     */
    public static void agregarProductoAlCarrito(List<Producto> productos, List<Producto> carrito, int indice){
        Producto producto = productos.get(indice);
        carrito.add(producto);
    }

    /**
     * Este método elimina un producto seleccionado del carrito y lo agrega de vuelta a la lista de productos. 
     * El producto se selecciona por su índice en el carrito.
     *
     * @param productos la lista de productos disponibles
     * @param carrito la lista de productos en el carrito
     * @param indice el índice del producto en el carrito que se va a eliminar y agregar de vuelta a la lista de productos
     */
    public static void eliminarProductoDelCarrito(List<Producto> productos, List<Producto> carrito, int indice){
        Producto producto = carrito.get(indice);
        productos.add(producto);
        carrito.remove(indice);
    }
}