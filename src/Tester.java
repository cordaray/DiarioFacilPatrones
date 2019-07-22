
import DAO.DAOCategorias;
import DAO.DAOClientes;
import DAO.DAOProductos;
import Facade.Controller;
import Factory.Categoria;
import Factory.Producto;
import java.util.ArrayList;

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
        
        DAOClientes dc = new DAOClientes();
        Controller control = new Controller();
        DAOProductos dp = new DAOProductos();
        DAOCategorias dca = new DAOCategorias();
        ArrayList<Categoria>  c = dca.seleccionarTodo();
        
        control.login();
        
    }
    
}
