package ism.inscriptions.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mysqldb implements IDatabase {

    protected Connection conn;
    protected PreparedStatement ps;

    @Override
    public void ouvriConnexionBD() {
        try{

            //1-Charger le driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2-Ouvrir la connexion a la bd
            try {
                conn= DriverManager.getConnection("jdbc:mysql://localhost:8889/java_l3_projet", "root", "root");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public void closeConnexionBD() {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
        
}
    

