package MySQLAccess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Logger;

import Utils.StopWatch;


public class MySQLAccess_Driver {
  private Connection connect = null;
  private Statement statement = null;

  private ResultSet resultSet = null;
  private  String database_host ="jdbc:mysql://localhost:3306/";
  private  String database_name = null ;

  private  String database_username = "root" ;
  private  String database_password = "password" ;
  private   Logger lgr;

  private MySQLAccess_GeneTable geneTable ;
  private MySQLAccess_ClinicalStudyTable clinical_studyTable;
  
  public MySQLAccess_ClinicalStudyTable getClinical_studyTable_instance() {
	return clinical_studyTable;
  }
  public MySQLAccess_GeneTable getGeneTable_instance() {
	return geneTable;
  }
public MySQLAccess_Driver(String host ,String  db_name,String username ,String password){
	  database_host = host;
	  database_name = db_name ;
	  database_username = username;
	  database_password = password;	  
	  lgr = Logger.getLogger(MySQLAccess_Driver.class.getName());
	  try {
		    // This will load the MySQL driver, each DB has its own driver
		  Class.forName(MySQLAccess_Config.database_driver);
		  System.out.println(" *** MySQL JDBC Driver Registered! ***");
	  } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		lgr.severe("error msg:"+e.getMessage());
	  }
    
  }
  public  void readDataBase() {
    try {
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://"+database_host+"/"+database_name,database_username,database_password);
       if (connect != null) {
  		System.out.println("You made it, take control your database now!");
  	     clinical_studyTable =new MySQLAccess_ClinicalStudyTable();
  	     geneTable = new  MySQLAccess_GeneTable();
  		 statement = connect.createStatement();
  		 clinical_studyTable.setStatement(statement);
  		 geneTable.setStatement(statement);
  		} else {
  		System.out.println("Failed to make connection!");
  		}
    } catch (SQLException e) {
    	close_connection();
    	lgr.severe("error code:"+e.getErrorCode()+" error msg:"+e.getMessage());
    } catch(Exception e){
    	close_connection();
    	lgr.severe("error msg:"+e.getMessage());
    }
  }
  
  public void  select_Query(String query){
	  double elapsed_time = 0 ;
	  try {
		System.out.println("Query preparation");   
		StopWatch stopWatch = new StopWatch();
		resultSet = statement.executeQuery(query);
		elapsed_time = stopWatch.getElapsedTime();
		writeResultSet(resultSet );
		System.out.println("Query Finish :" +elapsed_time +" secs"); 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		lgr.severe("error code:"+e.getErrorCode()+" error msg:"+e.getMessage());
		e.printStackTrace();
	}
  }
  
  public void  downloadGenes(){
	 
      if (connect == null) {
    	  readDataBase();
      }
      geneTable.getAllGene();
  }
  
  
  
  // You need to close the resultSet
  public void close_connection() {
    try {
    	  if (resultSet != null) {
    	        resultSet.close();
    	      }

    	      if (statement != null) {
    	        statement.close();
    	      }

    	      if (connect != null) {
    	        connect.close();
    	      }
    	 System.out.println("Connections are closed!");
    } catch (Exception e) {
    	lgr.severe("error msg:"+e.getMessage());
    }
  }
  
  private void writeResultSet(ResultSet resultSet ) throws SQLException {
	  	long count = 1;
	    // ResultSet is initially before the first data set
	  
	  		 while (resultSet.next()) {
	  		      // It is possible to get the columns via name
	  		      // also possible to get the columns via the column number
	  		      // which starts at 1
	  		      // e.g. resultSet.getSTring(2);
	  		      String nct_id = resultSet.getString("nct_id");
	  		      String brief_title = resultSet.getString("brief_title");
	  		      String summary = resultSet.getString("symbol");
	  		      System.out.println("No :" + count);
	  		      System.out.println("Nct_id: " + nct_id);
	  		      System.out.println("Brief_title: " + brief_title);
	  		      System.out.println("symbol: " + summary );
	  		      System.out.println("*****************");
	  		      count++;
	  		    }
	  	
	   
	    	resultSet.last();
	      // get the row number of the last row which is also the row count
	      int rowCount = resultSet.getRow();
	      System.out.println("rowCount = " + rowCount);
	  }
  
  public Boolean IsDBConnected(){
	  try {
		if(connect.isClosed()){
			  return false;
		  }else{
			  return true;
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
  }

  public Connection get_connect_instance(){
	  return connect;
  }

} 