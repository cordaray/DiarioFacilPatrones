
import DAO.DAOCategorias;
import DAO.DAOClientes;
import DAO.DAOProductos;
import Decorador.Item;
import Facade.Controller;
import Factory.Categoria;
import Factory.Producto;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DacordMachine
 */
public class Tester {
    
    public static void main(String args[]){
        
        
        Scanner sc =  new Scanner(System.in);
        DAOClientes dc = new DAOClientes();
        Controller control = new Controller();
       
        DAOProductos dp = new DAOProductos();
        DAOCategorias dca = new DAOCategorias();
        ArrayList<Categoria>  c = dca.seleccionarTodo();
        
        System.out.print("Bienvenido a Diariofacil  \n"+
                           "1. Iniciar sesión  \n"+
                           "2. Registrarse  \n"+
                           "3. Salir  \n"+
                           "Digite una opción ->");
        
        int opcion = sc.nextInt();
        
        switch(opcion){
            case 1:
                control.login();
                break;
            case 2:
                control.registrar();
                break;
        }
        
        
    }
    
}
