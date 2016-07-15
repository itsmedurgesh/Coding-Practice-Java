package others;

public class MajorityElement {
	/* returns the element with occurance > n/2
	 * 
	 */
	public static int majority(int[] a){
		int maj = a[0];
		int count = 1;
		
		for(int i=1; i<a.length; i++){
			if(a[i]==maj)
				count++;
			else
				count--;
			if(count==0){
				maj = a[i];
				count=1;
			}
		}
		return maj;
	}
	
	// this does not work
	/*
	public static int majority1(int[] a, int start, int end){
		int mid = (start+end)/2;
		
		if(start==end)
			return a[end];
		
		if(end == (start+1) && a[start]==a[end])
			return a[end];
		
		if(end == (start+1) && a[start]!=a[end])
			return 0;
		
		int l = majority1(a, start, mid);
		int r = majority1(a, mid+1, end);
		
		if(l == r) return l;
		if(l == 0) return r;
		if(r == 0) return l;
		if(l != r) return 0;
		return 0;
	}
	*/
	public static void test(){
		int[] a = {1,2,3,4,5,5,5,5,5};
		System.out.println(majority(a));
//		System.out.println(majority1(a, 0, a.length-1));
	}
}
