package trees;

import java.util.LinkedList;
import java.util.Queue;

public class Kthnumber {
	public static int kthnum(int k){
		Queue<Integer> q3 = new LinkedList<Integer>();
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		
		q3.add(1);
		
		int v3, v5, v7, min = 0;
		for(int i=0; i<k; i++){
			v3 = q3.isEmpty()? Integer.MAX_VALUE : q3.peek();
			v5 = q5.isEmpty()? Integer.MAX_VALUE : q5.peek();
			v7 = q7.isEmpty()? Integer.MAX_VALUE : q7.peek();
			
			min = Math.min(v3, Math.min(v5, v7));
			
			if(v3 == min){
				q3.remove();
				q3.add(3*min);
				q5.add(5*min);
				q7.add(7*min);
			}
			else if(v5 == min){
				q5.remove();
				q5.add(5*min);
				q7.add(7*min);
			}
			else{
				q7.remove();
				q7.add(7*min);
			}
			System.out.print("> "+ min);
		}
	return min;
	}

	public static void test(){
		kthnum(20);
	}
}
