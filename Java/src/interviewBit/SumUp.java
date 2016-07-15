package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SumUp {
	void helper(ArrayList<Integer> a, int b, int id, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> res){
        if(id < 0) return;
        
        if(a.get(id) <= b){
            current.add(a.get(id));
            int b1 = b - a.get(id);
            
            if(b1 == 0){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.addAll(current);
                Collections.reverse(tmp);
                res.add(tmp);
                //current.remove(current.size()-1);
            }
            
            helper(a, b1, id-1, current, res);
            current.remove(current.size()-1);
        }
        --id;
        for(; id > 0; --id) if(a.get(id) != a.get(id+1)) break;        
        helper(a, b, id, current, res);        
    }
    
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
//	    Set<Integer> s = new HashSet<>();
//	    s.addAll(a);
//	    a.clear();
//	    a.addAll(s);
	    Collections.sort(a);
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> current = new ArrayList<Integer>();
	    helper(a, b, a.size()-1, current, res);
	    return res;
	}
	
	public static void test(){
		SumUp s = new SumUp();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17));
		ArrayList<ArrayList<Integer>> res = s.combinationSum(a, 33);
		for(ArrayList<Integer> i : res){
			System.out.print("[");
			for(Integer j : i){
				System.out.print(j + ", ");
			}
			System.out.println("]\n");
		}
	}
}
