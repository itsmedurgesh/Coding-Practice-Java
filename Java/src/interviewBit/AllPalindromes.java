package interviewBit;

import java.util.ArrayList;

public class AllPalindromes {
	static boolean ispalin(String s){
        for(int i = 0; i<s.length()/2; ++i) if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return true;
    }
    
	public static ArrayList<ArrayList<String>> partition(String a) {
	    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	    if(a == null || a.length() == 0) return res;
	    if(a.length() == 1){ 
	        ArrayList<String> t = new ArrayList<String>();
	        t.add(a);
	        res.add(t);
	        return res; 
	    }
	    
	    for(int i = 1; i < a.length(); ++i){
	        String first = a.substring(0, i);
	        String last = a.substring(i);
	        if(ispalin(first)){
	             ArrayList<ArrayList<String>> tmp  = partition(last);
	             if(tmp.size()>0){
	                 for(int j = 0; j<tmp.size(); ++j){
	                     tmp.get(j).add(0, first);
	                     res.add(tmp.get(j));
	                 }
	             }
	        }
	    }
	    if(ispalin(a)){
	    	ArrayList<String> t = new ArrayList<String>();
	        t.add(a);
	        res.add(t);
	    }
	    
	    return res;
	}
	
	public static void test(){
		ArrayList<ArrayList<String>> res = partition("efe");
		for(int i=0; i<res.size(); ++i){
			ArrayList<String> tmp = res.get(i);
			System.out.print("[");
			for(int j=0; j<tmp.size(); ++j){
				System.out.print(tmp.get(j) + ", ");
			}
			System.out.print("]");
			System.out.println();
		}
	}
}
