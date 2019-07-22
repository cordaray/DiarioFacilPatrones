/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.DAOAdmin;
import DAO.DAOCategorias;
import DAO.DAOClientes;
import Factory.Categoria;
import Factory.Producto;
import Strategy.Admin;
import Strategy.Cliente;
import Strategy.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DacordMachine
 */
public class Controller {

    Scanner sc = new Scanner(System.in);
    DAOClientes daoc = new DAOClientes();
    DAOAdmin daoa = new DAOAdmin();

    //Se encarga del login. Determina si es Cliente o Admin y despliega Menu Correspondiente.
    public Usuario login() {

        System.out.println("Bienvenido a DiarioFacil");
        boolean done = false;

        System.out.println("Inserte correo: ");
        String correo = sc.next();
        System.out.println("Inserte contraseña: ");
        String pwd = sc.next();
        ArrayList<Cliente> clientes = daoc.seleccionar("Clientes", "correo", correo);
        
        //Si no devuelve ningun cliente, revisa tabla de administradores
        if (clientes.isEmpty()) {

            ArrayList<Admin> admins = daoa.seleccionar("Admins", "correo", correo);
            //Si no devuelve Admins tampoco, Usuario no existe
            if (admins.isEmpty()) {
                System.out.println("Usuario no existe");
            } else {
                //Si encuentra un admin, entonces verifica que la contrasena exista
                if (admins.get(0).getContraseña().equals(pwd)) {
                    System.out.println("Login Exitoso! ");
                    System.out.println("Bienvenido, " + admins.get(0).getNombre());
                    admins.get(0).getMenu().desplegarMenu();
                }

            }
        } else {

            //Si encuentra cliente, entonces verifica que la contrasena exista
            if (clientes.get(0).getContraseña().equals(pwd)) {
                System.out.println("Login Exitoso! ");
                System.out.println("Bienvenido, " + clientes.get(0).getNombre());
                clientes.get(0).getMenu().desplegarMenu();
            } else {
                System.out.println("Usuario/Contraseña no coinciden");
            }
        }

        return null;
    }
    
    public void cambiarContraseña(){
       
        //Se le pide el correo
        //Se le pide la nueva contraseña
        //se le pide que repita la nueva contraseña
        //Verifica que la contraseñas calzen
        //Actualiza info
        
    }
    
    public void MostrarProductosPorCategorias(){
        
        DAOCategorias dc = new DAOCategorias();
        ArrayList<Categoria> categorias = dc.seleccionarTodo();
        for(Categoria c : categorias){
            System.out.println("Categoria: "+c.getNombre().toUpperCase());
            ArrayList<Producto> productos = c.producirProductos();
            for(Producto p : productos){
                System.out.println(p.getIdProducto()+". Nombre: "+p.getNombre()+" Precio: "+p.getPrecio()+" colones");
            }
        }
        
    }
    

}
