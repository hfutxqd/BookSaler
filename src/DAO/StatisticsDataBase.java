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
public class StatisticsDataBase {
    Connection connection;
    public StatisticsDataBase(Connection connection)
    {
        this.connection = connection;
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
            resStrings[0] = resultSet.getString("name");
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
    
    public ArrayList<String[]> getAll() throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_books_sale_info_statistics;");
        while (resultSet.next()) {
            String[] resStrings = new String[9];
            resStrings[0] = resultSet.getString("ISBN");
            resStrings[1] = resultSet.getString("name");
            resStrings[2] = resultSet.getString("author");
            resStrings[3] = resultSet.getString("publisher");
            resStrings[4] = resultSet.getString("price");
            resStrings[5] = resultSet.getString("saled_size_monthly");
            resStrings[6] = resultSet.getString("saled_size_totally");
            resStrings[7] = resultSet.getString("profit_monthly");
            resStrings[8] = resultSet.getString("profit_totally");
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
            resStrings[0] = resultSet.getString("name");
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
}
