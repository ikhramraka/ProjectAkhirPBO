/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import gym.*;
import model.modeltabel;
import java.util.List;
import model.modeldata;
import DAOimplement.dataimpl;
import view.Mainview;

public class datacontrol {
    Mainview frame;
    dataimpl impldata;
    List<data> dp;
    
    public datacontrol(Mainview frame){
        this.frame=frame;
        impldata = new modeldata();
        dp = impldata.getAll();
    }
    public void isi(){
        dp=impldata.getAll();
        modeltabel mp = new modeltabel(dp);
        frame.getjTable1().setModel(mp);
    }
    public void insert(){
        data dp = new data();
        dp.setNama(frame.getJ1().getText());
        dp.setGender(frame.getJ2().getText());
        dp.setNomor(frame.getJ3().getText());
        dp.setLama(Double.parseDouble(frame.getJ4().getText()));
        dp.setDaftar(frame.getJ6().getText());
        impldata.insert(dp);        
    }
    
    public void update(){
        data dp = new data();
        
        dp.setNama(frame.getJ1().getText());
        dp.setGender(frame.getJ2().getText());
        dp.setNomor(frame.getJ3().getText());
        dp.setLama(Double.parseDouble(frame.getJ4().getText()));
        dp.setDaftar(frame.getJ6().getText());
        impldata.update(dp);
    }
    
    public void delete(){
        String nama = frame.getJ1().getText();
        impldata.delete(nama);
    }
    public void habis(){
        data dp = new data();
        dp.setNama(frame.getJ1().getText());
        dp.setGender(frame.getJ2().getText());
        dp.setNomor(frame.getJ3().getText());
        dp.setLama(Double.parseDouble(frame.getJ4().getText()));
        dp.setDaftar(frame.getJ6().getText());
        impldata.habis(dp);        
    }
    
}
