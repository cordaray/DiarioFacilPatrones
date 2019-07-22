/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.util.ArrayList;

/**
 *
 * @author DacordMachine
 */
public interface CategoriaFactory {
    
    public ArrayList<Producto> producirProductos();
    
}
