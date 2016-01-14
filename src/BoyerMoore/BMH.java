package BoyerMoore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.javacodegeeks.stringsearch.HP;


import MySQLAccess.MySQLAccess_Config;
import MySQLAccess.MySQLAccess_Driver;
import Utils.StopWatch;
import Utils.WriteExcel;
import jxl.write.WriteException;
import main.ClnicalStudyTable;
import main.GeneSets;

public class BMH {
	private StopWatch stopWatch;
	private double elapsed_time = 0;
	private double total_elapsed_time = 0;
	HashMap<String,String> myMap = new HashMap<String,String>();
	

	public int search(String source, String pattern) {
		List<Integer> idx = HP.findAll(pattern, source);
		return idx.size();
	}

	public void RunPatternMatching(MySQLAccess_Driver test) {
		System.out.println("************** RunPatternMatching by  BMH ***********");
		// test
		boolean Isfound = false ;
		int instance_num = 1;
		ClnicalStudyTable x;
		ArrayList<GeneSets> array_list = test.getGeneTable_instance().getArrayListGenesets();
		while ((x = test.getClinical_studyTable_instance().RuncmdSelectAllForBM(test.get_connect_instance(),
				MySQLAccess_Config.select_all_clinicalstudy_rows, instance_num)) != null) {
			stopWatch = new StopWatch();
			for (int i = 0; i < array_list.size(); i++) {
				if (search(x.getBrief_tiltle_column(),
						array_list.get(i).getSymbol()) <= 0) {
					if (search(x.getBrief_summary_column(),
							array_list.get(i).getSymbol()) <= 0) {
						if (search(x.getFull_summary_column(),
								array_list.get(i).getSymbol()) <= 0) {
							if (search(x.getCriteria_column(),
									array_list.get(i).getSymbol()) <= 0) {
								//Isfound = false;
							} else {
								array_list.get(i).addContianed_nct_ID(x.getNct_id());
									//Isfound = true;
							}
						} else {
							array_list.get(i).addContianed_nct_ID(x.getNct_id());
							//Isfound = true;
						}
					} else {
						array_list.get(i).addContianed_nct_ID(x.getNct_id());
						//Isfound = true;
					}
				} else {
					array_list.get(i).addContianed_nct_ID(x.getNct_id());
					//Isfound = true;
				}
			}
			elapsed_time = stopWatch.getElapsedTime();
			setTotal_elapsed_time(getTotal_elapsed_time() + elapsed_time);
			stopWatch = null;
			x = null;
			System.out.println("BMH instance_num : " + instance_num+" use time :"+elapsed_time);
			instance_num++;
			
		}
		System.out.println("Total time :"+elapsed_time);
		constructExcelFile("BMH",test.getGeneTable_instance().getArrayListGenesets(),null);
	}

	public double getTotal_elapsed_time() {
		return total_elapsed_time;
	}

	public void setTotal_elapsed_time(double total_elapsed_time) {
		this.total_elapsed_time = total_elapsed_time;
	}
	
	public void constructExcelFile(String filename, ArrayList<GeneSets> geneTable,
			ArrayList<Double> temp_time_arraylist) {

		try {
			WriteExcel test = new WriteExcel();
			// test.setOutputFile("c:/temp/"+ filename+".csv");
			test.setOutputFile("/home/note/workspace/Output/" + filename + ".csv");
			test.write(geneTable, temp_time_arraylist);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
