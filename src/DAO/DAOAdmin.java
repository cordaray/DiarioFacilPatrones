/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Strategy.Admin;
import Strategy.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DacordMachine
 */
public class DAOAdmin extends DAOGeneral implements DAO {
    
    public ArrayList <Admin> seleccionar(String from, String where, String equals){
        
           
        ArrayList<Admin> admins = new ArrayList(); 
        this.conectar();
        try {
            stmt = conn.prepareStatement("select * from "+from+" where "+where+" = '"+equals+"'");
            rs = stmt.executeQuery();
            while(rs.next()){
                 admins.add(new Admin(rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException e){
            e.getMessage();
        }
        return admins;
        
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(String values) {
        
        this.conectar();

        try {

            stmt = conn.prepareStatement("insert into Admins (correo,pwd,nombre) values (" + values + ")");
            stmt.executeUpdate();
            System.out.print("Registro agregado exitosamente!");

        } catch (SQLException e) {
            e.getMessage();
        }
       
    }
    
    
    
}
