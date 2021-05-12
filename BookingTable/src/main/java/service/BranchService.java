/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

    import pojo.Branch;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.SQLDataException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.List;
/**
 *
 * @author Admin
 */
public class BranchService {
    private Connection conn;
    
    public BranchService(Connection conn) {
        this.conn = conn;
    }
    
    
    public List<Branch> getBr() throws SQLException {
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM branch");
        
        List<Branch> branch = new ArrayList<>();
        while (rs.next()) {
            Branch bra = new Branch();
            bra.setId(rs.getInt("id"));
            bra.setName(rs.getString("name"));
            branch.add(bra);
        }
        
        return branch;
    }
    
    public Branch getBranchByName(String name) throws SQLException {
        if (name == null){
            throw new SQLDataException();
        }
        String sql = "SELECT * FROM branch WHERE name=?";
        PreparedStatement stm = this.conn.prepareStatement(sql);
        stm.setString(1, name);
        
        ResultSet rs = stm.executeQuery();
        
        Branch c = null;
        
        while (rs.next()) {
            c = new Branch();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            break;
        }
        
        return c;
    }
}
