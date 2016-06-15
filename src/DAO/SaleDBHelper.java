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

/**
 *
 * @author Henry
 */
public class SaleDBHelper {
    Connection connection;
    public SaleDBHelper(Connection connection)
    {
        this.connection = connection;
    }
    public String[] getBookByISBN(String ISBN) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = 
        statement.executeQuery("select * from v_sell_book where ISBN="+ISBN);
        while (resultSet.next()) {
            String[] resStrings = new String[6];
            resStrings[0] = resultSet.getString("ISBN");
            resStrings[1] = resultSet.getString("name");
            resStrings[2] = resultSet.getString("author");
            resStrings[3] = resultSet.getString("publisher");
            resStrings[4] = resultSet.getString("price");
            resStrings[5] = resultSet.getString("storage_size");
            return resStrings;
        }
        resultSet.close();
        statement.close();
        return null;
    }
    
    public void buy(String ISBN,String size) throws SQLException
    {
        System.out.println("ISBN:"+ISBN);
        System.out.println("size:"+size);
        Statement statement = connection.createStatement();
        statement.execute("exec p_sale "+ISBN+", "+size);
        statement.close();
    }
    
}
