package main;

import MySQLAccess.MySQLAccess_Driver;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySQLAccess_Driver test = new MySQLAccess_Driver("localhost:3306","clintrialsgov_out","root","");
		test.readDataBase();
		
		test.select_Query(" SELECT c.nct_id , c.brief_title ,h.symbol ,h.name "
				+ " FROM clinical_study c, hgnc_complete_set h "+
               "WHERE c.brief_title LIKE BINARY CONCAT('% ',h.symbol, ' %')");
		test.close_connection();
	}

}
