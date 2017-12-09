package javadatabasemanagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rumanaaktar
 */
public class DatabaseRead {
    void readData(){
        Connection c = null;
        Statement stmt = null;
        try {
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:test.db");
           c.setAutoCommit(false);
           System.out.println("Opened database successfully");

           stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery( "SELECT * FROM gene;" );

           while ( rs.next() ) {
              String  gene_model = rs.getString("gene_model");
              int  experiment_id = rs.getInt("experiment_id");
              double rpkm  = rs.getDouble("rpkm");
              String  annotation = rs.getString("annotation");

              System.out.println( "Gene_model = " + gene_model + "...Exp_id = " + experiment_id + "...RPKM = " + rpkm + "...Annotation = " + annotation);
              
           }
           rs.close();
           stmt.close();
           c.close();
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }
        System.out.println("Operation done successfully");



    
    }
    
}
