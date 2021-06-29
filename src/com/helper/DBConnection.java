package com.helper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mutia
 */
public class DBConnection {
    public static String dbURL = "jdbc:sqlserver://KEYZ:1433;databaseName=cuti";
    public static String username = "sa";
    public static String password = "rahasiabanget";
    public Connection conn = null;
    protected int newId = 0;
    
    public boolean connect(){
        boolean res = false;
        try {            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            res = true;            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean disconnect(){
        boolean res = false;
        try {
            conn.close();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
        
    public int getNewId(){
        return this.newId;
    }
    public Connection SQL()
    {
        String user = "sa";
        String pwd  = "rahasiabanget";
        try
        {        	
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:cuti",user,pwd);			
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return conn;
    }	
    public Connection koneks()
    {        
        try
        {			
            String url = "jdbc:sqlserver://KEYZ:1433;databaseName=cuti;user=sa;password=rahasiabanget";			
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url);			
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }	
        return conn;
    }
}
