package trees;

public class BinaryHelper {
	/*next integer with same number of 1 and 0 in binary representation*/
	public static int getNext(int n){
		int c = n;
		int c0 = 0, c1 = 0;
		while(((c&1) == 0) && c!=0){
			c0++; //counting trailing zeros
			c >>= 1;
		}
		
		while((c & 1) == 1 ){
			c1++; //1s before next 0
			c >>= 1;
		}
		
		if(c0+c1 == 31 || c0+c1 == 0)
			return -1;
		
//		int p = c0 + c1;
		
//		n |= (1<<p);
//		n &= ~(1<<p -1);
//		n |= ((1<<(c1 - 1)) -1);
//		return n;
		return n + (1<<c0) + (1<<(c1-1)) -1;
	}
	
	/*for previous number with same number of 1s and 0s */
	
	public static int getPrev(int n){
		int c = n;
		int c0 = 0, c1 = 0;
		
		while((c&1)==1){
			c1++;  //counting trailing 1s
			c >>= 1;
		}
		
		while((c&1)==0 && c != 0){
			c0++;
			c >>= 1;
		}
		
//		int p = c0 + c1;
//		n &= (~0) << (p+1);
//		int mask = (1<<(c1+1)) -1;
//		n |= mask<<(c0-1);
//		return n;
		return n - (1<<c1) - (1<<(c0-1)) + 1;
	}
	
	public static void test(){
		System.out.println("next for 17: " + BinaryHelper.getNext(17));
		System.out.println("prev for 17: " + BinaryHelper.getPrev(17));
	}
}
