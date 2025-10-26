package model;

public class Operacion {
    //Atributos
    private String tipoOperacion;
    private String datosAfectados;
    private OrdenServicio ordenServicio;
    
    //Constructor
    public Operacion(String tipoOperacion, String datosAfectados, OrdenServicio ordenServicio) {
        this.tipoOperacion = tipoOperacion;
        this.datosAfectados = datosAfectados;
        this.ordenServicio = ordenServicio;
    }
    
    //Getter and setter
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getDatosAfectados() {
        return datosAfectados;
    }

    public void setDatosAfectados(String datosAfectados) {
        this.datosAfectados = datosAfectados;
    }

    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }
    
    //Crear un getCliente
    public Cliente getClienteOrden(){
        return ordenServicio.getCliente();
    }
    
    //Metodo sin retorno de valor para mostrar los datos
    public void mostrarDatos(){
        ordenServicio.mostrarDatos();
    }
    
    //Modificar el toString con polimorfismo
    @Override
    public String toString(){
        return "Tipo de operacion: " + tipoOperacion + " | Datos afectados: " + datosAfectados;
    }
}
