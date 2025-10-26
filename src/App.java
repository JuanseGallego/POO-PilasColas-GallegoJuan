/*  
PROYECTO: Gestor de Atención y Órdenes — POO con Pilas y Colas
AUTOR: Juan Sebastian Gallego Villamil | 2220241017
*/

import java.util.*;
import model.Cliente;
import model.Operacion;
import ui.Menu;

public class App {
    //Crear la cola con Deque debido a que se necesita una cola con doble terminación
    private static Deque<Cliente> colaClientes = new LinkedList<>();
    
    //Crear pila que contiene el historial de operaciones
    private static Stack<Operacion> historialOperaciones = new Stack<>();
    
    //Crear el scanner
    private static Scanner sc = new Scanner(System.in);
    
    //Script que ejecuta la aplicacion
    public static void main(String[] args) {
        //Ejecutar el menu
        Menu.menu(colaClientes, historialOperaciones, sc);
        
    }
          
}
