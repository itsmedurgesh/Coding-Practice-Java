package newDatatypes;

public class SimpleStack {
	SimpleNode top = null;
	int size = 0;
	
	public SimpleStack(int d){
		top = new SimpleNode(d);
		size = 1;
		
	}
	
	public SimpleStack() {
		// TODO Auto-generated constructor stub
	}

	public void push(int d){
		if(top == null){
			top = new SimpleNode(d);
			size++;
		}
		else{
			SimpleNode n = new SimpleNode(d);
			n.next = top;
			top = n;
			size++;
		}
	}
	
	public int pop() throws Exception{
		if(top == null) throw new Exception();
		else{
			int k = top.data;
			top = top.next;
			size--;
			return k;
		}
		
	}
	
	public int top() throws Exception{
		if(top==null) throw new Exception();
		else return top.data;
		
	}
	
	public static void test() throws Exception{
		SimpleStack s = new SimpleStack();
		s.push(5);
		System.out.println("SimpleStack top is "+ s.top());
		s.push(4);
		System.out.println("SimpleStack top is "+ s.top());
		s.push(2);
		System.out.println("SimpleStack top is "+ s.top());
		s.pop();
		System.out.println("SimpleStack top is "+ s.top());
		s.push(9);
		System.out.println("SimpleStack top is "+ s.top());
		
	}

}
