/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

/**
 *
 * @author DacordMachine
 */
public class Cliente extends Usuario {
    
    public Cliente(String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña, new MenuCliente());
    }
    
    

    
    
    
    
}
