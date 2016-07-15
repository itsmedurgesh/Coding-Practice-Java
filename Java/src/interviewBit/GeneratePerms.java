package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneratePerms {
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(a == null || a.size() == 0) return res;
	    
	    if(a.size() == 1){ res.add(a); return res; }
	    int asize = a.size();
	    int first = a.remove(0);
	    ArrayList<ArrayList<Integer>> tmp  = permute(a);
	    
	    for(int i = 0; i< asize; ++i){
	       for(ArrayList<Integer> t : tmp){
	           ArrayList<Integer> t1 =  new ArrayList<Integer>();
	           t1.addAll(t);
	           t1.add(i, first);
	           res.add(t1);
	       } 
	    }
	    
	    return res;
	}
	
	public static void test(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(1,2,3));
		ArrayList<ArrayList<Integer>> res = permute(a);
		for(int i=0; i<res.size(); ++i){
			ArrayList<Integer> tmp = res.get(i);
			System.out.print("[");
			for(int j=0; j<tmp.size(); ++j){
				System.out.print(tmp.get(j) + ", ");
			}
			System.out.print("]");
			System.out.println();
		}
	}
}
