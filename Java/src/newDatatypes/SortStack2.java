package newDatatypes;
/*
 * this program sorts stack using mergrsort type approach
 * one stack is broken into two stacks and called mergesort recursively
 * and then they are merged together(O(n*log n))
 */
import java.util.*;

public class SortStack2 {
	public static Stack<Integer> mergesort(Stack<Integer> s){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		for(int i = 0; i< s.size()/2; i++){
			s1.push(s.pop());
		}
		//int k = s.size();
		if(!s.empty() && s.size() != 1) s = mergesort(s);
		if(!s1.empty() && s1.size() != 1) s1 = mergesort(s1);
		
		while(!s1.empty() || !s.empty()){
			if(!s1.empty() && !s.empty()){
				Integer p = s1.peek();
				Integer q = s.peek();
				if(p.compareTo(q) < 0)
					s2.push(s.pop());
				else
					s2.push(s1.pop());
			}
			else if(!s1.empty()){
					s2.push(s1.pop());
				
			}
			else{
					s2.push(s.pop());
			}
				
		}
		
		Stack<Integer> tmp = new Stack<Integer>();
		while(!s2.empty())					
			tmp.push(s2.pop());				
		
		return tmp;
	}
	
	public static void test(){
		Stack<Integer> s = new Stack<Integer>();
		s.push(new Integer(10));
		s.push(new Integer(5));
		s.push(new Integer(1));
		s.push(new Integer(199));
		s.push(new Integer(55));
		s.push(new Integer(32));
		s.push(new Integer(8));
		s.push(new Integer(7));
		s = mergesort(s);
		s.pop();
		s.pop();
		s.pop();
		System.out.println("Stack is:  "+ s.pop());
		System.out.println("Stack is:  "+ s.pop());
		System.out.println("Stack is:  "+ s.pop());
		System.out.println("Stack is:  "+ s.pop());
		System.out.println("Stack is:  "+ s.pop());
	}

}
