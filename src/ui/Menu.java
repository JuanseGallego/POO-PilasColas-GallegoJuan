package ui;

import java.util.*;
import model.Cliente;
import model.Operacion;
import service.*;

public class Menu {
    
    //Script que muestra y ejecuta el menu
    public static void menu( Deque<Cliente> colaClientes, Stack<Operacion> historialOperaciones, Scanner sc){
        
        System.out.println("-- GESTOR DE ATENCION Y ORDENES --");
        
        while(true){
            System.out.println("\n-- Menu --");
            System.out.println("1. Agregar cliente a la cola");
            System.out.println("2. Ver siguiente cliente en la cola");
            System.out.println("3. Atender cliente (Crear orden)");
            System.out.println("4. Ver tamaño de la cola");
            System.out.println("5. Listar la cola de espera");
            System.out.println("6. Deshacer ultima operacion realizada");
            System.out.println("7. Ver tope del historial de operaciones");
            System.out.println("8. Ver tamaño del historial de operaciones");
            System.out.println("9. Listar el historial de operaciones");
            System.out.println("10. Buscar orden de servicio");
            System.out.println("0. Salir");
            
            System.out.print("\nSeleccione una opcion: ");
            String op = sc.nextLine().trim();
            System.out.println("");
            
            switch( op ){
                case "1":
                    ColaClientes.encolarCliente(colaClientes, sc);
                    break;
                
                case "2":
                    ColaClientes.siguienteCliente(colaClientes);
                    break;
                    
                case "3":
                    ColaClientes.atenderCliente(colaClientes, historialOperaciones, sc);
                    break;
                    
                case "4":
                    ColaClientes.tamañoCola(colaClientes);
                    break;
                    
                case "5":
                    ColaClientes.listarCola(colaClientes);
                    break;
                    
                case "6":
                    HistorialOperaciones.deshacerOperacion(historialOperaciones, colaClientes, sc);
                    break;
                    
                case "7":
                    HistorialOperaciones.topeHistorial(historialOperaciones);
                    break;
                    
                case "8":
                    HistorialOperaciones.tamañoHistorial(historialOperaciones);
                    break;
                    
                case "9":
                    HistorialOperaciones.listarHistorial(historialOperaciones);
                    break;
                    
                case "10":
                    HistorialOperaciones.buscarOrdenServicio(historialOperaciones, sc);
                    break;
                    
                case "0":
                    sc.close();
                    return;
                    
                default:
                    System.out.println("ERROR - Ingrese una opcion valida");
                                    }
        }
        
    }
    
}
