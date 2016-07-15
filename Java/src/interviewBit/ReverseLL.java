package interviewBit;

class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }

public class ReverseLL {
	public static ListNode reverseBetween(ListNode a, int m, int n) {
	    if( m >= n) return a;
	    
	    ListNode s = null, ss = null, t = a;
	    
	    
	    if(m == 1){
	        s = a;
	    }
	    else{
	        for(int i = 1; i < m-1; ++i){ t = t.next; if(t == null) return a; }    
	        ss = t;
	        s = t.next;
	    }
	    
	    ListNode prev, cur, next;
	    
	    prev = ss;
	    cur = s;
	    next = s.next;
	    n = n-m;
	    while(next != null && n > 0){
	        prev = cur;
	        cur = next;	        
	        next = cur.next;
	        cur.next = prev;
	        --n;
	    }
	    if(next == null){
	        cur.next = prev;
	    }
	    
	    if(ss != null) ss.next = cur;
	    s.next = next;
	    
	    if(m == 1) a = cur;
	    
	    return a;
	}
	
	public static void print(ListNode h){
		ListNode t = h;
		while(t != null){
			System.out.print(t.val + "> ");
			t = t.next;
		}
	}
	
	
	public static void test(){
		ListNode h = new ListNode(1);
		h.next = (new ListNode(2));
		h.next.next = (new ListNode(3));
		h.next.next.next = (new ListNode(4));
		h.next.next.next.next = (new ListNode(5));
		
		print(h);
		System.out.println("");
		h = reverseBetween(h, 2, 5);
		print(h);
	}
}

