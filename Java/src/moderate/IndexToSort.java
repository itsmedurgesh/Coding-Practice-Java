package moderate;

public class IndexToSort {
	static void getindices(int[] a){
		int currentmax = Integer.MIN_VALUE;
		int mintosort = -1;
		int currentmin = Integer.MAX_VALUE;
		int maxtosort = a.length;
		
		for(int i=0; i<a.length; i++){
			if(currentmax <= a[i])
				currentmax = a[i];
			else
				maxtosort = i;
		}
		
		for(int i = a.length-1; i>-1; i--){
			if(currentmin > a[i])
				currentmin = a[i];
			else
				mintosort = i;
		}
		
		System.out.println("indices for range: "+mintosort + ", "+maxtosort);
	}
	
	public static void test(){
		int[] a = {1, 2, 4, 5, 8, 11, 7, 12, 6, 7, 16, 18, 19};
		getindices(a);
	}
}
