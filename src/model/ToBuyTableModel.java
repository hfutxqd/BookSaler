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
public class ToBuyTableModel implements TableModel{

    ArrayList<String[]> data;
    
    public ToBuyTableModel()
    {
        data = new ArrayList<>();
    }
    
    
    public ToBuyTableModel(ArrayList<String[]> data)
    {
        this.data = data;
    }
    
    public void addRow(String[] row)
    {
        data.add(row);
    }
    
    public void removeRow(int rowCount)
    {
        data.remove(rowCount);
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
        return 4;
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
                name = "售价";
                break;
            case 3:
                name = "数量";
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
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
