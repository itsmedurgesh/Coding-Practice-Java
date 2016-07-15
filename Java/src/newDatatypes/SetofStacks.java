package newDatatypes;

import java.util.ArrayList;

public class SetofStacks {
	int maxSize;
	int currentSimpleStack;
	
	ArrayList<SimpleStack> listofSimpleStacks = new ArrayList<SimpleStack>();
	
	public SetofStacks(int max){
		maxSize = max;
		currentSimpleStack = 0;
		listofSimpleStacks.add(new SimpleStack());
	}
	
	public void push(int d){
		SimpleStack s = listofSimpleStacks.get(currentSimpleStack);
		if(s.size < maxSize){
			s.push(d);
		}
		else{
			currentSimpleStack++;
			listofSimpleStacks.add(new SimpleStack(d));
		}
	}
	
	public int pop() throws Exception{
		SimpleStack s = listofSimpleStacks.get(currentSimpleStack);
		int k = s.pop();
		if(s.size == 0){
			listofSimpleStacks.remove(currentSimpleStack);
			currentSimpleStack--;
		}
		return k;
	}
	
	public int popAt(int i) throws Exception{
		SimpleStack s = listofSimpleStacks.get(i);
		int k = s.pop();
		return k;
		
	}
	
	public int top() throws Exception{
		SimpleStack s = listofSimpleStacks.get(currentSimpleStack);
		if(s.top == null) s = listofSimpleStacks.get(--currentSimpleStack);
		int k = s.top();
		return k;
	}
	
	public static void test() throws Exception{
		SetofStacks s = new SetofStacks(2);
		s.push(5);
		System.out.println("SimpleStack top is "+ s.top() + " current SimpleStack is " + s.currentSimpleStack);
		s.push(4);
		System.out.println("SimpleStack top is "+ s.top() + " current SimpleStack is " + s.currentSimpleStack);
		s.push(2);
		System.out.println("SimpleStack top is "+ s.top() + " current SimpleStack is " + s.currentSimpleStack);
		s.pop();
		System.out.println("SimpleStack top is "+ s.top() + " current SimpleStack is " + s.currentSimpleStack);
		s.push(9);
		System.out.println("SimpleStack top is "+ s.top() + " current SimpleStack is " + s.currentSimpleStack);
		s.popAt(1);
		System.out.println("SimpleStack top is "+ s.top() + " current SimpleStack is " + s.currentSimpleStack);
				
	}
}
