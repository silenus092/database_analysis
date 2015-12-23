package main;

import java.io.IOException;
import java.util.ArrayList;

import MySQLAccess.MySQLAccess_ClinicalStudyTable;
import MySQLAccess.MySQLAccess_Config;
import MySQLAccess.MySQLAccess_Driver;
import MySQLAccess.MySQLAccess_GeneTable;
import Utils.WriteExcel;
import jxl.write.WriteException;

public class RunBriefTitle {
	private MySQLAccess_Driver mysql_driver ;
	
	public RunBriefTitle(MySQLAccess_Driver test ){
		this.mysql_driver =test ;
		RunAnalysis_FULLTEXT_BriefTitle();
	}
	public void RunAnalysis_FULLTEXT_BriefTitle(){
		 ArrayList<Double> temp_time_arraylist ;
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] Prepare Analysis_BriefTitle *************");
		 MySQLAccess_ClinicalStudyTable clinical_study =  mysql_driver.getClinical_studyTable_instance();
		 MySQLAccess_GeneTable geneTable = mysql_driver.getGeneTable_instance();
		 
		 System.out.println(" ************* [Main] brief_title_query1_FULLTEXT_SYMBOL *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_FULLTEXT(MySQLAccess_Config.brief_title_query1_FULLTEXT_SYMBOL , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query1_FULLTEXT_SYMBOL_NAME *************");
		 constructExcelFile("column_brief_title_query1_FULLTEXT_SYMBOL_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query2_FULLTEXT_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_FULLTEXT(MySQLAccess_Config.brief_title_query2_FULLTEXT_NAME , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query2_LIKE_BINARY_SYMBOL *************");
		 constructExcelFile("column_brief_title_query2_FULLTEXT_SYMBOL_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query3_LIKE_SYMBOL_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_FULLTEXT_SYMBOL_NAME(MySQLAccess_Config.brief_title_query3_FULLTEXT_SYMBOL_NAME
					 , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol()
					 ,mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query3_FULLTEXT_SYMBOL_NAME *************");
		 constructExcelFile("column_brief_title_query3_FULLTEXT_SYMBOL_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
	}
	
	public  void RunAnalysis_BriefTitle(){
		 ArrayList<Double> temp_time_arraylist ;
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] RunAnalysis_BriefTitle *************");
		 MySQLAccess_ClinicalStudyTable clinical_study =  mysql_driver.getClinical_studyTable_instance();
		 MySQLAccess_GeneTable geneTable = mysql_driver.getGeneTable_instance();
		 
		 System.out.println(" ************* [Main] brief_title_query1_LIKE_BINARY_SYMBOL *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_LIKE(MySQLAccess_Config.brief_title_query1_LIKE_BINARY_SYMBOL , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query1_LIKE_BINARY_SYMBOL *************");
		 constructExcelFile("column_brief_title_query1_LIKE_BINARY_SYMBOL" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query1_LIKE_SYMBOL *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_LIKE(MySQLAccess_Config.brief_title_query1_LIKE_SYMBOL , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query1_LIKE_SYMBOL *************");
		 constructExcelFile("column_brief_title_query1_LIKE_SYMBOL" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query2_LIKE_BINARY_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
	
			 clinical_study.RunAnalysis_LIKE_Name(mysql_driver.get_connect_instance(),MySQLAccess_Config.brief_title_query2_LIKE_BINARY_NAME , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query2_LIKE_BINARY_NAME *************");
		 constructExcelFile("column_brief_title_query2_LIKE_BINARY_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query2_LIKE_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			clinical_study.RunAnalysis_LIKE_Name(mysql_driver.get_connect_instance(),MySQLAccess_Config.brief_title_query2_LIKE_NAME , mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query2_LIKE_NAME *************");
		 constructExcelFile("column_brief_title_query2_LIKE_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query3_LIKE_BINARY_SYMBOL_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			clinical_study.RunAnalysis_LIKE_SYMBOL_NAME(mysql_driver.get_connect_instance(),MySQLAccess_Config.brief_title_query3_LIKE_BINARY_SYMBOL_NAME, mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol() ,mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query3_LIKE_BINARY_SYMBOL_NAME *************");
		 constructExcelFile("column_brief_title_query3_LIKE_BINARY_SYMBOL_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query3_LIKE_SYMBOL_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			clinical_study.RunAnalysis_LIKE_SYMBOL_NAME(mysql_driver.get_connect_instance(),MySQLAccess_Config.brief_title_query3_LIKE_SYMBOL_NAME, mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol() ,mysql_driver.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query3_LIKE_SYMBOL_NAME *************");
		 constructExcelFile("column_brief_title_query3_BINARY_SYMBOL_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
	}
	
	public void constructExcelFile(String filename , ArrayList<GeneSets> geneTable,ArrayList<Double> temp_time_arraylist){
		
		try {
			 WriteExcel test = new WriteExcel();
			    test.setOutputFile("c:/temp/"+ filename+".csv");
			    //test.setOutputFile("/home/note/workspace/Output/"+ filename+".csv");
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
