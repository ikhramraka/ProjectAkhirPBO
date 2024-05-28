/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import DAOimplement.riwayatimpl;
import gym.riwayat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.connector;
import javax.swing.JOptionPane;

public class modelriwayat implements riwayatimpl{
    Connection connection;
    final String select = "SELECT * FROM riwayat"; 
    final String habis = "INSERT INTO `riwayat`(`nama`, `gender`, `nomor`, `lama`, `daftar`,`habis`) VALUES (?,?,?,?,?,?)";
public modelriwayat(){
    connection = connector.connection();
    }

    public void habis(riwayat p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(habis, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getGender());
            statement.setString(3, p.getNomor());
            statement.setString(4, p.getDaftar());
            statement.setString(5, p.getHabis());
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
    public List<riwayat> getAll() {
        List<riwayat> dh = new ArrayList<>();
        try{
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                riwayat h = new riwayat();
                h.setNama(rs.getString("Nama"));
                h.setGender(rs.getString("Jenis Kelamin"));
                h.setNomor(rs.getString("Nomor Telepon"));
                h.setDaftar(rs.getString("Daftar"));
                h.setHabis(rs.getString("Tgl_Habis"));
                dh.add(h);
            }
        }catch(SQLException ex){
            Logger.getLogger(modelriwayat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dh;
    }

    
}