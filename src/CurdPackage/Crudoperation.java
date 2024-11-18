package CurdPackage;

import java.sql.*;

public class Crudoperation {
    public void createDatabase(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String name = "root";
            String pass = "root";

            Connection conn = DriverManager.getConnection(url, name, pass);
            Statement stat = conn.createStatement();
            String query = "Create database bh";
            stat.execute(query);
            conn.close();
            System.out.println("Done");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createTable(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String name = "root";
            String pass = "root";
            String db = "bh";
            Connection conn = DriverManager.getConnection(url+db, name, pass);
            Statement stat = conn.createStatement();
            String query = "CREATE table mploy(id int(3),name varchar(200))";
            stat.execute(query);
            conn.close();
            System.out.println("Done");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createData(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String name = "root";
            String pass = "root";
            String db = "bh";
            Connection conn = DriverManager.getConnection(url+db, name, pass);
            
            String query = "Insert into employ(id,name) values(?,?)";
            PreparedStatement preStat = conn.prepareStatement(query);
            preStat.setInt(1, 10);
            preStat.setString(2, "BH");
            /* preStat.execute(); */
            //we also use this
            preStat.executeUpdate();
            conn.close();
            System.out.println("Done insertion");
        } 
        catch (Exception e) { 
            e.printStackTrace();   
        }
    }
    public void updateData(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String name = "root";
            String pass = "root";
            String db = "bh";

            Connection conn = DriverManager.getConnection(url+db, name, pass);
            String query = "Update employ set name = ? where id =?";
            PreparedStatement preStat =conn.prepareStatement(query);
            preStat.setString(1, "Bh");
            preStat.setInt(2, 100);
            preStat.execute();
            conn.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteData(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String name = "root";
            String pass = "root";
            String db = "bh";

            Connection conn = DriverManager.getConnection(url+db, name, pass);
            String query = "DELETE from  employ where id =?";
            PreparedStatement preStat =conn.prepareStatement(query);
            
            preStat.setInt(1, 100);
            preStat.execute();
            conn.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readData(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String name = "root";
            String pass = "root";
            String db = "bh";

            Connection conn = DriverManager.getConnection(url+db, name, pass);
            Statement stat = conn.createStatement();
            String query = "select * from employ";
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
            conn.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}

