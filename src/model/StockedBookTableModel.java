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
public class StockedBookTableModel implements TableModel{
    ArrayList<String[]> data;
    
    public StockedBookTableModel()
    {
        data = new ArrayList<>();
    }
    public StockedBookTableModel(ArrayList<String[]> data)
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
    
    public void remove(int rowIndex)
    {
        data.remove(rowIndex);
    }
    
    public String getISBNByRowIndex(int rowIndex)
    {
        return data.get(rowIndex)[1];
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
                name = "ISBN";
                break;
            case 2:
                name = "进价";
                break;
            case 3:
                name = "库存量";
                break;    
            case 4:
                name = "月销量";
                break;    
            case 5:
                name = "月利润";
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
