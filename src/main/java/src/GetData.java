/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author 33685
 */
@Stateless
public class GetData {
    
    public String getMessage() {
        return "Any message goes here";
    }
    
    @Resource(lookup = "jdbc/oracledb")
    DataSource ds;
    
    public String confindenceIndex(){
        String findWord = "amour";
        ArrayList<String> list1 = new ArrayList<String>();
        try {
            Connection conn = ds.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from dictionnaire where mot ='" +findWord+"'");
            while(rs.next())
            {
                list1.add(rs.getString(1));
            }
            rs.close();
            return list1.get(0);
        } catch (SQLException ex) {
            return ex.toString();
        }
    }
}
