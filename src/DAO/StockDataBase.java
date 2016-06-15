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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Henry
 */
public class StockDataBase {
    Connection connection;
    public StockDataBase(Connection connection)
    {
        this.connection = connection;
    }
    public ArrayList<String[]> getBookByISBN(String ISBN) throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_in_record where ISBN = '"+ISBN+"'");
        while (resultSet.next()) {
            String[] resStrings = new String[9];
            resStrings[0] = resultSet.getString("book_name");
            resStrings[1] = resultSet.getString("author");
            resStrings[2] = resultSet.getString("publisher");
            resStrings[3] = resultSet.getString("ISBN");
            resStrings[4] = resultSet.getString("supplier_name");
            resStrings[5] = resultSet.getString("stock_in_date");
            resStrings[6] = resultSet.getString("stock_in_size");
            resStrings[7] = resultSet.getString("stock_in_price");
            resStrings[8] = ""+(Float.valueOf(resStrings[6])*Float.valueOf(resStrings[7]));
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
        statement.executeQuery("select * from v_stock_in_record order by stock_in_date;");
        while (resultSet.next()) {
            String[] resStrings = new String[10];
            resStrings[0] = resultSet.getString("book_name");
            resStrings[1] = resultSet.getString("author");
            resStrings[2] = resultSet.getString("publisher");
            resStrings[3] = resultSet.getString("ISBN");
            resStrings[4] = resultSet.getString("supplier_name");
            resStrings[5] = resultSet.getString("stock_in_date");
            resStrings[6] = resultSet.getString("stock_in_size");
            resStrings[7] = resultSet.getString("stock_in_price");
            resStrings[8] = ""+(Float.valueOf(resStrings[6])*Float.valueOf(resStrings[7]));
            resStrings[9] = resultSet.getString("supplier_id");
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<String[]> getBooksByPublisher(String publisher) throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_in_record where publisher like'%"+publisher+"%'");
        while (resultSet.next()) {
            String[] resStrings = new String[9];
            resStrings[0] = resultSet.getString("book_name");
            resStrings[1] = resultSet.getString("author");
            resStrings[2] = resultSet.getString("publisher");
            resStrings[3] = resultSet.getString("ISBN");
            resStrings[4] = resultSet.getString("supplier_name");
            resStrings[5] = resultSet.getString("stock_in_date");
            resStrings[6] = resultSet.getString("stock_in_size");
            resStrings[7] = resultSet.getString("stock_in_price");
            resStrings[8] = ""+(Float.valueOf(resStrings[6])*Float.valueOf(resStrings[7]));
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public ArrayList<String[]> getBooksByAuthor(String author) throws SQLException
    {
        ArrayList<String[]> reList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_stock_in_record where author like'%"+author+"%'");
        while (resultSet.next()) {
            String[] resStrings = new String[9];
            resStrings[0] = resultSet.getString("book_name");
            resStrings[1] = resultSet.getString("author");
            resStrings[2] = resultSet.getString("publisher");
            resStrings[3] = resultSet.getString("ISBN");
            resStrings[4] = resultSet.getString("supplier_name");
            resStrings[5] = resultSet.getString("stock_in_date");
            resStrings[6] = resultSet.getString("stock_in_size");
            resStrings[7] = resultSet.getString("stock_in_price");
            resStrings[8] = ""+(Float.valueOf(resStrings[6])*Float.valueOf(resStrings[7]));
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
        statement.executeQuery("select * from v_stock_in_record where book_name like '%"+bookName+"%'");
        while (resultSet.next()) {
            String[] resStrings = new String[9];
            resStrings[0] = resultSet.getString("book_name");
            resStrings[1] = resultSet.getString("author");
            resStrings[2] = resultSet.getString("publisher");
            resStrings[3] = resultSet.getString("ISBN");
            resStrings[4] = resultSet.getString("supplier_name");
            resStrings[5] = resultSet.getString("stock_in_date");
            resStrings[6] = resultSet.getString("stock_in_size");
            resStrings[7] = resultSet.getString("stock_in_price");
            resStrings[8] = ""+(Float.valueOf(resStrings[6])*Float.valueOf(resStrings[7]));
            reList.add(resStrings);
        }
        resultSet.close();
        statement.close();
        return reList;
    }
    
    public void insert(String ISBN,String supplier_id,String stock_in_price,String stock_in_size) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.execute("exec p_stock_in "+ISBN+","+supplier_id+","+
                stock_in_price+","+stock_in_size+";");
    }
}
