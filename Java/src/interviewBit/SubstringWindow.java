package interviewBit;

import java.util.HashMap;

public class SubstringWindow {
	static class Temp{
        int n;
        int f = 0;
        Temp(int a){ n = a; }
    }
	public static String minWindow(String S, String T) {
	    
	    int count = T.length();
	    int ls = 0, le = -1, gs = 0, ge = Integer.MAX_VALUE;
	    
	    HashMap<Character, Temp> h = new HashMap<>();
	    for(int i = 0; i<T.length(); ++i){
	        if(h.containsKey(T.charAt(i))){
	            Temp t = h.get(T.charAt(i));
	            ++t.n;
	        }
	        else{
	            h.put(T.charAt(i), new Temp(1));
	        }
	    }
	    
	    for(int i = 0; i < S.length(); ++i){
	        if(h.containsKey(S.charAt(i))){
	            Temp t = h.get(S.charAt(i));
	            ++t.f;
	            --count;
	        }
	        
	        le = i;
	        
	        while(ls <= i){
	            if(!h.containsKey(S.charAt(ls))){ ++ls; continue; }
	            Temp t = h.get(S.charAt(ls));
	            if(t.f <= t.n) break;
	            --t.f;
	            ++ls;
	        }
	        
	        if(count <= 0 && le-ls < ge-gs){
	            ge = le;
	            gs = ls;
	        }
	    }
	    
	    if(count > 0) return "";
	    
	    return S.substring(gs, ge+1);
	}
	
	public static void test(){
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		boolean t = -214483648<0;
		System.out.println(t);

	}
}
