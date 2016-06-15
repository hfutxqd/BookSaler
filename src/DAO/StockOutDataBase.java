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

/**
 *
 * @author Henry
 */
public class StockOutDataBase {
    Connection connection;
    public StockOutDataBase(Connection connection)
    {
        this.connection = connection;
    }
    
    public String[] getOrderByOrderNo(String orderNo) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_out_record where id="+orderNo);
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("id");
            resStrings[1] = resultSet.getString("book_name");
            resStrings[2] = resultSet.getString("ISBN");
            resStrings[3] = resultSet.getString("price");
            resStrings[4] = resultSet.getString("stock_out_size");
            resStrings[5] = resultSet.getString("total_price");
            resStrings[6] = resultSet.getString("stock_out_date");
            return resStrings;
        }
        resultSet.close();
        statement.close();
        return null;
    }
    
    public ArrayList<String[]> getBookByISBN(String ISBN) throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_out_record where ISBN="
        +ISBN);
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("id");
            resStrings[1] = resultSet.getString("book_name");
            resStrings[2] = resultSet.getString("ISBN");
            resStrings[3] = resultSet.getString("price");
            resStrings[4] = resultSet.getString("stock_out_size");
            resStrings[5] = resultSet.getString("total_price");
            resStrings[6] = resultSet.getString("stock_out_date");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<String[]> getAll() throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_out_record");
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("id");
            resStrings[1] = resultSet.getString("book_name");
            resStrings[2] = resultSet.getString("ISBN");
            resStrings[3] = resultSet.getString("price");
            resStrings[4] = resultSet.getString("stock_out_size");
            resStrings[5] = resultSet.getString("total_price");
            resStrings[6] = resultSet.getString("stock_out_date");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<String[]> getBooksByBookName(String bookName) throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_out_record where book_name like '%"
        +bookName+"%'");
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("id");
            resStrings[1] = resultSet.getString("book_name");
            resStrings[2] = resultSet.getString("ISBN");
            resStrings[3] = resultSet.getString("price");
            resStrings[4] = resultSet.getString("stock_out_size");
            resStrings[5] = resultSet.getString("total_price");
            resStrings[6] = resultSet.getString("stock_out_date");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
}
