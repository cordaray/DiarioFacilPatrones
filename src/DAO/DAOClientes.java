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
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
