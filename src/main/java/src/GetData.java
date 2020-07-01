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
    
    @Resource(lookup = "jdbc/oracledb-serv")
    DataSource ds;
    
    public ArrayList<String> confindenceIndex(ArrayList<String> liste1){
        ArrayList<String> liste2 = new ArrayList<String>();
        ArrayList<String> listeReturned = new ArrayList<String>();
        
        
        try {
            Connection conn = ds.getConnection();
            Statement st=conn.createStatement();
            
            for (String motachercher : liste1) {
            ResultSet rs = st.executeQuery("Select * from dictionnaire where mot ='" +motachercher+"'");
                
            while(rs.next())
            {
                liste2.add(rs.getString(1));
            }
            rs.close();
            
            float sizel1 = liste1.size();
            float sizel2 = liste2.size();
            
            float indice = (sizel2/sizel1)*100;
            
            String toReturn = ""+indice;
            
            listeReturned.add(toReturn);
        
            st.close();
            conn.close();
            
        }
            return listeReturned;

        } catch (SQLException ex) {
            ArrayList<String> returnEx = new ArrayList<String>();
            returnEx.add(ex.toString());
            return returnEx;
        }
    }
}
