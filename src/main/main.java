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
	static MySQLAccess_Driver test ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	    test = new MySQLAccess_Driver("localhost:3306","clintrialsgov_out","root","password");
		test.readDataBase();
		if(test.IsDBConnected()){
			constructGenes();
		}
		
		
		RunAnalysisParser("brief_title");
		test.close_connection();
		
		  
	}
	
	public static void RunAnalysisParser(String ColumName ){
	
		
	    	 if(ColumName.equalsIgnoreCase(MySQLAccess_Config.column_brief_title) ){
	    		 RunAnalysis_BriefTitle();		 
	    	 }
	    	 
	  }
	
	
	
	public static  void constructGenes(){
		test.downloadGenes();
	}
	
	public static void constructExcelFile(String filename , ArrayList<GeneSets> geneTable,ArrayList<Double> temp_time_arraylist){
		
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
	
	public static void RunAnalysis_FULLTEXT_BriefTitle(){
		 ArrayList<Double> temp_time_arraylist ;
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] RunAnalysis_BriefTitle *************");
		 MySQLAccess_ClinicalStudyTable clinical_study =  test.getClinical_studyTable_instance();
		 MySQLAccess_GeneTable geneTable = test.getGeneTable_instance();
		 
		 System.out.println(" ************* [Main] brief_title_query1_LIKE_BINARY_SYMBOL *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_FULLTEXT_BriefTitle(MySQLAccess_Config.brief_title_query1_FULLTEXT_SYMBOL , test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query1_LIKE_BINARY_SYMBOL *************");
		 constructExcelFile("column_brief_title_query1_LIKE_BINARY_SYMBOL" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
	}
	
	public static void RunAnalysis_BriefTitle(){
		 ArrayList<Double> temp_time_arraylist ;
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] RunAnalysis_BriefTitle *************");
		 MySQLAccess_ClinicalStudyTable clinical_study =  test.getClinical_studyTable_instance();
		 MySQLAccess_GeneTable geneTable = test.getGeneTable_instance();
		 
		 System.out.println(" ************* [Main] brief_title_query1_LIKE_BINARY_SYMBOL *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			 clinical_study.RunAnalysis_BriefTitle(MySQLAccess_Config.brief_title_query1_LIKE_BINARY_SYMBOL , test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
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
			 clinical_study.RunAnalysis_BriefTitle(MySQLAccess_Config.brief_title_query1_LIKE_SYMBOL , test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
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
	
			 clinical_study.RunAnalysis_BriefTitle_Name(test.get_connect_instance(),MySQLAccess_Config.brief_title_query2_LIKE_BINARY_NAME , test.getGeneTable_instance().getArrayListGenesets().get(i).getName());
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
			clinical_study.RunAnalysis_BriefTitle_Name(test.get_connect_instance(),MySQLAccess_Config.brief_title_query2_LIKE_NAME , test.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query2_LIKE_NAME *************");
		 constructExcelFile("column_brief_title_query2_LIKE_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query2_LIKE_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			clinical_study.RunAnalysis_BriefTitle_Name(test.get_connect_instance(),MySQLAccess_Config.brief_title_query2_LIKE_NAME , test.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query2_LIKE_NAME *************");
		 constructExcelFile("column_brief_title_query2_LIKE_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query3__LIKE_BINARY_SYMBOL_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			clinical_study.RunANalysis_BriefTitle_SYMBOL_NAME(test.get_connect_instance(),MySQLAccess_Config.brief_title_query3_LIKE_BINARY_SYMBOL_NAME, test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol() ,test.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query3__LIKE_BINARY_SYMBOL_NAME *************");
		 constructExcelFile("column_brief_title_query3__LIKE_BINARY_SYMBOL_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
		 
		 
		 temp_time_arraylist =null;
		 clinical_study.reset_Time_Row();
		 temp_time_arraylist = new ArrayList<Double>();
		 System.out.println(" ************* [Main] brief_title_query3__LIKE_SYMBOL_NAME *************");
		 for(int i = 0 ; i < geneTable.getArrayListGenesets().size() ; i++){
			 //System.out.println("[Main] Gene Symbol  : "+test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol());
			clinical_study.RunANalysis_BriefTitle_SYMBOL_NAME(test.get_connect_instance(),MySQLAccess_Config.brief_title_query3_LIKE_SYMBOL_NAME, test.getGeneTable_instance().getArrayListGenesets().get(i).getSymbol() ,test.getGeneTable_instance().getArrayListGenesets().get(i).getName());
			 temp_time_arraylist.add(clinical_study.getElapsed_time());
		 }
		 System.out.println("[Main] getTotal_row  : "+clinical_study.getTotal_row());
		 System.out.println("[Main] getTotal_elapsed_time : "+ clinical_study.getTotal_elapsed_time());
		 System.out.println(" ************* [Main] Prepare for Wirting ExcelFile brief_title_query3__LIKE_SYMBOL_NAME *************");
		 constructExcelFile("column_brief_title_query3__BINARY_SYMBOL_NAME" ,geneTable.getArrayListGenesets() ,temp_time_arraylist);
	}

}
