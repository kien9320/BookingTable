/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Pas;

public class PasService {
    private Connection conn;
    
    public PasService(Connection conn) {
        this.conn = conn;
    }
    
    
    public List<Pas> getPas() throws SQLException {
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM pax");
        
        List<Pas> p = new ArrayList<>();
        while (rs.next()) {
            Pas bra = new Pas();
            bra.setId(rs.getInt("id"));
            bra.setSl(rs.getInt("sl"));
            p.add(bra);
        }
        
        return p;
    }
    
}
