/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Facade.Controller;
import java.util.Scanner;

/**
 *
 * @author DacordMachine
 */
public class MenuCliente implements Menu {
  
    @Override
    public void desplegarMenu(Controller control) {
       System.out.println("Menu Cliente \n"+
                          "¿Qué deseas hacer? \n"+
                          "1. Ir a comprar \n" +
                          "2. Editar Perfil \n" +
                          "3. Ver Ordenes \n"+
                          "4. Salir");
       Scanner sc = new Scanner(System.in);
       System.out.print("Digite una opción ->");
       int opcion = sc.nextInt();
       switch(opcion){
           case 1:
               control.comprar();
               break;
           case 2:
               System.out.println(" \n ===PERFIL===  \n NOMBRE: "+control.getUser().getNombre()+" \n CORREO: "+control.getUser().getCorreo());
               System.out.println("\n¿Qué deseas cambiar en el perfil? \n"
                                 + "1. Cambiar contraseña ");
               System.out.print("Digite una opción ->");
               int opcionPerfil=sc.nextInt();
               switch(opcionPerfil){
                   case 1:
                       control.cambiarContraseña();
                       this.desplegarMenu(control);
                   break;
               }
               break;
           case 3:
               break;
           case 4:
               break;
       }
    }

       
}
