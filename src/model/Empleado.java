package model;

public class Empleado extends Persona{
    
    //Atributos
    private String cargo;
    
    //Constructor
    public Empleado(String nombre, String documento, String cargo) {
        super(nombre, documento);
        this.cargo = cargo;
    }
    
    //Getter and setter
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    //Metodo sin retorno de valor para mostrar los datos (Polimorfismo)
    @Override
    public void mostrarDatos(){
        System.out.println("Nombre: " + getNombre() + " | Documento: " + getDocumento() + " | Cargo dentro de la empresa: " + cargo);
    }
}
