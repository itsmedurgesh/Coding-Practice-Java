package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum0 {
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    
	    if(a.size() == 0) return res;
	    
	    Collections.sort(a);
	    
	    for(int i = 0; i<a.size()-2; ++i){
	        for(int j = i+1, k = a.size()-1; j<k; ){
	            int sum = a.get(i) + a.get(j) + a.get(k);
	            if(sum == 0){
	                res.add(new ArrayList<Integer>(Arrays.asList(a.get(i), a.get(j), a.get(k))));
	                while((j+1) < k && a.get(j) == a.get(j+1)) ++j;
	                ++j;
	            }
	            else if(sum < 0){
	                ++j;
	            }
	            else --k;
	        }
	        
	        while(((i+1) < a.size()-2) && (a.get(i).equals(a.get(i+1)))) ++i;
	    }
	    
	    return res;
	}
	
	public static void test(){
		ThreeSum0 t = new ThreeSum0();
		ArrayList<ArrayList<Integer>> a = t.threeSum(new ArrayList<Integer>(Arrays.asList(-31013930, -31013930, 9784175, 21229755)));
		for(ArrayList<Integer> i: a){
			for(int j: i)
				System.out.print(j + " ");
			System.out.println("");
		}
	}

}
