package service;

import model.Operacion;
import model.Cliente;
import java.util.*;

public class HistorialOperaciones {
    
    //Metodo para registrar cada operación
    public static void registrarOperacion( Stack<Operacion> historialOperaciones, Operacion operacion ){
        historialOperaciones.push(operacion);
        System.out.println("Se ha agregado correctamente la operación al historial");
    }
    
    //Metodo para deshacer la ultima operacion importando la cola de clientes ya existente
    public static void deshacerOperacion( Stack<Operacion> historialOperaciones, Deque<Cliente> colaClientes, Scanner sc ){
        //Validar que el historial no este vacio para poder deshacer la ultima operacion
        if( historialOperaciones.isEmpty() ){
            System.out.println("No hay ninguna operacion registrada, el historial esta vacio");
        }else{
            System.out.println("¿Esta seguro de deshacer la ultima operacion del historial?");
            System.out.println("Si/No");
            String confirmacionDeshacer = sc.nextLine().toLowerCase().trim();
            
            if( confirmacionDeshacer.isEmpty() ){
                System.out.println("ERROR - Debe escoger una de las dos opciones");
                return;
            }
            
            if( confirmacionDeshacer.equals("si") ){
                //Eliminar la ultima operacion de la pila
                Cliente cliente = historialOperaciones.peek().getClienteOrden();    //Extraer el cliente de la ultima operacion
                Operacion ultimaOperacion = historialOperaciones.pop();             //Eliminar la ultima operacion de la pila
                colaClientes.addFirst(cliente);                                     //Agregar nuevamente el cliente a la cola
                
                System.out.println("\nEl siguiente cliente se ha retornado al frente de la cola de espera: ");
                cliente.mostrarDatos();
            }else{
                System.out.println("La operacion se ha cancelado, el historial no sera modificado");
            }
        }
    }
    
    //Metodo para ver la operacion que se encuentra en el tope del historial
    public static void topeHistorial( Stack<Operacion> historialOperaciones ){
        if( historialOperaciones.isEmpty() ){
            System.out.println("No hay ninguna operacion registrada, el historial esta vacio");
        }else{
            System.out.println("Operacion mas Reciente\n" + historialOperaciones.peek().toString());
            System.out.println("\n- Orden Servicio -");
            historialOperaciones.peek().mostrarDatos();
        }
    }
    
    //Metodo para ver el tamaño del historial
    public static void tamañoHistorial( Stack<Operacion> historialOperaciones ){
        if( historialOperaciones.isEmpty() ){
            System.out.println("El historial esta vacio, el tamaño es 0");
        }else{
            System.out.println("El tamaño del historial es: " + historialOperaciones.size());
        }
    }
    
    //Metodo para listar las operaciones de la mas reciente a la mas antigua
    public static void listarHistorial( Stack<Operacion> historialOperaciones ){
        if( historialOperaciones.isEmpty() ){
            System.out.println("No hay ninguna operacion registrada, el historial esta vacio");
        }else{
            System.out.println("Historial de Operaciones");
            System.out.printf("%-25s | %-40s", "Tipo de Operacion", "Datos Afectados");
            System.out.println("\n----------------------------------------------------------------------------------------------------------");
            for( int i = (historialOperaciones.size()-1); i>=0; i-- ){
                System.out.printf("%-25s | %-40s \n", historialOperaciones.get(i).getTipoOperacion(), historialOperaciones.get(i).getDatosAfectados());
            }
        }
    }
    
    //Metodo sin retorno de valor para buscar una orden de servicio segun el id
    public static void buscarOrdenServicio( Stack<Operacion> historialOperaciones, Scanner sc ){
        //Solicitar una el id que desea buscar
        System.out.print("Ingrese el ID de la orden de servicio que desea buscar: ");
        String id = sc.nextLine().trim().toLowerCase();
        
        //Validar que el id no este vacio
        if( id.isEmpty() ){
            System.out.println("ERROR - El ID no puede estar vacio");
            return;
        }
        
        boolean encontrado = false;
        
        //Recorrer todo el historial de operaciones y buscar el ID de la orden de servicio que necesita el usuario e imprimir los datos
        for( Operacion operacion : historialOperaciones ){
            if( Integer.parseInt(id) == operacion.getOrdenServicio().getId() ){
                System.out.println("");
                operacion.getOrdenServicio().mostrarDatos();
                encontrado = true;
                return;
            }
        }
        
        if( encontrado == false ){
            System.out.println("\nEl ID no ha sido encontrado dentro del historial de operaciones");
        }
        
    }
}
