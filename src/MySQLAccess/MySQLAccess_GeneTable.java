package MySQLAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Utils.StopWatch;
import main.GeneSets;
public class MySQLAccess_GeneTable {
	  private ArrayList<GeneSets> genesets;
	  private StopWatch stopWatch ;
	  private double elapsed_time = 0 ;
	  private  Statement statement;


	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public  MySQLAccess_GeneTable(){
		 genesets = new ArrayList<GeneSets>();	 
	 }
	
	public ArrayList<GeneSets> getArrayListGenesets() {
		return genesets;
	}
	 
	public ResultSet getAllGene(){
		try {
			System.out.println(" Prepare Get All Gene"); 
			stopWatch  = new StopWatch();
			ResultSet resultSet = statement.executeQuery(MySQLAccess_Config.select_all_gene);
		    elapsed_time = stopWatch.getElapsedTime();
		   
			writeResultSet(resultSet);
		    System.out.println(" Complete Get All Gene"); 
			return resultSet ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			stopWatch.getElapsedTime();
			e.printStackTrace();
			return null;
		}
	}
	
	 private void writeResultSet(ResultSet resultSet) throws SQLException {
		  	long count = 1;
		    // ResultSet is initially before the first data set
		  		 String h_id = null;
		  		 String symbol = null;
		  	     String name = null;
		  		 while (resultSet.next()) {
		  		      // It is possible to get the columns via name
		  		      // also possible to get the columns via the column number
		  		      // which starts at 1
		  		      // e.g. resultSet.getSTring(2);
		  		       h_id = resultSet.getString("hgnc_id");
		  		       symbol = resultSet.getString("symbol");
		  		       name = resultSet.getString("name");
		  		      
		  		    genesets.add(new GeneSets(h_id,symbol,name));
		  		    
		  		   /*  System.out.println("No :" + count);
		  		      System.out.println("Hgnc_id: " + h_id);
		  		      System.out.println("Symbol: " + symbol);
		  		      System.out.println("Name : " + name );
		  		      System.out.println("*****************");
		  		      count++;*/
		  		    }	
		  
		   
		    	resultSet.last();
		      // get the row number of the last row which is also the row count
		      int rowCount = resultSet.getRow();
		  
		      System.out.println("Query Finish :" +elapsed_time +" secs");
		      System.out.println("rowCount = " + rowCount);
		  }
}
