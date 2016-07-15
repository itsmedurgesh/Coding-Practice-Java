package newDatatypes;

public class Minstack {
	private class Node{
		int data;
		int min;
		Node next=null;
		
		Node(int d){
			data = d;
		}
	}
	
	Node top = null;
	
	public void push(int d){
		Node n = new Node(d);
		n.next = top;
		if(top != null) n.min = top.data < d ? top.data : d;
		else n.min = d;
		top = n;
	}
	
	public int pop() throws Exception{
		if(top != null){
			int k = top.data;
			top = top.next;
			return k;
		}
		else throw new Exception();
		
	}
	
	public int top() throws Exception{
		if(top == null) throw new Exception();
		else return top.data;
	}
	
	public int min() throws Exception{
		if(top == null) throw new Exception();
		else return top.min;
	}
	
	public static void test() throws Exception{
		Minstack s = new Minstack();
		s.push(4);
		System.out.println("stack top is "+ s.top() + " and min is "+ s.min());
		s.push(6);
		System.out.println("stack top is "+ s.top() + " and min is "+ s.min());
		s.pop();
		System.out.println("stack top is "+ s.top() + " and min is "+ s.min());
		s.push(2);
		System.out.println("stack top is "+ s.top() + " and min is "+ s.min());
		s.push(10);
		System.out.println("stack top is "+ s.top() + " and min is "+ s.min());
		
	}

}
