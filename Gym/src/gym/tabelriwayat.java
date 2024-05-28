/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tabelriwayat extends AbstractTableModel{
    List<data> dp;
     private final String[] columnNames = {"Nama", "Jenis Kelamin", "Nomor Telepon", "Daftar", "Habis"};
    public tabelriwayat(List<data>dp){
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
                return dp.get(row).getDaftar();
            case 4:
                return dp.get(row).getHabis();
            default:
                return null;
                
        }
    }
    public void setList(List<data> list) {
        this.dp = list;
        fireTableDataChanged();
    }
    
}


