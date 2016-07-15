package newDatatypes;

public class QueueUsingStacks {
	SimpleStack s1, s2;
	public QueueUsingStacks(){
		s1 = new SimpleStack();
		s2 = new SimpleStack();
	}
	
	public void enqueue(int d){
		s1.push(d);
	}
	
	public int dequeue() throws Exception{
		if(s2.size == 0){
			while(s1.size != 0){
				s2.push(s1.pop());
			}
		}
		
		return s2.pop();
	}
	
/*	public int front() throws Exception{
		return s2.top();
	}
*/	
	public static void test() throws Exception{
		QueueUsingStacks q = new QueueUsingStacks();
		try {
			q.enqueue(9);
			q.enqueue(4);
			q.enqueue(5);
			System.out.println("front is "+ q.dequeue());
			System.out.println("front is "+ q.dequeue());
			System.out.println("front is "+ q.dequeue());
			System.out.println("front is "+ q.dequeue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("SimpleStack is empty..");
		}

	}

}
