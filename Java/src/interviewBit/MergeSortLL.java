package interviewBit;

import interviewBit.SwapPairs.ListNode;

public class MergeSortLL {
	static ListNode mergeList(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;
        
        ListNode res = null, r = null;
        
        
        while(a != null && b != null){
            if(a.val <= b.val){
                if(res == null){
                    r = a;
                    a = a.next;
                    r.next = null;
                    res = r;
                }
                else{
                    r.next = a;
                    a = a.next;
                    r = r.next;
                    r.next = null;
                }
            }
            else{
                if(res == null){
                    r = b;
                    b = b.next;
                    r.next = null;
                    res = r;
                }
                else{
                    r.next = b;
                    b = b.next;
                    r = r.next;
                    r.next = null;
                }
            }
        }
        while(a != null){
            r.next = a;
            a = a.next;
            r = r.next;
            r.next = null;
        }
        while(b != null){
            r.next = b;
            b = b.next;
            r = r.next;
            r.next = null;
        }
        return res;
    }
    
	public static ListNode sortList(ListNode a) {
	    
	    if(a == null || a.next == null) return a;
	    
	    int len = 0;
	    ListNode t = a;
	    
	    while(t != null){ ++len; t = t.next; }
	    len = len - len/2;
	    
	    t = a;
	    while(len > 1){
	        t = t.next;
	        --len;
	    }
	    
	    ListNode b = t.next;
	    t.next = null;
	    
	    a = sortList(a);
	    b = sortList(b);
	    
	    a = mergeList(a, b);
	    
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
		ListNode l = new ListNode(1);
		insert(l, 23);
		insert(l, 12);
		insert(l, 22);
		insert(l, 5);
		insert(l, 1);		
		print(l);
		
		sortList(l);
		print(l);
			
	}
}
