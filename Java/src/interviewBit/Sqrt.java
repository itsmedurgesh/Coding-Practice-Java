package interviewBit;

public class Sqrt {
	public static int sqrt(int a) {
	    
	    int s = 1;
	    int e = a;
	    while(s<=e){
	        int mid = s + (e-s)/2;
	        
	        if((long)mid*mid == (long)a)
	            return mid;
	        else if((long)mid*mid < (long)a){
	                if((long)(mid+1)*(mid+1) > (long)a)
	                    return mid;
	            s = mid+1;
	        }
	        else
	            e = mid-1;
	    }
	    
	    return 0;
	}
	
	public static void test(){
		System.out.println("root: "+sqrt(2147483647));
	}
}
