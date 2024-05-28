/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import gym.data;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabel extends AbstractTableModel{
    List<data> dp;
     private final String[] columnNames = {"Nama", "Jenis Kelamin", "Nomor Telepon", "Waktu Member", "Biaya", "Daftar"};
    public modeltabel(List<data>dp){
        this.dp=dp;
    }
    

    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
        
    }
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getNama();
            case 1:
                return dp.get(row).getGender();
            case 2:
                return dp.get(row).getNomor();
            case 3:
                return dp.get(row).getLama();
            case 4:
                return dp.get(row).getBiaya();
            case 5:
                return dp.get(row).getDaftar();
            default:
                return null;
                
        }
    }
    public void setList(List<data> list) {
        this.dp = list;
        fireTableDataChanged();
    }
    
}

