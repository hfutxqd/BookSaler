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
public class StockedBookDBHelper {
    Connection connection;
    public StockedBookDBHelper(Connection connection)
    {
        this.connection = connection;
    }
    public String[] getBookByISBN(String ISBN) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_existed_books_info_for_stock_in"
        +"where ISBN="+ISBN);
        while (resultSet.next()) {
            String[] resStrings = new String[6];
            resStrings[0] = resultSet.getString("name");
            resStrings[1] = resultSet.getString("ISBN");
            resStrings[2] = resultSet.getString("price");
            resStrings[3] = resultSet.getString("storage_size");
            resStrings[4] = resultSet.getString("saled_size_monthly");
            resStrings[5] = resultSet.getString("profit_monthly");
            return resStrings;
        }
        resultSet.close();
        statement.close();
        return null;
    }
    
    public ArrayList<String[]> getAllBooks() throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_existed_books_info_for_stock_in;");
        while (resultSet.next()) {
            String[] resStrings = new String[6];
            resStrings[0] = resultSet.getString("name");
            resStrings[1] = resultSet.getString("ISBN");
            resStrings[2] = resultSet.getString("price");
            resStrings[3] = resultSet.getString("storage_size");
            resStrings[4] = resultSet.getString("saled_size_monthly");
            resStrings[5] = resultSet.getString("profit_monthly");
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
        statement.executeQuery("select * from v_existed_books_info_for_stock_in"
        +" where name='"+bookName+"'");
        while (resultSet.next()) {
            String[] resStrings = new String[6];
            resStrings[0] = resultSet.getString("name");
            resStrings[1] = resultSet.getString("ISBN");
            resStrings[2] = resultSet.getString("price");
            resStrings[3] = resultSet.getString("storage_size");
            resStrings[4] = resultSet.getString("saled_size_monthly");
            resStrings[5] = resultSet.getString("profit_monthly");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
}
