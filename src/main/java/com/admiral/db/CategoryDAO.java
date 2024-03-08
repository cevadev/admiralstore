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
public class CategoryDAO {

  public ArrayList<Category> list() {
    String sql = "{CALL sp_listarCategoriaSuperior()}";
     ArrayList<Category> categories = new ArrayList<>();
    try (Connection scc = CConection.connection(); CallableStatement statement = scc.prepareCall(sql)) {
      try (ResultSet rs = statement.executeQuery()) {
        while (rs.next()) {
          Category category = new Category();
          category.setId(rs.getInt("category_id"));
          category.setName(rs.getString("name"));
          categories.add(category);
        }
      }
      return categories;
    } catch (SQLException e) {
      System.out.println(e.getClass().getName() + " generated: " + e.getMessage());
    }
    return null;
  }

  public ArrayList<Category> listarSubCategorias(int categorySuper) {
    String sql = "{CALL sp_listarSubCategorias(?)}";
     ArrayList<Category> subCategories = new ArrayList<>();
    try (Connection scc = CConection.connection()) {
      try (CallableStatement statement = (CallableStatement) scc.prepareCall(sql)) {
        statement.setInt(1, categorySuper);
        try (ResultSet rs = statement.executeQuery()) {
          while (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("category_id"));
            category.setName(rs.getString("name"));
            subCategories.add(category);
          }
        }
        return subCategories;
      }
    } catch (SQLException e) {
      System.out.println(e.getClass().getName() + " generated: " + e.getMessage());
    }
    return null;
  }
  
  public static boolean isSupper(int category){
    String sql = "{CALL sp_contarSubCategorias(?)}";
    try(Connection scc = CConection.connection()){
      try (CallableStatement statement = (CallableStatement) scc.prepareCall(sql)){
        statement.setInt(1, category);
        try (ResultSet rs = statement.executeQuery()) {
          rs.next();
          return rs.getInt("quantity") > 0;
        }
      }
    }
    catch (SQLException e) {
      System.out.println(e.getClass().getName() + " generated: " + e.getMessage());
    }
    return false;
  }
}
