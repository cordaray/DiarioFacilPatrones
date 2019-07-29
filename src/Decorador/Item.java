/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorador;

/**
 *
 * @author DacordMachine
 */
public class Item {
    
    private int id;
    private String descripcion;
    private  int cantidad;
    private int precio;
    private Item siguiente;

    public Item() {
    }

    
    public Item(int id, String descripcion, int cantidad, int precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Item getSiguiente() {
        return siguiente;
    }
    
    
    public void decorar(Item i){
        if(i.siguiente == null){
            i.siguiente = this;
        } else {
            decorar(i.siguiente);
        }
    }
    
    public void mostrarItem(){
        if(siguiente != null){
           siguiente.mostrarItem();
        }
        System.out.println("ID: "+id+", DESCRIPCION: "+descripcion+", CANTIDAD: "+cantidad+", PRECIO: "+precio);
        System.out.println("Subtotal: "+cantidad*precio);
    }
    
    
}
