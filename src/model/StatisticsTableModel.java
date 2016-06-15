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
public class StatisticsTableModel implements TableModel{
    
    ArrayList<String[]> data;
    public StatisticsTableModel()
    {
        data = new ArrayList<>();
    }
    public StatisticsTableModel(ArrayList<String[]> data)
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
        return 9;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name = "";
        switch(columnIndex)
        {
            case 0:
                name = "ISBN";
                break;
            case 1:
                name = "书名";
                break;
            case 2:
                name = "作者";
                break;
            case 3:
                name = "出版社";
                break;    
            case 4:
                name = "售价";
                break;    
            case 5:
                name = "月销量";
                break;
            case 6:
                name = "总销量";
                break;    
            case 7:
                name = "月利润";
                break;    
            case 8:
                name = "总利润";
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
