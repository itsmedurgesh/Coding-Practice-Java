package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Largestnum {
	// DO NOT MODIFY THE LIST
	
	class Comp implements Comparator<Integer>{
	    public int compare(Integer o1, Integer o2){
	    		String r1 = o1.toString() + o2.toString();
	    		String r2 = o2.toString() + o1.toString();
	    		return r1.compareTo(r2);
	        }
	}
	
	public int maxint(int a){
	    int max = 0;
	    do{
	        int t = a%10;
	        if(t > max)
	            max = t;
	        a /= 10;
	    }while(a>0);
	    return max;
	}
	
	public int nlength(int n){
	    int c = 0;
	    while(n > 0){
	        c++;
	        n /= 10;
	    }
	    
	    return c;
	}
	
	public int fdigit(int n){
		while(n/10 != 0)
			n /= 10;
		return n;
	}
	
	public String largestNumber(final List<Integer> a) {
	    //find the max digit in num
	    Integer[] b = new Integer[a.size()];
	    for(int i=0; i<a.size(); i++)
	        b[i] = a.get(i);
	    
	    StringBuffer res = new StringBuffer();
	    
	    Arrays.sort(b, new Comp());
	    
	    //System.out.println(b.length);
	    boolean allzeros = true;
	    for(int i=b.length-1; i>-1; i--){
	        res.append(b[i]);
	        if(b[i]!=0)
	            allzeros = false;
	    }
	    
	    
	    
	    return allzeros ? "0" : res.toString();
	}
	
	public static void test(){
		Largestnum o = new Largestnum();
		List<Integer> a = new ArrayList<Integer>();
		Integer[] p = {980, 674, 250, 359, 98, 969, 143, 379, 363, 106, 838, 923, 969, 880, 997, 664, 152, 329, 975, 377, 995, 943, 369, 515, 722, 302, 496, 124, 692, 993, 341, 785, 400, 113, 302, 563, 121, 230, 358, 911, 437, 438, 494, 599, 168, 866, 689, 444, 684, 365, 470, 176, 910, 204, 324, 657, 161, 884, 623, 814, 231, 694, 399, 126, 426	};
		a.addAll(Arrays.asList(p));
		System.out.println(o.largestNumber(a));
		
	}
}