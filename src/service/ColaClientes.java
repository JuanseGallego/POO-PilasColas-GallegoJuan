package service;

import model.OrdenServicio;
import java.util.*;
import model.Cliente;
import model.Operacion;

public class ColaClientes {
    
    //Definir el id de la orden y el numero de cliente de manera secuencial
    static int id = 0;
    static int numeroCliente = 0;
    
    //Metodo para agregar clientes a la cola
    public static void encolarCliente( Deque<Cliente> colaClientes, Scanner sc ){
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine().trim();
        
        if( nombre.isEmpty() || nombre.length()<2 ){
            System.out.println("CUIDADO - El nombre debe tener minimo 2 caracteres");
            return;
        }
        
        System.out.print("Ingrese el numero de documento del cliente: ");
        String documento = sc.nextLine();
        
        if( documento.isEmpty() ){
            System.out.println("CUIDADO - El documento no puede estar vacio");
            return;
        }
        
        System.out.print("Ingrese el telefono del cliente: ");
        String telefono = sc.nextLine().trim();
        
        if( telefono.isEmpty() ){
            System.out.println("CUIDADO - El telefono del cliente no puede estar vacio");
            return;
        }
        
        //Crear el cliente y agregar a la cola
        Cliente cliente = new Cliente(nombre, documento, telefono);
        colaClientes.add( cliente );
        
        System.out.println("\nEl cliente se ha agregado correctamente a la cola");
    }
    
    //Metodo para ver el siguiente cliente en la cola
    public static void siguienteCliente( Deque<Cliente> colaClientes ){
        //Validar si la cola esta vacia o sino realizar la operacion de ver el siguiente cliente en la cola
        if( colaClientes.isEmpty() ){
            System.out.println("No hay ningun cliente en espera, la cola esta vacia");
        }else{
            System.out.println("El siguiente cliente en la cola de espera es: ");
            colaClientes.peek().mostrarDatos();
        }
    }
    
    //Metodo para atender el cliente
    public static void atenderCliente( Deque<Cliente> colaClientes, Stack<Operacion> historialOperaciones, Scanner sc ){
        //Validar si la cola esta vacia o sino realizar la operacion de desencolar
        if( colaClientes.isEmpty() ){
            System.out.println("No hay ningun cliente en espera, la cola esta vacia");
        }else{
            numeroCliente += 1; //Sumar de manera secuencial al contador que sirve como contador de clientes en la cola
            
            //Solicitar la descripcion del problema con el que cuenta
            System.out.println("Se ha atendido al cliente #" + numeroCliente);
            System.out.print("Ingrese la descripcion del problema que presenta el cliente: ");
            String descripcionProblema = sc.nextLine();
            
            if( descripcionProblema.isEmpty() ){
                System.out.println("CUIDADO - La descripcion del problema no puede estar vacia");
                numeroCliente -= 1;
                return;
            }
            
            //Atender cliente
            Cliente cliente = colaClientes.poll();
            
            //Definir el estado, el ID y la fecha para crear la orden
            id += 1;                            //Sumar de manera secuencial al contador que sirve como id de orden creada
            String estado = "ABIERTA";
            Date fechaCreacion = new Date();
            
            //Crear orden de servicio
            OrdenServicio ordenServicio = new OrdenServicio(id, cliente, descripcionProblema, estado, fechaCreacion);
            System.out.println("\nSe ha atendido al cliente #" + numeroCliente + " y se ha creado la siguiente orden de servicio: ");
            ordenServicio.mostrarDatos();
            
            //Establecer los datos afectados
            String datosAfectados = "Atencion a cliente con documento " + cliente.getDocumento() + " y se crea orden de servicio #" + id;
            
            //Registrar la operacion
            Operacion operacion = new Operacion(estado, datosAfectados, ordenServicio);
            //Agregar la operacion al historial
            HistorialOperaciones.registrarOperacion(historialOperaciones, operacion);
            
        }
    }
    
    //Metodo para mostrar el tamaño de la cola
    public static void tamañoCola( Deque<Cliente> colaClientes ){
        //Verificar si el tamaño de la cola es 0 para mostrar un mensaje en especifico o simplemente mostrar el tamaño
        if( colaClientes.isEmpty() ){
            System.out.println("La cola se encuentra vacia, el tamaño es 0");
        }else{
            System.out.println("Hay " + colaClientes.size() + " clientes en la cola");
        }
    }
    
    //Metodo para listar todos los clientes que se encuentran en al cola
    public static void listarCola( Deque<Cliente> colaClientes ){
        if( colaClientes.isEmpty() ){
            System.out.println("La cola se encuentra vacia");
        }else{
            System.out.println("Listado de la Cola de Clientes");
            System.out.printf("%-40s | %-15s | %-15s", "Nombre", "Documento", "Telefono");
            System.out.println("\n--------------------------------------------------------------------");
            for( Cliente cliente : colaClientes ){
                System.out.printf("%-40s | %-15s | %-15s \n", cliente.getNombre(), cliente.getDocumento(), cliente.getTelefono());
            }
        }
    }
    
}
