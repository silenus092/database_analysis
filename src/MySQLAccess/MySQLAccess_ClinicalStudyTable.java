package MySQLAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

import Utils.StopWatch;
import main.ClnicalStudyTable;
import main.GeneSets;

public class MySQLAccess_ClinicalStudyTable {
	private StopWatch stopWatch;
	private double elapsed_time = 0;
	private double total_elapsed_time = 0;
	private int total_row = 0;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	public void reset_Time_Row() {
		total_elapsed_time = 0;
		total_row = 0;
	}

	public double getTotal_elapsed_time() {
		return total_elapsed_time;
	}

	public double getTotal_row() {
		return total_row;
	}

	public double getElapsed_time() {
		return elapsed_time;
	}

	private Statement statement;

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void RunAnalysis_FULLTEXT(String cmd, String value) {
		try {
			value = value.replace("'", "\\'");
			stopWatch = new StopWatch();
			ResultSet resultSet = statement.executeQuery(cmd.concat("( '+(\"" + value + "\")' in boolean mode) "));
			elapsed_time = stopWatch.getElapsedTime();
			stopWatch = null;
			writeResultSet(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			stopWatch.getElapsedTime();
			e.printStackTrace();
		}
	}

	public void RunAnalysis_FULLTEXT_NAME(String cmd, String value) {
		try {
			stopWatch = new StopWatch();
			ResultSet resultSet = statement.executeQuery(cmd + "(" + value + " in boolean mode )");
			elapsed_time = stopWatch.getElapsedTime();
			stopWatch = null;
			writeResultSet(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			stopWatch.getElapsedTime();
			e.printStackTrace();
		}
	}

	public void RunAnalysis_FULLTEXT_SYMBOL_NAME(String cmd, String value, String value1) {
		try {
			value1 = value1.replace("'", "\\'");
			stopWatch = new StopWatch();

			ResultSet resultSet = statement
					.executeQuery(cmd.concat("( '+(\"" + value + "\") +(\"" + value1 + "\")'  in boolean mode) "));

			elapsed_time = stopWatch.getElapsedTime();
			stopWatch = null;
			writeResultSet(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			stopWatch.getElapsedTime();
			e.printStackTrace();

		}
	}

	public void RunAnalysis_LIKE(String cmd, String value) {
		try {

			stopWatch = new StopWatch();
			ResultSet resultSet = statement.executeQuery(cmd + "'% " + value + " %'");
			elapsed_time = stopWatch.getElapsedTime();
			stopWatch = null;
			writeResultSet(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			stopWatch.getElapsedTime();
			e.printStackTrace();

		}
	}

	public void RunAnalysis_LIKE_Name(Connection connection, String cmd, String value) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(cmd);
			preparedStatement.setString(1, "% " + value + "% ");
			stopWatch = new StopWatch();
			ResultSet resultSet = preparedStatement.executeQuery();
			elapsed_time = stopWatch.getElapsedTime();
			stopWatch = null;
			writeResultSet(resultSet);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			stopWatch = null;
			e.printStackTrace();

		}
	}

	public void RunAnalysis_LIKE_SYMBOL_NAME(Connection connection, String cmd, String symbol, String name) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(cmd);
			preparedStatement.setString(1, "% " + name + "% AND % " + symbol + " %");
			stopWatch = new StopWatch();
			ResultSet resultSet = preparedStatement.executeQuery();
			elapsed_time = stopWatch.getElapsedTime();
			stopWatch = null;
			writeResultSet(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			stopWatch = null;
			e.printStackTrace();

		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		long count = 1;
		// ResultSet is initially before the first data set
		String nct_id = null;
		String symbol = null;
		String name = null;
		/*
		 * while (resultSet.next()) { // It is possible to get the columns via
		 * name // also possible to get the columns via the column number //
		 * which starts at 1 // e.g. resultSet.getSTring(2); nct_id =
		 * resultSet.getString("nct_id"); //symbol =
		 * resultSet.getString("symbol"); // name = resultSet.getString("name");
		 * 
		 * 
		 * System.out.println("No :" + count); System.out.println("nct_id: " +
		 * nct_id); // System.out.println("Symbol: " + symbol); //
		 * System.out.println("Name : " + name );
		 * System.out.println("*****************"); count++; }
		 */

		resultSet.last();
		// get the row number of the last row which is also the row count
		int rowCount = resultSet.getRow();
		total_row += rowCount;
		total_elapsed_time += elapsed_time;
		// System.out.println("Query Finish :" +elapsed_time +" secs");
		// System.out.println("rowCount = " + rowCount);
	}

	public ClnicalStudyTable RuncmdSelectAllForBM(Connection connection ,String cmd ,int instance_num){
		try {
			
			if(instance_num == 1){
				cmd = cmd.concat("LIMIT " + instance_num);
			}else{
				instance_num--;
				cmd = cmd.concat( "LIMIT " + instance_num +",1");
			}
			  //System.out.println( "cmd: "+cmd);
			preparedStatement = connection.prepareStatement(cmd);
		
			 resultSet = preparedStatement.executeQuery();
			  while (resultSet.next()) { // It is possible to get the columns via
					return new ClnicalStudyTable(resultSet.getString("nct_id"), resultSet.getString("brief_title"),
							resultSet.getString("detailed_description"), resultSet.getString("brief_summary"), resultSet.getString("criteria"));
			   
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
		return null;
		
	}
	
	
}
