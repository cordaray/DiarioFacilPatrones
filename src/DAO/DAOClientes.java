/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Strategy.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DacordMachine
 */
public class DAOClientes extends DAOGeneral implements DAO {
    
    /**
     * descripcion
     * @param from descripcion 1
     * @param where descripcion 2
     * @param equals descripcion 3
     * @return resultado
     */
    public ArrayList<Cliente> seleccionar(String from, String where, String equals) {

        ArrayList<Cliente> clientes = new ArrayList();
        this.conectar();
        try {
            stmt = conn.prepareStatement("select * from " + from + " where " + where + " = '" + equals + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString(4), rs.getString(2), rs.getString(3)));

            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return clientes;
    }
    
    @Override
    public void actualizar(String query) {
        //Se debe escribir el update entero, abajo le dejo el formato de un update
        //UPDATE Clientes set nombre = "David Cordero 2" where idCliente = 1;
        this.conectar();
        try {
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        } catch (SQLException e){
            e.getMessage();
        }
        
    }

    @Override
    public void borrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param values ejemplo: "'dacord97','1234','David Cordero'"
     */
    @Override
    public void agregar(String values) {
        
        this.conectar();
        
        try{
            
            stmt = conn.prepareStatement("insert into Clientes (correo,pwd,nombre) values ("+values+")");
            stmt.executeUpdate();
            System.out.print("Registro agregado exitosamente!");
            
        } catch (SQLException e){
            e.getMessage();
        }
       
    }
    
    

}
