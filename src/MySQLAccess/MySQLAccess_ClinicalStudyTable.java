package MySQLAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.StopWatch;
import main.GeneSets;

public class MySQLAccess_ClinicalStudyTable {
	  private StopWatch stopWatch ;
	  private double elapsed_time = 0 ;
	  private double total_elapsed_time =0;
	  private int  total_row = 0 ;
	  
	public double getTotal_elapsed_time() {
		  return total_elapsed_time ;
	}


	public double getTotal_row() {
		return total_row;
	}
	  
	  
	 public double getElapsed_time() {
		return elapsed_time;
	}

	private  Statement statement;
	  
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void RunAnalysis_BriefTitle(String cmd  , String value){
		try {
			
			stopWatch  = new StopWatch();
			ResultSet resultSet = statement.executeQuery(cmd+ " '% "+value+" %'");
		    elapsed_time = stopWatch.getElapsedTime();
		    stopWatch=null;
			writeResultSet(resultSet);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			stopWatch.getElapsedTime();
			e.printStackTrace();
			
		}
	}
	
	 private void writeResultSet(ResultSet resultSet) throws SQLException {
		  	long count = 1;
		    // ResultSet is initially before the first data set
		  		 String nct_id = null;
		  		 String symbol = null;
		  	     String name = null;
		  		/*while (resultSet.next()) {
		  		      // It is possible to get the columns via name
		  		      // also possible to get the columns via the column number
		  		      // which starts at 1
		  		      // e.g. resultSet.getSTring(2);
		  				nct_id = resultSet.getString("nct_id");
		  		       //symbol = resultSet.getString("symbol");
		  		      // name = resultSet.getString("name");
		  		     
		  		    
		  		     System.out.println("No :" + count);
		  		      System.out.println("nct_id: " + nct_id);
		  		     // System.out.println("Symbol: " + symbol);
		  		     // System.out.println("Name : " + name );
		  		      System.out.println("*****************");
		  		      count++;
		  		    }	
		  */
		   
		    	resultSet.last();
		      // get the row number of the last row which is also the row count
		      int rowCount = resultSet.getRow();
		      total_row+=rowCount;
		      total_elapsed_time+=elapsed_time;
		      System.out.println("Query Finish :" +elapsed_time +" secs");
		      System.out.println("rowCount = " + rowCount);
		  }
}