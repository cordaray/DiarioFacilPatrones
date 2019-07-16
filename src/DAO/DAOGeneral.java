/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DacordMachine
 */
public abstract class DAOGeneral {
    
    public String URL="jdbc:mysql://localhost/diariofacil";
    public String USER="root";
    public String PWD="1234";
    public Connection conn;
    public ResultSet rs;
    public PreparedStatement stmt;

    public void conectar(){
        
        try {
            conn = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Conexión exitosa!");
        } catch (SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
        
    }
    
    public void desconectar(){
        
        try {
            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    
    
    
}
