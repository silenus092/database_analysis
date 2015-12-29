package main;

import java.io.IOException;
import java.util.ArrayList;

import MySQLAccess.MySQLAccess_ClinicalStudyTable;
import MySQLAccess.MySQLAccess_Config;
import MySQLAccess.MySQLAccess_Driver;
import MySQLAccess.MySQLAccess_GeneTable;
import Utils.WriteExcel;
import jxl.write.WriteException;

public class main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		MySQLAccess_Driver test = new MySQLAccess_Driver("localhost:3306","clintrialsgov_out","root","password");
		test.readDataBase();
		if(test.IsDBConnected()){
			test.downloadGenes();
		}
		
		
		RunAnalysisParser("brief_title",test );
		RunAnalysisParser(MySQLAccess_Config.column_criteria,test );
		RunAnalysisParser(MySQLAccess_Config.column_brief_summary,test );
		test.close_connection();
		
		  
	}
	
	public static void RunAnalysisParser(String ColumName ,MySQLAccess_Driver test ){
	
		
	    	 if(ColumName.equalsIgnoreCase(MySQLAccess_Config.column_brief_title) ){
	    		 new RunBriefTitle(test);
	    	
	    	 }else if(ColumName.equalsIgnoreCase(MySQLAccess_Config.column_criteria)){
	    		 new RunCriteria(test);
	    	 }else if(ColumName.equalsIgnoreCase(MySQLAccess_Config.column_brief_summary)){
	    		 new RunBriefSummary(test);
	    	 }else{
	    		 
	    	 }
	    	 
	  }

	
	


}
