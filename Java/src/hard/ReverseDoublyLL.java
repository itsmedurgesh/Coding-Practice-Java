package hard;

import newDatatypes.DoublyLinkedList;

public class ReverseDoublyLL {
	
	public static void reverse(DoublyLinkedList d){
		DoublyLinkedList.Node f , n;
		f = d.head;
		n = f.next;
		while(f.next != null){
			DoublyLinkedList.Node t = f.next;
			f.next = f.prev;
			f.prev = t;
			
			f = n;
			n = f.next;
		}
		f.next = f.prev;
		f.prev = null;
		
		DoublyLinkedList.Node t = d.head;
		d.head = d.tail;
		d.tail = t;
		
	}
	
	public static void test(){
		DoublyLinkedList d = new DoublyLinkedList();
		d.insert(3);
		d.insert(4);
		d.insert(7);
		d.insert(1);
		d.insert(12);
		d.print();
		reverse(d);
		System.out.println("reversed..");
		d.print();
	}
		
}
