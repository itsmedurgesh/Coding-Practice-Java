package hard;

import newDatatypes.DoublyLinkedList;;

public class ReversibleDoubleLL extends DoublyLinkedList {
	
	public void reverse(){
		Node f , n;
		f = head;
		n = head.next;
		while(f.next != null){
			Node t = f.next;
			f.next = f.prev;
			f.prev = t;
			
			f = n;
			n = f.next;
		}
		f.next = f.prev;
		f.prev = null;
		
		Node t = head;
		head = tail;
		tail = t;
	}
	
	public static void test(){
		ReversibleDoubleLL d = new ReversibleDoubleLL();
		d.insert(3);
		d.insert(4);
		d.insert(7);
		d.insert(1);
		d.insert(12);
		d.print();
		d.reverse();
		System.out.println("reversed..");
		d.print();
	}
}
