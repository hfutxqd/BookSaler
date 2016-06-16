/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Henry
 */
public class StockOutDBHelper {
    Connection connection;
    public StockOutDBHelper(Connection connection)
    {
        this.connection = connection;
    }
    
    public Map<String, String> getOrderByOrderNo(String orderNo) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_out_record where id="+orderNo);
        while (resultSet.next()) {
            HashMap<String, String> resStrings = new HashMap<>();
            resStrings.put("id", resultSet.getString("id"));
            resStrings.put("book_name", resultSet.getString("book_name"));
            resStrings.put("ISBN", resultSet.getString("ISBN"));
            resStrings.put("price", resultSet.getString("price"));
            resStrings.put("stock_out_size", resultSet.getString("stock_out_size"));
            resStrings.put("total_price", resultSet.getString("total_price"));
            resStrings.put("stock_out_date", resultSet.getString("stock_out_date"));
            return resStrings;
        }
        resultSet.close();
        statement.close();
        return null;
    }
    
    public ArrayList<Map<String, String>> getBookByISBN(String ISBN) throws SQLException
    {
        ArrayList<Map<String, String>> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_out_record where ISBN="
        +ISBN);
        while (resultSet.next()) {
            HashMap<String, String> resStrings = new HashMap<>();
            resStrings.put("sale_id", resultSet.getString("sale_id"));
            resStrings.put("book_name", resultSet.getString("book_name"));
            resStrings.put("ISBN", resultSet.getString("ISBN"));
            resStrings.put("author", resultSet.getString("author"));
            resStrings.put("publisher", resultSet.getString("publisher"));
            resStrings.put("price", resultSet.getString("price"));
            resStrings.put("stock_out_size", resultSet.getString("stock_out_size"));
            resStrings.put("total_price", resultSet.getString("total_price"));
            resStrings.put("stock_out_date", resultSet.getString("stock_out_date"));
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<Map<String, String>> getAll() throws SQLException
    {
        ArrayList<Map<String, String>> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_out_record");
        while (resultSet.next()) {
            HashMap<String, String> resStrings = new HashMap<>();
            resStrings.put("sale_id", resultSet.getString("sale_id"));
            resStrings.put("book_name", resultSet.getString("book_name"));
            resStrings.put("ISBN", resultSet.getString("ISBN"));
            resStrings.put("author", resultSet.getString("author"));
            resStrings.put("publisher", resultSet.getString("publisher"));
            resStrings.put("price", resultSet.getString("price"));
            resStrings.put("stock_out_size", resultSet.getString("stock_out_size"));
            resStrings.put("total_price", resultSet.getString("total_price"));
            resStrings.put("stock_out_date", resultSet.getString("stock_out_date"));
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<Map<String, String>> getBooksByBookName(String bookName) throws SQLException
    {
        ArrayList<Map<String, String>> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_out_record where book_name like '%"
        +bookName+"%'");
        while (resultSet.next()) {
            HashMap<String, String> resStrings = new HashMap<>();
            resStrings.put("sale_id", resultSet.getString("sale_id"));
            resStrings.put("book_name", resultSet.getString("book_name"));
            resStrings.put("ISBN", resultSet.getString("ISBN"));
            resStrings.put("author", resultSet.getString("author"));
            resStrings.put("publisher", resultSet.getString("publisher"));
            resStrings.put("price", resultSet.getString("price"));
            resStrings.put("stock_out_size", resultSet.getString("stock_out_size"));
            resStrings.put("total_price", resultSet.getString("total_price"));
            resStrings.put("stock_out_date", resultSet.getString("stock_out_date"));
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
}
