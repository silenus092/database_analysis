package BoyerMoore;

import java.util.List;

import com.javacodegeeks.stringsearch.BM;

import MySQLAccess.MySQLAccess_Driver;

public class BoyerMoore   {


	public BoyerMoore()
	{
	
	}

    public int search(String source, String pattern)
    {
    	List<Integer> idx = BM.findAll(pattern, source);
    	return idx.size();
    }
    
   
}
