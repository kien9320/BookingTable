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
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;

import pojo.Pas;
import service.PasService;
/**
 *
 * @author Admin
 */
public class PasTeser {

    private static Connection conn;
   
    @BeforeAll
            
    public static void setUpClass() throws SQLException{
        Connection conn = JdbcUtils.getConn();
    }
    
    @AfterAll
    public static void tearDownClass() throws SQLException {
        conn.close();   
    }
    
   
    
}
