package interviewBit;

import java.util.HashMap;

public class NonRepeatingSubstring {
	public static int lengthOfLongestSubstring(String a) {
	    HashMap<Character, Integer> h = new HashMap<>();
	    int ls = 0, le=-1, gs = 0, ge = -1;
	    
	    for(int i = 0; i< a.length(); ++i){
	        if(h.containsKey(a.charAt(i))){
	            int t = h.get(a.charAt(i)) + 1;
	            if(ls < t) ls = t;
	            
	            h.put(a.charAt(i), i);
	        }
	        else{
	            h.put(a.charAt(i), i);
	        }
	        le = i;
	        if(le-ls > ge-gs){ gs = ls; ge = le; }
	    }
//	    System.out.println(a.substring(gs, ge+1));
//	    h.clear();
//	    for(int i = gs; i <= ge; ++i) 
//	    	if(h.containsKey(a.charAt(i))) System.out.println(a.charAt(i));
//	    	else h.put(a.charAt(i), 1);
	    return ge-gs+1;
	}
	
	public static void test(){
		String s = "abcabcabcd";
		System.out.println(lengthOfLongestSubstring(s));
	}
}

