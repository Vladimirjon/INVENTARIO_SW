/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package InventarioDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Johann
 */
public class ConexionBD {
    private static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER2;databaseName=polisalud;encrypt=true;trustServerCertificate=true";


    
    private static final String USER = "proyectoSW";
    private static final String PASSWORD = "password";

    
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    
    
    
}


