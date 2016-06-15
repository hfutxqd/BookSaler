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
public class BookSupplyDataBase {
    Connection connection;
    public BookSupplyDataBase(Connection connection)
    {
        this.connection = connection;
    }
    
    public ArrayList<String[]> getAll() throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_in_from_supply;");
        while (resultSet.next()) {
            String[] resStrings = new String[7];
            resStrings[0] = resultSet.getString("name");
            resStrings[1] = resultSet.getString("author");
            resStrings[2] = resultSet.getString("publisher");
            resStrings[3] = resultSet.getString("ISBN");
            resStrings[4] = resultSet.getString("supply_price");
            resStrings[5] = resultSet.getString("supplier_name");
            resStrings[6] = resultSet.getString("id");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<String[]> byISBN(String ISBN) throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_in_from_supply where ISBN="+ISBN);
        while (resultSet.next()) {
            String[] resStrings = new String[10];
            resStrings[0] = resultSet.getString("name");
            resStrings[1] = resultSet.getString("author");
            resStrings[2] = resultSet.getString("publisher");
            resStrings[3] = resultSet.getString("ISBN");
            resStrings[4] = resultSet.getString("supply_price");
            resStrings[5] = resultSet.getString("supplier_name");
            resStrings[6] = resultSet.getString("id");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<String[]> byBookName(String bookName) throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_in_from_supply where ISBN='"+bookName
        +"'");
        while (resultSet.next()) {
            String[] resStrings = new String[10];
            resStrings[0] = resultSet.getString("name");
            resStrings[1] = resultSet.getString("author");
            resStrings[2] = resultSet.getString("publisher");
            resStrings[3] = resultSet.getString("ISBN");
            resStrings[4] = resultSet.getString("supply_price");
            resStrings[5] = resultSet.getString("supplier_name");
            resStrings[6] = resultSet.getString("id");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
}
