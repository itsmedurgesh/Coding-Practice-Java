package interviewBit;

public class RearrangeArray {
	public static void arrange(int[] a) {
	    
	    for(int i=0; i<a.length; i++){
	        a[i] += (a[a[i]]%a.length)*a.length;
//	        a.set(i, a.get(i)+(a.get(a.get(i))%a.size())*a.size());
	    }
	    
	    for(int i=0; i<a.length; i++){
//	        a.set(i, a.get(i)/a.size());
	    	a[i] /= a.length;
	    }
	    
	}
	
	public static void test(){
		int[] a = {6,3,2,5,1,4,7,0};
		arrange(a);
		for(int t: a)
			System.out.print(t+" ");
	}
}
