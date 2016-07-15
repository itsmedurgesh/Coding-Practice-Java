package cormen;

public class ReverseSinglyLinkedList {

	class node{
		int d;
		node next;
		node(int _d){ d = _d; next = null;}
	}
	
	node head = null;
	
	void insert(int d){
		if(head == null){
			head = new node(d);
		}
		else{
			node t = head;
			while(t.next != null) t = t.next;
			t.next = new node(d);
		}
	}
	
	void print(){
		node t = head;
		while(t != null){
			System.out.print(t.d + " ");
			t = t.next;
		}
	}	
	
	void reverse(){
		if(head == null) return;
		if(head.next == null) return;
		
		node first, second, third;
		
		first = head;
		second = first.next;
		third = second.next;
		
		// clear first.next pointer so it dose not create a loop
		first.next = null;
		
		
		while(first != null){
			if(second != null){
				second.next = first;
				head = second;
			}
			
			// update all
			first = second;
			second = third;
			third = (third != null)? third.next : null;
		}
	}
	
	public static void test(){
		ReverseSinglyLinkedList r = new ReverseSinglyLinkedList();
		r.insert(12);
		r.insert(34);
		r.insert(344);
		r.insert(134);
		r.print();
		System.out.println("\nreversed");
		r.reverse();
		r.print();
	}
}
