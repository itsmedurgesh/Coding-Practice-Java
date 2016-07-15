package moderate;

public class MaxContSum {
	public static void getcontmaxsum(int[] a){
		int gs=0, ge=0, cs=0, ce=0;
		int csum = a[0];
		int gsum = a[0];
		
		//damn this is one sexy algorithm but this shit took my so much time.
		for(int i=1; i<a.length; i++){
			if(csum <= 0){
				if(a[i] > csum){
					csum = a[i];
					cs = i;
					ce = i;
				}
			}
			else{
				csum += a[i];
				ce = i;
			}
			
			if(csum > gsum){
				gsum = csum;
				gs = cs;
				ge = ce;
			}
		}
		
		System.out.println("indices for max sum: "+ gs + ", "+ ge);
		System.out.println("max sum: " + gsum);
	}
	
	public static void test(){
		int[] a = {-3,-5,2,6};
		getcontmaxsum(a);
	}
}