package hard;

public class MaxSumMatrix {
	private static class Result{
		int a=-1, b=-1, c=-1, d=-1;
		int sum=0;
	}
	
	public static void clearArray(int[] a){
		for(int i=0; i<a.length; i++)
			a[i] = 0;
	}
	
	public static Result getMaxSumMat(int[][] a){
		int rows = a.length;
		int cols = a[0].length;
		Result maxres = new Result();
		int[] partialsum = new int[cols];
		for(int rowstart=0; rowstart<rows; rowstart++){
			clearArray(partialsum);
			for(int rowend=rowstart; rowend<rows; rowend++){
				
				for(int c=0; c<cols; c++)
					partialsum[c] += a[rowend][c];
				
				Result res = maxSubArray(partialsum);
				
				if(res.sum > maxres.sum){
					maxres.sum = res.sum;
					maxres.a = res.a;
					maxres.b = res.b;
					maxres.c = rowstart;
					maxres.d = rowend;
				}
			}
		}
		return maxres;
		
	}

	private static Result maxSubArray(int[] a) {
		// TODO Auto-generated method stub
		int gs=0, ge=0, cs=0, ce=0;
		int csum = a[0];
		int gsum = a[0];
		
		Result res = new Result();
		
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
		
		res.a = gs;
		res.b = ge;
		res.sum = gsum;
		
		return res;
	}
	
	public static void test(){
		int[][] a = {{0,-1,-1,0},{0,6,7,0},{0,45,7,0},{-34,0,-34,-54}};
		Result res = getMaxSumMat(a);
		System.out.println("max sum: "+res.sum);
		System.out.println("coordinates: "+res.a+","+res.b+"  "+res.c+","+res.d);
		
	}
	
}
