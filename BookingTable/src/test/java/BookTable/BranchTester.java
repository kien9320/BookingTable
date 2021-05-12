/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Branch;
import service.BranchService;
import service.JdbcUtils;

/**
 *
 * @author Admin
 */
public class BranchTester {
    @Test
    public void testQuantity() throws SQLException {
            Connection conn = JdbcUtils.getConn();
            
            BranchService s = new BranchService(conn);
            List<Branch> branch = s.getBr();
            
            conn.close();
            
            Assertions.assertTrue(branch.size() >= 3);
    }
    
    public void  testUniqueName() throws SQLException {
            Connection conn = JdbcUtils.getConn();
            
             BranchService s = new BranchService(conn);
            List<Branch> cates = s.getBr();
            
            List<String> names = new ArrayList<>();
            cates.forEach(c -> names.add(c.getName()));
            
            Set<String> testNames = new HashSet<>(names);
            
            conn.close();
            
            Assertions.assertEquals(names.size(), testNames.size());
    }
}

