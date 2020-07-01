/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
    
    public String confindenceIndex(ArrayList<String> list1) throws SQLException{
        /*Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@52.247.70.89:32769:orclcdb","c##developper","Root123");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement st=con.createStatement();*/
        
        ArrayList<String> listTMP = new ArrayList<String>();
        listTMP.add("amour");
        
        ArrayList<String> list2 = new ArrayList<String>();
        
        // fileName = nom du fichier txt décrypté, à récup du C#
        String fileName = "txt xx";
        
        float indice = 0;
      
        // Return par la fonction
        String toReturn = " ";
        
        return list1.get(1);
        
        /*try {
            Connection conn = ds.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs = st.executeQuery("Select count(*) mot from dictionnaire");
            rs.next();
            int count = rs.getInt("rowcount");
            rs.close();
            
            
            /*for (String motachercher : listTMP) {
                //ResultSet rs = st.executeQuery("Select * from dictionnaire where mot ='" + motachercher +"'");
                ResultSet rs = st.executeQuery("Select count(*) mot from dictionnaire");
                
                while(rs.next())
                {
                    list2.add(rs.getString(1));
                }
                rs.close();
            }
            
            float sizel1 = list1.size();
            float sizel2 = list2.size();
           
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
        }*/
    }
}
