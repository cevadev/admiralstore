/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.admiral.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Test
 */
public class CConection {
    private static Logger logger = LoggerFactory.getLogger(CConection.class);
    private static final String URL = "jdbc:mysql://localhost:3306/admiralecommerce";
    public static Connection connection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //return DriverManager.getConnection(URL, "root", "root");
        } catch (ClassNotFoundException ex) {
            logger.error("No se encontro la clase com.mysql.cj.jdbc.Driver");
        } 
        Connection conn = DriverManager.getConnection(URL, "root", "root");
        return conn;
    }
}
