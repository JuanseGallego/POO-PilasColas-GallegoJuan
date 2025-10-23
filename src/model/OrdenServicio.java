package model;

import java.util.Date;
import model.Cliente;

public class OrdenServicio{
    //Atributos
    private int id;
    private Cliente cliente;
    private String descripcionProblema;
    private String estado;
    private Date fechaCreacion;
    
    //Constructor
    public OrdenServicio(int id, Cliente cliente, String descripcionProblema, String estado, Date fechaCreacion) {
        this.id = id;
        this.cliente = cliente;
        this.descripcionProblema = descripcionProblema;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }
    
    //Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    //Metodo sin retorno de valor para imprimir los datos
    public void mostrarDatos(){
        System.out.println("---------------------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Cliente: " + cliente.toString());
        System.out.println("Descripcion problema: " + descripcionProblema);
        System.out.println("Estado: " + estado);
        System.out.println("Fecha creacion: " + fechaCreacion);
        System.out.println("---------------------------------------------------");
    }
}
