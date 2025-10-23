package model;

public abstract class Persona {
    
    //Atributos
    private String nombre;
    private String documento;
    
    //Constructor
    public Persona(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }
    
    //Getter and setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    //Metodo sin retorno de valor para mostrar datos
    public void mostrarDatos(){
        System.out.println("Se imprimen los datos de cada una de las clases");
    }
    
}
