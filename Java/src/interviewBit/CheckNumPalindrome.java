package interviewBit;

public class CheckNumPalindrome {
	public static boolean isPalindrome(int a) {
	    
	    if(a< 0) return false;
	    if(a == 0) return true;
	    
	    //count digits
	    int digits = 0;
	    int t = a;
	    while(t>0){
	        digits++;
	        t /= 10;
	    }
	    
	    for(int l = digits, r = 1; l>=r; l--, r++){
	        int p = (int) ((a % Math.pow(10, l)) / Math.pow(10, l-1));
	        int q = (int) ((a % Math.pow(10, r)) / Math.pow(10, r-1));
	        if(p != q) return false;
	    }
	    
	    return true;
	}
	
	public static void test(){
		System.out.println(isPalindrome(12321));
	}
}
