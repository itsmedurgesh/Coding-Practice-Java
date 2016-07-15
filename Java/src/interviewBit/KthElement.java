package interviewBit;

public class KthElement {
	public static int getKth(int[] a, int[] b, int k){
		int i = k/2;
		int j = k - i -1;
		int step = k/4;
		
		while(step > 0){
			if(a[i] > b[i]){
				i -= step;
				j += step;
			}
			else{
				i += step;
				j -= step;
			}
			step /= 2;
		}
		
		if(a[i] > b[j])
			return a[i];
		else
			return b[j];
		
	}
	
	
	public static void test(){
		int[] a = {1,2,3,5,7,9};
		int[] b = {10,11,34,56,89};
		
		System.out.println(getKth(a,b,1));
	}
	
	
}
