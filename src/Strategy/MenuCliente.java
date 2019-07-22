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
    public void desplegarMenu() {
       System.out.println("Menu Cliente \n"+
                          "¿Qué deseas hacer? \n"+
                          "1. Ir a comprar \n" +
                          "2. Editar Perfil \n" +
                          "3. Ver Ordenes \n"+
                          "4. Salir");
       Scanner sc = new Scanner(System.in);
       System.out.print("Digite una opción ->");
       int opcion = sc.nextInt();
       if (opcion == 1){
           Controller control = new Controller();
           control.MostrarProductosPorCategorias();
       }
    }
       
}
