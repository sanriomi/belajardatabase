/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
 *
 * @author Lintanhg
 */
public class Koneksi {
    public Statement state;
    public Connection connect;
    public String url = "jdbc:mysql://localhost:3380/db_nomorhandphne";
    
    public void koneksiDatabase(){
        try {
            connect = DriverManager.getConnection(url,"root","");//nama database, username database, password database
            System.out.println("Koneksi Tidak Bermasalah");
            state = connect.createStatement();
        } catch (SQLException ex) {
             System.err.println("Cek url, username host dan password host");
             System.err.println("SQLException:"+ex.getMessage());
        }
    }
    
    public void simpanData(String nama, String jabatan, String nope){
    koneksiDatabase();
        try {
           String query = "insert into tbl_nomorhandphone(nama, jabatan, nope) values('"+nama+"','"+jabatan+"','"+nope+"')";
           state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan..");
           connect.close();
        } catch (SQLException ex){
            System.err.println("SQLException:"+ex.getMessage());
        }
    }
}
