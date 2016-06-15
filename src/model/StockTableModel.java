/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Henry
 */
public class StockTableModel implements TableModel{
    ArrayList<String[]> data;
    public StockTableModel()
    {
        data = new ArrayList<>();
    }
    public StockTableModel(ArrayList<String[]> data)
    {
        this.data = data;
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
    
    public void addRow(String[] row)
    {
        data.add(row);
    }
    
    public void removeRow(int rowCount)
    {
        data.remove(rowCount);
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    public String getSupplierId(int rowIndex)
    {
        return data.get(rowIndex)[9];
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
                name = "供应商";
                break;
            case 5:
                name = "日期";
                break;
            case 6:
                name = "进货量";
                break;
            case 7:
                name = "单价";
                break;
            case 8:
                name = "总价";
                break;    
        }
        return name;
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
