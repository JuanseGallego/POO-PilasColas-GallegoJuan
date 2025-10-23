package model;

public class Cliente extends Persona{
    
    //Atributos
    private String telefono;

    //Constructor
    public Cliente(String nombre, String documento, String telefono) {
        super(nombre, documento);
        this.telefono = telefono;
    }
    
    //Getter and setter
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Metodo sin retorno de valor para imprimir los datos (Polimorfismo)
    @Override
    public void mostrarDatos(){
        System.out.println("Nombre: " + getNombre() + " | Documento: " + getDocumento() + " | Telefono " + telefono);
    }
    
    //Metodo para modificar el string de la clase Cliente (Polimorfismo)
    @Override
    public String toString(){
        return "Nombre: " + getNombre() + " | Documento: " + getDocumento() + " | Telefono " + telefono;
    }
}
