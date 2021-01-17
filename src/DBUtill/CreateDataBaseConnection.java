/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
public class CreateDataBaseConnection {
    
    private static Connection c;
    public static Connection setConnection () throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagemenysystem?autoReconnect=true&useSSL=false","root","dew123");
    return c;   
    }
    public static void iud(String sql)throws Exception{
        if(c==null){
        setConnection();
        }
        c.createStatement().executeUpdate(sql);
    }
     public static void del(String sql)throws Exception{
        if(c==null){
        setConnection();
        }
        c.createStatement().executeUpdate(sql);
        c.close();
    }
    public static ResultSet search(String sql)throws Exception{
    	System.out.println("runnn");
        if(c==null){
        setConnection();
        }
        return c.createStatement().executeQuery(sql);
    }
     public static Connection ValidateLogin(){
                try{
                   return c;
                } catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                 return null;}
            } 

    public static Connection setConnnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
