package Wordcount;

import java.util.HashMap;
import java.util.Map.Entry;

import MySQLAccess.MySQLAccess_Driver;

public class WordCount {
	
	public void run(MySQLAccess_Driver text){
		String s = text.toString();
		String[] sArr = s.split(" ");
		 
		long startTime = 0;
		long endTime = 0;
		long duration = 0;
		long NUM_ITERATIONS = 100;

		
		startTime = System.nanoTime();
		HashMap<String, int[]> intCounter = new HashMap<String, int[]>();
		for (int i = 0; i < NUM_ITERATIONS; i++) {
			for (String a : sArr) {
				int[] valueWrapper = intCounter.get(a);
		 
				if (valueWrapper == null) {
					intCounter.put(a, new int[] { 1 });
				} else {
					valueWrapper[0]++;
				}
			}
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("without containsKey, with int[]:  " + duration);
		
		for(Entry<String, int[]> entry : intCounter.entrySet())
		{
			  String key = entry.getKey();
			    int[] value = entry.getValue();
			    System.out.println(key+":  "+value[0] );
		}
	}
}
