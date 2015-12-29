package main;

import java.io.IOException;
import java.util.ArrayList;

import MySQLAccess.MySQLAccess_ClinicalStudyTable;
import MySQLAccess.MySQLAccess_Config;
import MySQLAccess.MySQLAccess_Driver;
import MySQLAccess.MySQLAccess_GeneTable;
import Utils.WriteExcel;
import jxl.write.WriteException;

public class RunBriefSummary {
	
	private MySQLAccess_Driver mysql_driver ;
	
	public RunBriefSummary(MySQLAccess_Driver test ){
		this.mysql_driver =test ;
		RunAnalysis_FULLTEXT_Summary();
	}
	
	public void RunAnalysis_FULLTEXT_Summary(){
		 ArrayList<Double> temp_time_arraylist ;
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] Prepare Analysis_BriefTitle *************");
		 MySQLAccess_ClinicalStudyTable clinical_study =  mysql_driver.getClinical_studyTable_instance();
		 MySQLAccess_GeneTable geneTable = mysql_driver.getGeneTable_instance();
		 
		 System.out.println(" ************* [Main] Summary_query1_FULLTEXT_SYMBOL *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_FULLTEXT(MySQLAccess_Config.summary_query1_FULLTEXT_SYMBOL , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile  Summary_query1_FULLTEXT_SYMBOL *************");
		 constructExcelFile("column_summary_query1_FULLTEXT_SYMBOL" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] Summary_query2_FULLTEXT_NAME*************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_FULLTEXT(MySQLAccess_Config.summary_query2_FULLTEXT_NAME , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile  Summary_query2_FULLTEXT_NAME *************");
		 constructExcelFile("column_Summary_query2_FULLTEXT_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] Summary_query1_FULLTEXT_SYMBOL *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_FULLTEXT(MySQLAccess_Config.summary_query1_FULLTEXT_SYMBOL , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile  Summary_query1_FULLTEXT_SYMBOL *************");
		 constructExcelFile("column_summary_query1_FULLTEXT_SYMBOL" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
	}
	
	public  void constructExcelFile(String filename , ArrayList<GeneSets> geneTable,ArrayList<Double> temp_time_arraylist){
		
		try {
			 WriteExcel test = new WriteExcel();
			    //test.setOutputFile("c:/temp/"+ filename+".csv");
			    test.setOutputFile("/home/note/workspace/Output/"+ filename+".csv");
			    test.write(geneTable , temp_time_arraylist);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
