/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabasemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author rumanaaktar
 */
public class DatabaseCreation {
    
    void createDatabase(){
        Connection c = null;
        Statement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Database connection successful....");

            //just drop the table before creating again
            stmt=c.createStatement();
            String str="drop table metadata;";
            stmt.executeUpdate(str);

            String table1=
            "CREATE TABLE metadata("+
             "experiment_id   int  NOT NULL,"+
             "library        varchar(15)     NOT NULL,"+
             "experiment_name   varchar(100),"+
             "tissue_used   varchar(30),"+
             "sequence_platform   varchar(30),"+
             "sequencing_machine   varchar(30),"+
             "sequencing_mode    varchar(30),"+
             "sequence_length int,"+
             "PRIMARY KEY(experiment_id));";
            stmt.executeUpdate(table1);
            
            str="insert into metadata values( 20, 'Library1', 'Global Transcripts profiling of cotyledons', 'cotyledons', 'Illumina', 'HiSeq2000', 'Single', 100 );";
            str+="insert into metadata values( 21, 'Library2', 'Global Transcripts profiling of seed coats', 'Seed coat', 'Illumina', 'HiSeq2000', 'Single', 100 );"; 
            str+="insert into metadata values( 22, 'Library3', 'Developmental profiles of mature cotyledons', 'cotyledons', 'Illumina', 'HiSeq2000', 'Single', 100 );";
            stmt.executeUpdate(str);
            
            
            
            //just drop the table before creating again
            str="drop table gene;";
            stmt.executeUpdate(str);
            
            String table2="CREATE TABLE gene(" +
            "gene_model varchar(30) NOT NULL," +
            "experiment_id    int   NOT NULL," +
            "rpkm        real     NOT NULL," +
            "annotation       varchar(100)," +
            "FOREIGN KEY(experiment_id) REFERENCES metadata(experiment_id)," +
            "PRIMARY KEY(gene_model, experiment_id)" +
            ");";
            stmt.executeUpdate(table2);
            
            
            str="insert into gene values( 'Glyma.04G257100.2', 20, 30.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.2', 21, 8.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.2', 22, 16.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.4', 20, 243.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.4' ,21, 33.3, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.4', 22, 32.4, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.6', 20, 32.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.6', 21, 5.0, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.6', 22, 75.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.8', 20, 35.0, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.8', 21, 35.3, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.04G257100.8', 22, 54.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.2', 20, 34.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.2', 21, 132.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.2', 22, 35.4, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.3', 20, 35.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.3', 21, 37.1, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.3', 22, 23.1, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.4', 20, 36.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.4', 21, 38.3, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.4', 22, 47.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.5', 20, 100.0, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.5', 21, 39.3, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.5', 22, 38.7, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.6', 20, 38.2, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.6', 21, 140.3, 'K-box region and MADS-box transcription factor family protein');";
            str+="insert into gene values( 'Glyma.06G324400.6', 22, 39.4, 'K-box region and MADS-box transcription factor family protein');";
            stmt.executeUpdate(str);

            stmt.close();
            c.close();

           
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    
}
