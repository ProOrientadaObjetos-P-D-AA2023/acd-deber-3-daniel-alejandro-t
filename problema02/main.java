package problema02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import problema02.Empleado;

public class main {
    public static void main(String args[]){
        // Creamos el objeto scanner para leer los datos
        Scanner scanner = new Scanner(System.in);
        int entrada = 0;

        List<Empleado> empleados = new ArrayList<Empleado>();

        do {
            // Mostramos el menú
            System.out.println("Ingrese la opción: " + "\n" +
                                "1) Ingresar empleado" + "\n" +
                                "2) Mostrar empleados" + "\n" +
                                "3) Aumentar salario" + "\n" +
                                "4) Salir");

            entrada = scanner.nextInt();

            switch (entrada) {
                case 1:
                    // Pedir los datos del empleado
                    System.out.println("Ingrese el nombre del empleado: ");
                    String nombre = scanner.next();
                    scanner.nextLine();  // consume el newline

                    System.out.println("Ingrese el apellido del empleado: ");
                    String apellido = scanner.next();
                    scanner.nextLine();  // consume el newline

                    System.out.println("Ingrese la edad del empleado: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();  // consume el newline

                    System.out.println("Ingrese el salario del empleado: ");
                    double salario = scanner.nextDouble();

                    // Creamos el objeto empleado
                    empleados.add( new Empleado(nombre, apellido, edad, salario) );
                    break;
                case 2:
                    mostrarEmpleados(empleados);
                    break;
                case 3:

                    // Pedir el índice del empleado
                    System.out.println("Ingrese el índice del empleado: ");
                    mostrarEmpleados(empleados);

                    int indice = scanner.nextInt();
                    scanner.nextLine();  // consume el newline

                    // Pedir el porcentaje de aumento
                    System.out.println("Ingrese el porcentaje de aumento: ");
                    double porcentaje = scanner.nextDouble();
                    scanner.nextLine();  // consume el newline

                    // Aumentamos el salario del empleado
                    empleados.get(indice).setAumentarSalario(porcentaje);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.err.println("Opción no válida");
                    break;
            }

        } while (entrada != 4);
    }

    // Método que recorre la lista de empleados y muestra sus datos con su índice
    public static void mostrarEmpleados(List<Empleado> empleados){
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println(i + ") " + empleados.get(i).toString());
        }
    }
}
