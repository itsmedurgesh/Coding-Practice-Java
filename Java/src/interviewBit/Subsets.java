package interviewBit;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    res.add(new ArrayList<Integer>());  // null set
	    
	    if(a.size() == 0) return res;
	    
	    ArrayList<ArrayList<Integer>> res1 = subsets(new ArrayList<Integer>(a.subList(1, a.size())));
	    
	    for(int i = 0; i<res1.size(); ++i){
	        @SuppressWarnings("unchecked")
			ArrayList<Integer> tmp = (ArrayList<Integer>) res1.get(i).clone();
	        tmp.add(0, a.get(0));
	        res.add(tmp);
	    }
	    for(int i = 1; i<res1.size(); ++i){
	        res.add(res1.get(i));
	    }
	    
	    return res;
	}
	
	public static void test(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(12);
		a.add(14);
		a.add(9);
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> res = subsets(a);
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
