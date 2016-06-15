/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Henry
 */
public class BookSupplyTableModel implements TableModel{

    ArrayList<String[]> data;
    public BookSupplyTableModel()
    {
        data = new ArrayList<>();
    }
    public BookSupplyTableModel(ArrayList<String[]> data)
    {
        this.data = data;
    }
    
    public String[] getRow(int rowIndex)
    {
        return data.get(rowIndex);
    }
    
    public void addRow(String[] row)
    {
        data.add(row);
    }
    
    public void remove(int rowIndex)
    {
        data.remove(rowIndex);
    }
    
    public void clear()
    {
        data.clear();
    }
    
    public void update(ArrayList<String[]> data)
    {
        data.clear();
        data.addAll(data);
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name = "";
        switch(columnIndex)
        {
            case 0:
                name = "书名";
                break;
            case 1:
                name = "作者";
                break;
            case 2:
                name = "出版社";
                break;
            case 3:
                name = "ISBN";
                break;    
            case 4:
                name = "供价";
                break;    
            case 5:
                name = "供应商";
                break;    
        }
        return name;
    }
    
    public String getSupplierId(int rowIndex)
    {
        return data.get(rowIndex)[6];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data.get(rowIndex)[columnIndex] = (String) aValue;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
