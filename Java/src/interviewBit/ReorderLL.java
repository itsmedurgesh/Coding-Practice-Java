package interviewBit;



public class ReorderLL {
	static class ListNode {
	    public int val;
	    public ListNode next;
	    ListNode(int x) { val = x; next = null; }
	}
	public static ListNode reorderList(ListNode a) {
	    ListNode s = a;
	    
	   //// this is working but quadratic in time 
	   // while(s != null && s.next != null && s.next.next != null){
	   //     ListNode first = s;
	   //     ListNode slast = s.next;
	        
	   //     while(slast.next.next != null){ slast = slast.next; }
	   //     ListNode last = slast.next;
	   //     slast.next = null;
	        
	   //     last.next = first.next;
	   //     first.next = last;
	        
	   //     s = s.next.next;
	   // }
	   
	   int len = 0;
	   while(s != null){ ++len; s = s.next; }
	   
	   if(len <= 2) return a;
	   
	   int flen = len - (len/2);
	   len /= 2;
	   
	   s = a;
	   while(flen > 1){
	        s = s.next;
	        --flen;
	   }
	   ListNode ss = s.next;
	   s.next = null;
	   
	   // reversing the sencond list
	   ListNode prev = null, cur = ss, next = ss.next;
	   
	   while(next != null){
	       cur.next = prev;
	       prev = cur;
	       cur = next;
	       next = cur.next;
	   }
	   if(prev != null) cur.next = prev;
	   
	   ss = cur;
	   
	   
	   // combining the lists
	   s = a;
	   while(s != null && ss != null){
	       ListNode sec1 = s.next;
	       ListNode sec2 = ss.next;
	       s.next = ss;
	       ss.next = sec1;
	       
	       s = sec1;
	       ss = sec2;
	   }
	   
	    return a;
	}
	
	public static void insert(ListNode a, int d){
		ListNode t = new ListNode(d);
		if(a == null) a = t;
		else{
			ListNode tmp = a;
			while(tmp.next != null) tmp = tmp.next;
			
			tmp.next = t;
		}
	}
	
	public static void print(ListNode a){
		ListNode t = a;
		while(t != null){
			System.out.print(t.val + "> ");
			t = t.next;
		}
		System.out.println("");
	}
	
	public static void test(){
		ListNode h = new ListNode(1);
		insert(h, 2);
		insert(h, 3);
		insert(h, 4);
		insert(h, 5);
		insert(h, 6);
		insert(h, 7);
		
		print(h);
		reorderList(h);
		print(h);		
	}
}
