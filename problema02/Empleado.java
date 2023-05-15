package problema02;

public class Empleado {
    String nombre;
    String apellido;
    int edad;
    double salario;
    
    public Empleado(String nombre, String apellido, int edad, double salario){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado: " + this.nombre + " " + this.apellido + " Edad: " + this.edad + " Salario: " + this.salario;
    }

    // Calcula aumento de salario en base a porcentaje
    public void setAumentarSalario(double porcentaje){
        this.salario = this.salario * (1 + porcentaje);
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    public double getSalario(){
        return this.salario;
    }

}
