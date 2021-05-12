/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import pojo.Reservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReservationService {
    private Connection conn;

    public ReservationService(Connection conn) {
        this.conn = conn;
    }

   
 
    public int CountPaxByBranchAndDate(String branchName, Date date) throws SQLException {
            String q = "SELECT SUM(pax) AS sumpax FROM reservation WHERE branch_name=? AND date=?";
            PreparedStatement stm = this.conn.prepareStatement(q);
            stm.setString(1, branchName);
            stm.setDate(2, date);
            ResultSet rs = stm.executeQuery();
            
            int count = 0;
            while(rs.next()){
                count = rs.getInt("sumpax");
            }
            
        return count;
            
    }
    public void addReservation(Reservation p) {
        try {
            String sql = "INSERT INTO reservation(customer_Name,customer_phone,customer_email, date, time, pax,baby, senior, branch_name, note) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = this.conn.prepareStatement(sql);
            stm.setString(1, p.getCustomer_Name());
            stm.setString(2, p.getCustomer_phone());
            stm.setString(3, p.getCustomer_email());
            stm.setDate(4, p.getDate());
            stm.setString(5, p.getTime());
            stm.setInt(6, p.getPax());
            stm.setInt(7, p.getBaby());
            stm.setInt(8, p.getSenior());
            stm.setString(9, p.getBranch_name());
            stm.setString(10, p.getNote());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean deleteReservation(int reserveId) {
        try {
            String sql = "DELETE FROM reservation WHERE id=?";
            PreparedStatement stm = this.conn.prepareStatement(sql);
            stm.setInt(1, reserveId);
            
            int row = stm.executeUpdate();
            
            return row > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public Reservation getReservationByPhoneNumber(String p, Date d, String branch) throws SQLException{
       
            String sql = "SELECT * FROM reservation WHERE customer_phone=? AND date=? AND branch_name=? ";
            PreparedStatement stm = this.conn.prepareStatement(sql);
            stm.setString(1, p);
            stm.setDate(2, d);
            stm.setString(3, branch);

            ResultSet rs = stm.executeQuery();

            Reservation c = null;
        
        while (rs.next()) {
            c = new Reservation();
            c.setBaby(rs.getInt("baby"));
            c.setBranch_name(rs.getString("branch_name"));
            c.setBranch_name(rs.getString("branch_name"));
            c.setCustomer_Name(rs.getString("customer_name"));
            c.setCustomer_email(rs.getString("customer_email"));
            c.setCustomer_phone(rs.getString("customer_phone"));
            c.setDate(rs.getDate("date"));
            c.setId(rs.getInt("id"));
            c.setNote(rs.getString("note"));
            c.setPax(rs.getInt("pax"));
            c.setSenior(rs.getInt("senior"));
            c.setTime(rs.getString("time"));
            break;
        }
        
        return c;
    }
}
