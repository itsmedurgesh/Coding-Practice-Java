package interviewBit;

public class FindRepeatingNum {
	public static void getRepeatingNum(int[] a){
		int n = a.length;
		long sum = 0;
		long sqrsum = 0;
		
		for(int i=0; i<a.length; i++){
			sum += a[i];
			sqrsum += a[i]*a[i];
		}
		
		long diff = n*(n+1)/2 - sum;
		long diffsqr = n*(n+1)*(2*n+1)/6 - sqrsum;
		
		int k1 = (int) ((diffsqr - diff*diff)/(2*diff));
		int k2 = (int) (k1 + diff);
		
		System.out.println("repeating num: "+k1);
		System.out.println("missing num: "+k2);
				
	}
	
	public static void test(){
		int[] a = {10,2,3,9,5,6,7,8,9,1};
		getRepeatingNum(a);
	}
}
