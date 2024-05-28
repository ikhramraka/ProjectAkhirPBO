/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import gym.riwayat;
import java.util.List;
import model.modeltabel;
import model.modelriwayat;
import DAOimplement.riwayatimpl;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import view.riwayatview;

public class riwayatcontrol {
    riwayatview frame;
    riwayatimpl impldata;
    List<riwayat> dp;
    
    public riwayatcontrol(riwayatview frame){
        this.frame=frame;
        impldata = new modelriwayat();
        dp = impldata.getAll();
    }
   public void isi() {
        dp = impldata.getAll();
        DefaultTableModel model = (DefaultTableModel) frame.getjTable1().getModel();
        model.setRowCount(0);
        for(riwayat data : dp) {
            model.addRow(new Object[] {
                data.getNama(),
                data.getGender(),
                data.getNomor(),
                data.getDaftar(),
                data.getHabis()
            });
        }
    }
    
    
}

