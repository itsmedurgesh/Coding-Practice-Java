package interviewBit;

import java.util.ArrayList;
import java.util.Collections;

public class GrayCode {
	void helper(int pos, int n, ArrayList<Integer> curr, ArrayList<Integer> res){
        if(pos >= n){
            res.addAll(curr);
            return;
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.addAll(curr);
        Collections.reverse(tmp);
        for(int i = 0; i <tmp.size(); ++i){
            curr.add(tmp.get(i) + (1<<pos));
        }
        
        helper(pos+1, n, curr, res);
    }
    
	public ArrayList<Integer> grayCode(int a) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    ArrayList<Integer> curr = new ArrayList<Integer>();
	    curr.add(0); 
	    curr.add(1);
	    if(a == 0) return res;
	    
	    helper(1, a, curr, res);
	    return res;
	}
	
	public static void test(){
		GrayCode g = new GrayCode();
		@SuppressWarnings("unused")
		ArrayList<Integer> res = g.grayCode(3);
		System.out.println(1 + 1<<1); // precedence
	}
}
