/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Branch;
import pojo.TimeR;

/**
 *
 * @author Admin
 */
public class TimeService {
    private Connection conn;
    
    public TimeService(Connection conn) {
        this.conn = conn;
    }
    
    
    public List<TimeR> getTime() throws SQLException {
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM time");
        
        List<TimeR> gio = new ArrayList<>();
        while (rs.next()) {
            TimeR bra = new TimeR();
            bra.setId(rs.getInt("id"));
            bra.setGio(rs.getString("gio"));
            gio.add(bra);
        }
        
        return gio;
    }
}
