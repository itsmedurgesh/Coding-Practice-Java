package interviewBit;

public class SwapPairs {
	static class ListNode {
	    public int val;
	    public ListNode next;
	    ListNode(int x) { val = x; next = null; }
	}
	public static ListNode swapPairs(ListNode a) {
	    if(a == null || a.next == null) return a;
	    
	    ListNode first = a, sec = a.next, third = a.next.next, prev = null;
	    
	    prev = first;
	    sec.next = first;
	    a = sec;
	    
	    if(third == null){ prev.next = null; return a; }
	    
	    first = third;
	    sec = first.next;
	    
	    while(sec != null){
	        prev.next = sec;
	        third = sec.next;
	        
	        prev = first;
	        sec.next = first;
	        
	        if(third == null){ prev.next = null;  return a;}
	        
	        first = third;
	        sec = first.next;
	    }
	    if(first != null){
	    	prev.next = first;
	    }
	    
	    return a;
	}
	
	static void insert(ListNode a, int d){
		ListNode t = new ListNode(d);
		if(a == null) a = t;
		else{
			ListNode tmp = a;
			while(tmp.next != null) tmp = tmp.next;
			
			tmp.next = t;
		}
	}
	
	static void print(ListNode a){
		ListNode t = a;
		while(t != null){
			System.out.print(t.val + "> ");
			t = t.next;
		}
		System.out.println("");
	}
	
	public static void test(){
		ListNode n = new ListNode(1);
		insert(n, 2);
		insert(n, 3);
		insert(n, 4);
		insert(n, 5);
		insert(n, 6);
		
		print(n);
		
		n = swapPairs(n);
		
		print(n);
	}
}
