package newDatatypes;

public class DoublyLinkedList {
	public class Node{
		int data;
		public Node prev=null;
		public Node next=null;
		public Node(int d){
			data = d;
		}
	}
	
	public Node head=null, tail=null;
	public int length = 0;
	
	public void insert(int d){
		if(tail == null){
			tail = new Node(d);
			head = tail;
		}
		else{
			tail.next = new Node(d);
			tail.next.prev = tail;
			tail = tail.next;
		}
		length++;
	}
//	TODO to implement rest of the functionality
//	public boolean remove(int d){
//		c
//	}
	
	public void print(){
		Node t = head;
		while(t != null){
			System.out.print(t.data + "> ");
			t = t.next;
		}
			
	}
	
	public static void test(){
		DoublyLinkedList d = new DoublyLinkedList();
		d.insert(3);
		d.insert(4);
		d.insert(7);
		d.insert(1);
		d.print();
		
	}
}
