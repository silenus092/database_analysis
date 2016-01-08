package BoyerMoore;

import java.util.List;

import com.javacodegeeks.stringsearch.BM;
import com.javacodegeeks.stringsearch.TBM;

public class TurboBM {

	public TurboBM()
	{
	
	}

    public int search(String source, String pattern)
    {
    	List<Integer> idx = TBM.findAll(pattern, source);
    	return idx.size();
    }
    
    public void RunTurboBM(){
    	
    }
}
