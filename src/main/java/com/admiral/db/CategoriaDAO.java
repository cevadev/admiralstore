/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.admiral.db;

import com.admiral.javabeans.Category;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Test
 */
public class CategoriaDAO {
    public static ArrayList<Category> listar(){
        try{
            String sql = "{CALL sp_listarCategoriaSuperior()}";
            Connection scc = CConection.connection();
            CallableStatement statement = scc.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            ArrayList<Category> result = new ArrayList<>();
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("name"));
                result.add(category);
            }
            return result;
        }
        catch(SQLException e){
            System.out.println(e.getClass().getName() + " generated: " + e.getMessage());
        }
        return null;
    }
}
