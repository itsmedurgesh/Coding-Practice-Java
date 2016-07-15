package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChekPartialSudoku {
	public static int isValidSudoku(final List<String> a) {
	    HashMap<Character, Boolean> h = new HashMap<Character, Boolean>();
	    
	    //check rows 
	    for(int i = 0; i < 9; ++i){
	        for(int j = 0; j < 9 ; ++j){
	            if(a.get(i).charAt(j) != '.'){
	                if(h.containsKey(a.get(i).charAt(j))) return 0;
	                else h.put(a.get(i).charAt(j), true);
	            }
	        }
	        
	        h.clear();
	    }
	    
	    h.clear();
	    
	    //check columns
	    for(int i = 0; i < 9; ++i){
	        for(int j = 0; j < 9 ; ++j){
	            if(a.get(j).charAt(i) != '.'){
	                if(h.containsKey(a.get(j).charAt(i))) return 0;
	                else h.put(a.get(j).charAt(i), true);
	            }
	        }
	        
	        h.clear();
	    }
	    
	    
	    //check blocks;
	    
	    h.clear();
	    for(int i = 0; i < 3; ++i){
	        for(int j = 0; j < 3; ++j){
	            for(int k = 0; k < 3; ++k){
	                for(int l = 0; l < 3; ++l){
	                    if(a.get(3*i + k).charAt(3*j + l) != '.'){
	                        if(h.containsKey(a.get(3*i + k).charAt(3*j + l))) return 0;
	                        else h.put(a.get(3*i + k).charAt(3*j + l), true);
	                    }
	                }
	            }
	            h.clear();
	        }
	    }
	    
	    return 1;
	}
	
	public static void test(){
		List<String> l = new ArrayList<String>();
		l.addAll(Arrays.asList(
				"..5.....6", 
				"....14...", 
				".........", 
				".....92..", 
				"5....2...", 
				".......3.", 
				"...54....", 
				"3.....42.", 
				"...27.6.."
				));
		
		System.out.println(isValidSudoku(l));
	}
}
