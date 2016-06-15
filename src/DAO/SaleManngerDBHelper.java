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
public class SaleManngerDBHelper {
    Connection connection;
    public SaleManngerDBHelper(Connection connection)
    {
        this.connection = connection;
    }
    
    public String[] getOrderByOrderNo(String orderNo) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_sale_record where id="+orderNo);
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("id");
            resStrings[1] = resultSet.getString("name");
            resStrings[2] = resultSet.getString("ISBN");
            resStrings[3] = resultSet.getString("price");
            resStrings[4] = resultSet.getString("sale_size");
            resStrings[5] = resultSet.getString("total_price");
            resStrings[6] = resultSet.getString("sale_date");
            return  resStrings;
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
        statement.executeQuery("select * from v_sale_record where ISBN="+ISBN
                +" order by sale_date;");
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("id");
            resStrings[1] = resultSet.getString("name");
            resStrings[2] = resultSet.getString("ISBN");
            resStrings[3] = resultSet.getString("price");
            resStrings[4] = resultSet.getString("sale_size");
            resStrings[5] = resultSet.getString("total_price");
            resStrings[6] = resultSet.getString("sale_date");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<String[]> getAllBooks() throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_sale_record order by sale_date;");
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("id");
            resStrings[1] = resultSet.getString("name");
            resStrings[2] = resultSet.getString("ISBN");
            resStrings[3] = resultSet.getString("price");
            resStrings[4] = resultSet.getString("sale_size");
            resStrings[5] = resultSet.getString("total_price");
            resStrings[6] = resultSet.getString("sale_date");
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
        statement.executeQuery("select * from v_sale_record where name='"+bookName
                +"' order by sale_date;");
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("id");
            resStrings[1] = resultSet.getString("name");
            resStrings[2] = resultSet.getString("ISBN");
            resStrings[3] = resultSet.getString("price");
            resStrings[4] = resultSet.getString("sale_size");
            resStrings[5] = resultSet.getString("total_price");
            resStrings[6] = resultSet.getString("sale_date");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public void stockOut(String orderNo, String number) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.execute("exec p_stock_out "+orderNo+", "+number);
        statement.close();
    }
    
    
}
