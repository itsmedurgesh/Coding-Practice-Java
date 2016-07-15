package newDatatypes;

import java.util.*;

/* This stack implementation sorts stack by popping top element from current
 * stack and inserting it to another stack at an apt position
 * it finds apt position by popping the target stack and pushing it to the source stack
 * until it finds apt position
 */

public class SortStack1 {
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer>	t = new Stack<Integer>();
		
		while(!s.isEmpty()){
			int k = s.pop();
			while(!t.isEmpty() && t.peek() > k){
				s.push(t.pop());
			}
			t.push(k);
		}
		
		return t;
	}
	
	public static void test(){
		Stack<Integer> s = new Stack<Integer>();
		s.push(new Integer(10));
		s.push(new Integer(5));
		s.push(new Integer(1));
		s.push(new Integer(8));
		s.push(new Integer(7));
		s = sort(s);
		System.out.println("Stack is:  "+ s.pop());
		System.out.println("Stack is:  "+ s.pop());
		System.out.println("Stack is:  "+ s.pop());
		System.out.println("Stack is:  "+ s.pop());
		System.out.println("Stack is:  "+ s.pop());
	}
	
}
