
import DAO.DAOClientes;
import Facade.Controller;

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
        control.login();
        
    }
    
}
