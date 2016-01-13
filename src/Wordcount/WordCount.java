package Wordcount;

import java.util.HashMap;
import java.util.Map.Entry;

import MySQLAccess.MySQLAccess_Config;
import MySQLAccess.MySQLAccess_Driver;
import Utils.StopWatch;
import main.ClnicalStudyTable;

public class WordCount {
	private StopWatch stopWatch;
	private double elapsed_time = 0;
	private double total_elapsed_time = 0;
	public void run(MySQLAccess_Driver test){
		
		int instance_num = 1;
		ClnicalStudyTable x;
		while ((x = test.getClinical_studyTable_instance().RuncmdSelectAllForBM(test.get_connect_instance(),
				MySQLAccess_Config.select_all_clinicalstudy_rows, instance_num)) != null) {
			stopWatch = new StopWatch();
			wordCount(x.getBrief_summary_column(),"brief_summary");
			wordCount(x.getBrief_tiltle_column(),"brief_tile");
			wordCount(x.getCriteria_column(),"criteria");
			wordCount(x.getFull_summary_column(),"full_summary");
		elapsed_time = stopWatch.getElapsedTime();
		setTotal_elapsed_time(getTotal_elapsed_time() + elapsed_time);
		stopWatch = null;
		x = null;
		//System.out.println("Wordcount instance_num : " + instance_num+" use time :"+elapsed_time);
		instance_num++;
		
	}
		

	}
	public void wordCount(String text,String Type){
		String s = text.toString();
		String[] sArr = s.split("\\s+|[\r\n]+|\\(+|\\)+");
		HashMap<String, int[]> intCounter = new HashMap<String, int[]>();
	
			for (String a : sArr) {
				int[] valueWrapper = intCounter.get(a);
		 
				if (valueWrapper == null) {
					intCounter.put(a, new int[] { 1 });
				} else {
					valueWrapper[0]++;
				}
			}
		
		/*System.out.println("****************************************"+Type+"*************************************");
		for(Entry<String, int[]> entry : intCounter.entrySet())
		{
			  String key = entry.getKey();
			    int[] value = entry.getValue();
			    System.out.println(key+"  "+value[0] );
		}*/
		
		
	}
	public double getTotal_elapsed_time() {
		return total_elapsed_time;
	}

	public void setTotal_elapsed_time(double total_elapsed_time) {
		this.total_elapsed_time = total_elapsed_time;
	}
}
