/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.DAOAdmin;
import DAO.DAOCategorias;
import DAO.DAOClientes;
import Decorador.Carrito;
import Decorador.Item;
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
    Usuario user;
    Carrito carrito = new Carrito();
    ArrayList<Producto> productos = new ArrayList();
    Item inicio;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    
    
    public Controller(Usuario user) {
        this.user = user;
    }

    public Controller() {
    }
    

    //Se encarga del login. Determina si es Cliente o Admin y despliega Menu Correspondiente.
    public Usuario login() {

        System.out.println("LOGIN");

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
                this.login();
            } else {
                //Si encuentra un admin, entonces verifica que la contrasena exista
                if (admins.get(0).getContraseña().equals(pwd)) {
                    System.out.println("Login Exitoso! ");
                    System.out.println("Bienvenido, " + admins.get(0).getNombre());
                    user = admins.get(0);
                    user.getMenu().desplegarMenu(this);
                }

            }
        } else {

            //Si encuentra cliente, entonces verifica que la contrasena exista
            if (clientes.get(0).getContraseña().equals(pwd)) {
                System.out.println("Login Exitoso! ");
                System.out.println("Bienvenido, " + clientes.get(0).getNombre());
                user = clientes.get(0);
                user.getMenu().desplegarMenu(this);
            } else {
                System.out.println("Usuario/Contraseña no coinciden");
                this.login();
            }
        }

        return null;
    }
    
    public void cambiarContraseña(){
       
        //Se le pide la nueva contraseña
        System.out.println("Digite la nueva contraseña: ");
        String contraseña = sc.next();
        //se le pide que repita la nueva contraseña
        System.out.println("Confirme la nueva contraseña: ");
        String contraseñaConfirmada = sc.next();
        //Verifica que la contraseñas calzen
        if(contraseña.equals(contraseñaConfirmada)){
            
        daoc.actualizar("UPDATE Clientes set pwd = '"+contraseña+"' where correo = '"+this.user.getCorreo()+"'");
            
        } else {
            System.out.println("Las contraseñas no coinciden");
        }
        //Actualiza info
        
    }
    
    public void registrar() {

        try {

            System.out.println("Digite correo: ");
            String correo = sc.next();
            System.out.println("Digite contraseña: ");
            String contraseña = sc.next();
            System.out.println("Digite su nombre: ");
            String nombre = sc.next();
            System.out.println("Digite su apellido: ");
            nombre = nombre + " " + sc.next();

            ArrayList<Cliente> clientes = daoc.seleccionar("Clientes", "correo", correo);
            if (clientes.isEmpty()) {
                daoc.agregar("'" + correo + "', " + "'" + contraseña + "', " + "'" + nombre + "'");
                clientes = daoc.seleccionar("Clientes", "correo", correo);
                clientes.get(0).getMenu().desplegarMenu(this);
            } else {
                System.out.println("Este correo ya está en uso");
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }
    
    public void MostrarProductosPorCategorias(){
        
        DAOCategorias dc = new DAOCategorias();
        ArrayList<Categoria> categorias = dc.seleccionarTodo();
        for(Categoria c : categorias){
            System.out.println("Categoria: "+c.getNombre().toUpperCase());
            ArrayList<Producto> productosMostrar = c.producirProductos();
            for(Producto p : productosMostrar){
                System.out.println(p.getIdProducto()+". Nombre: "+p.getNombre()+" Precio: "+p.getPrecio()+" colones");
                productos.add(p);
            }
        }
        
    }
  
    public void comprar(){
        
        boolean listo = false;
        this.MostrarProductosPorCategorias();
        do {
        System.out.println("¿Cuál Producto deseas llevar? Digita el ID");
        int id = sc.nextInt();
        System.out.println("¿Cuántos deseas llevar?");
        int cantidad = sc.nextInt();
        if(inicio == null){
            inicio = crearItem(id,cantidad);
        } else {
            
           Item nuevo = crearItem(id,cantidad);
           nuevo.decorar(inicio);
           
        }
        System.out.print("==ESTADO CARRITO (BETA IN PROGRESS)== \n");
        inicio.mostrarItem();
        } while(listo == false);
    }
    
    public Item crearItem(int id, int cantidad){
        
        //Item(int id, String descripcion, int cantidad, int precio)
        Item nuevo = new Item();
        
        for(Producto p : productos){
            if(p.getIdProducto()==id){
                nuevo = new Item(p.getIdProducto(),p.getNombre(),cantidad,p.getPrecio());
            }
        }
        
        return nuevo;
        
    }

}
