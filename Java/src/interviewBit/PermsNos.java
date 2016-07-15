package interviewBit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermsNos {
	static int fact(int n){
        int t = 1;
        for(int i = 2; i<=n; ++i) t *= i;
        return t;
    }
	public static String getPermutation(int n, int k) {
	    if(k > fact(n)) return null;
	    
	    ArrayList<Integer> nos = new ArrayList<Integer>();
	    for(int i = 1; i<=n; ++i) nos.add(i);
	    
	    StringBuffer res = new StringBuffer();
	    --k;
	    while(n > 0){
	        int t;
	        int f = fact(n-1);
	        t = k/f;
	        k = k%f;
	        
	        res.append(nos.get(t) + "");
	        nos.remove(t);
	        --n;
	    }
	    
	    return res.toString();
	}
	
	public static String getPermutation1(int n, int k) {
	    
	    
	    LinkedList<Integer> nos = new LinkedList<Integer>();
	    for(int i = 1; i<=n; ++i) nos.add(i);
	    
	    ArrayList<Integer> fact = new ArrayList<Integer>(n);
	    fact.add(1);
	    for(int i = 1; i<=n; ++i) fact.add(fact.get(i-1)*i);
	    
	    boolean[] used = new boolean[n];
	    for(int i = 0; i<n; ++i) used[i] = false;
	    
	    if(k > fact.get(n)) return null;
	    
	    StringBuffer res = new StringBuffer();
	    --k;
	    while(n > 0){
	        int t;
	        int f = fact.get(n-1);
	        t = k/f;
	        k = k%f;
	        while(t < n && used[t] == true) ++t;
	        res.append(nos.get(t) + "");
	        used[t] = true;
	        //nos.remove(t);
	        --n;
	    }
	    
	    return res.toString();
	}
	
	public static void test(){
		System.out.println(getPermutation1(3, 2));
	}
}
