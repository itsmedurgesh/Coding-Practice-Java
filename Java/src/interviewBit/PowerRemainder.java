package interviewBit;
/* this implementation uses right to left binary modular exponentiation
 * 
 */
public class PowerRemainder {
	public static int getremain(int a, int b, int c){
		int ans = 1;
		int sqr = a;
		
		if(b==0) return 1;
		
		while(b > 0){
			if(b%2 == 1){
				ans *= sqr;
				ans %= c;
			}
			b /= 2;
			sqr = (sqr*sqr)%c;
		}
		
		return ans;
	}
	
	public static void test(){
		System.out.println("remain: "+getremain(5,555,9));
	}

}
