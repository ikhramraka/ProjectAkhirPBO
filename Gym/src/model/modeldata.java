/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import gym.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.connector;
import DAOimplement.dataimpl;
import javax.swing.JOptionPane;

public class modeldata implements dataimpl{
    Connection connection;
    final String select = "SELECT * FROM `gym`";
    final String insert = "INSERT INTO `gym`(`nama`, `gender`, `nomor`, `lama`, `biaya`,`daftar`) VALUES (?,?,?,?,?,?)";
    final String habis = "INSERT INTO `riwayat`(`nama`, `gender`, `nomor`, `lama`, `daftar`,`habis`) VALUES (?,?,?,?,?,?)";
    final String update = "UPDATE gym set nama=?, gender=?, nomor=?, lama=?, biaya=?, daftar=? where nama=?";
    final String delete = "DELETE from gym where nama =?";
    public modeldata(){
        connection =connector.connection();
    }

    @Override
    public void insert(data p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getGender());
            statement.setString(3, p.getNomor());
            statement.setDouble(4, p.getLama());
            
            if (p.getLama() > 2){
            double biaya = (p.getLama()*95000)*0.8; // diskon 20%
            statement.setDouble(5, biaya);
            }else{
            double biaya = p.getLama()*95000;
            statement.setDouble(5, biaya);
            }
            statement.setString(6, p.getDaftar());
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setNama(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    @Override
    public void habis(data p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getGender());
            statement.setString(3, p.getNomor());
            statement.setDouble(4, p.getLama());
            statement.setString(5, p.getDaftar());
            statement.setString(6, p.getHabis());
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setNama(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    

    @Override
    public void update(data p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getGender());
            statement.setString(3, p.getNomor());
            statement.setDouble(4, p.getLama());
            
            if (p.getLama() > 2){
            double biaya = (p.getLama()*95000)*0.8; // diskon20%'
            statement.setDouble(5, biaya);
            }else{
            double biaya = p.getLama()*95000;
            statement.setDouble(5, biaya);
            }
            statement.setString(6, p.getDaftar());
            //String temp = ;
            statement.setString(7, p.getNama());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success!");
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed!");
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, p);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success!");

        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed!");

        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }


    @Override
    public List<data> getAll() {
        List<data>dp=null;
        try{
            dp = new ArrayList<data>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                data g = new data();
                g.setNama(rs.getString("Nama"));
                g.setGender(rs.getString("Gender"));
                g.setNomor(rs.getString("Nomor"));
                g.setLama(rs.getDouble("Lama"));
                g.setBiaya(rs.getDouble("Biaya"));
                g.setDaftar(rs.getString("Daftar"));
                dp.add(g);
            }
        }catch (SQLException ex){
            Logger.getLogger(modeldata.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dp;
    }
}
