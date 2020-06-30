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
    
    public String confindenceIndex(ArrayList<String> liste1){
        ArrayList<String> liste2 = new ArrayList<String>();
        
        // fileName = nom du fichier txt décrypté, à récup du C#
        String fileName = "txt xx";
        
        float indice = 0;
      
        // Return par la fonction
        String toReturn = " ";
        
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
            }
            
            float sizel1 = liste1.size();
            float sizel2 = liste2.size();
           
            indice = (sizel2/sizel1)*100;
        
            if(indice >= 100) {
                //System.out.println("L'indice de décryptage est suffisant");
                //System.out.println("L'indice de décryptage est de : " + indice + "%");
                toReturn = "Nom du fichier : " + fileName + " |Indice de décryptage : " + indice +" %";
            }
            else {
                //System.out.println("L'indice de décryptage est insuffisant");
                //System.out.println("L'indice de décryptage est de : " + indice + "%, l'indice minimum requis est de 70%"); 
                toReturn = "Indice de décryptage est insuffisant";
            }      
           
            
            st.close();
            conn.close();
            return toReturn;
        } catch (SQLException ex) {
            return ex.toString();
        }
    }
}
