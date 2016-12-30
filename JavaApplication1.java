/*INSERT -EKLEME

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author kaan
 */
public class JavaApplication1 
{
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";//No Changes
    static final String DOMAIN_NAME="localhost"; //your domain adress if you use phpmyadmin you must write localhost
    static final String DB_NAME="data_db";//your database name
    static final String DB_URL="jdbc:mysql://"+DOMAIN_NAME +"/"+ DB_NAME; //No changes
   
    static final String USER="root"; //No changes
    static final String PASS="";        //No Changes
    
    public static void main(String[] args) throws ClassNotFoundException 
    {
       Scanner scan=new Scanner(System.in);
       
       Connection conn=null; //No Changes
       PreparedStatement psmt=null; //No Changes
       
       System.out.print("Lütfen İsminizi Giriniz..:");
       String name = scan.nextLine();
       System.out.print("Lütfen Soyisminizi Giriniz..:");
       String lname = scan.nextLine();
       System.out.print("Lütfen E-posta Adresini Giriniz..:");
       String nick = scan.nextLine();
       System.out.print("Lütfen Şifrenizi Giriniz..:");
       String pass = scan.nextLine();
       System.out.print("Lütfen Telefon Numaranizi Giriniz..:");
       String phone = scan.nextLine();
       System.out.print("Lütfen Adresnizi Giriniz..:");
       String adres = scan.nextLine();
       
       
       
       try 
       {
        Class.forName("com.mysql.jdbc.Driver");    //No Changes
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data1?zeroDateTimeBehavior=convertToNull","root",""); //your databases adress in services
        
        String sql="INSERT INTO loginpage (name,lname,nick,pass,phone,adress)"+"values (?,?,?,?,?,?)";//this is  insert sql word
        psmt=conn.prepareStatement(sql);
        psmt.setString (1, name);
        psmt.setString (2, lname);
        psmt.setString (3, nick);
        psmt.setString (4, pass);
        psmt.setString (5, phone);
        psmt.setString (6, adres);
        
        psmt.execute();
        
       
        
        conn.close();
        }catch(SQLException se)
        {
            se.printStackTrace();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
       
       try 
       {
        Class.forName("com.mysql.jdbc.Driver"); 
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data1?zeroDateTimeBehavior=convertToNull","root","");
        
        String sql="SELECT * FROM loginpage WHERE nick = ? ";
        psmt=conn.prepareStatement(sql);
        
        psmt.setString(1,"kaanforum4@gmail.com");
        
        ResultSet rs= psmt.executeQuery();
        
        while(rs.next())
        {
            
            System.out.println(rs.getString("name")+" "+rs.getString("lname")+" "+rs.getString("nick")+" "+rs.getString("pass")+" "+rs.getString("phone")+" "+rs.getString("adress"));
                     
        }
        rs.close();
        psmt.close();
        conn.close();
        }catch(SQLException se)
        {
            se.printStackTrace();
            
        }catch(Exception e)
        {
            e.printStackTrace();
            
        }
       
    }
}
   
