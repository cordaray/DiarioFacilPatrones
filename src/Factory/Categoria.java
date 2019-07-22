/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DAO.DAOProductos;
import java.util.ArrayList;

/**
 *
 * @author DacordMachine
 */
public class Categoria implements CategoriaFactory {
    
    private String nombre;
    public DAOProductos dp;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.dp = new DAOProductos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public ArrayList<Producto> producirProductos() {
        
        ArrayList<Producto> resultado = dp.seleccionar("Productos", "Categoria", nombre);
        
        return resultado;
        
    }
    
    
}
