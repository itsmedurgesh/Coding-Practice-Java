package interviewBit;

import interviewBit.SwapPairs.ListNode;

public class InsertSortLL {
public ListNode insertionSortList(ListNode a) {
	    
	    if(a == null || a.next == null) return a;
	    
	    ListNode i = a.next;
	    ListNode iprev = a;
	    
	    while(i != null){
	        ListNode j = a;
	        ListNode jprev = null;
	        while(j != i){
	            if(j.val > i.val){
	                if(jprev != null){
	                    iprev.next = i.next;
	                    jprev.next = i;
	                    i.next = j;
	                }
	                else{
	                    iprev.next = i.next;
	                    a = i;
	                    i.next = j;
	                }
	                break;
	            }
	            
	            jprev = j;
	            j = j.next;
	        }
	        
	        iprev = i;
	        i = i.next;
	    }
	    
	    return a;
	}
}
