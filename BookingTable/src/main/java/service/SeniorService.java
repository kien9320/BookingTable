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
import pojo.Pax;
import pojo.Senior;

public class SeniorService {
    private Connection conn;
    
    public SeniorService(Connection conn) {
        this.conn = conn;
    }
    
    
    public List<Senior> getPax() throws SQLException {
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM senior");
        
        List<Senior> p = new ArrayList<>();
        while (rs.next()) {
            Senior bra = new Senior();
            bra.setId(rs.getInt("id"));
            bra.setSl(rs.getInt("sl"));
            p.add(bra);
        }
        
        return p;
    }
    
}
