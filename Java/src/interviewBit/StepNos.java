package interviewBit;

import java.util.ArrayList;

public class StepNos {
	void addAll(int a, int b, ArrayList<Integer> ans, int num, int len){
        if(num <= b && num >= a) ans.add(num);
        if(len == 0) return;
        
        if(num == 0) for(int i = 1; i <10; ++i) addAll(a, b, ans, i, len-1);
        
        int ldigit = num%10;
        if(ldigit != 0) addAll(a, b, ans, num*10 + ldigit-1, len-1);
        if(ldigit != 9) addAll(a, b, ans, num*10 + ldigit+1, len-1);
    }
    
	public ArrayList<Integer> stepnum(int a, int b) {
	    ArrayList<Integer> ans = new ArrayList<>();
	    int t = b;
	    int len = 0;
	    while(t > 0){ ++len; t /= 10; }
	    addAll(a, b, ans, 0, len);
	    return ans;
	}
	
	public static void test(){
		StepNos s = new StepNos();
		ArrayList<Integer> ans = s.stepnum(10, 20);
		for(Integer i: ans) System.out.print(i + " ");
	}
}
