package moderate;

public class Inplaceswap {
	public static void swap(int a, int b){
		a = a+b;
		b = a-b;
		a = a-b;
	}
	
	public static void test(){
		int a =5, b=7;
//		swap(a,b); //pass by value so doesn't work!!  fuck!!
		//instead of algebra we can use bit manipulation
		
		a = a^b;	//a^b
		b = a^b;	//a^b^b = a
		a = a^b;	//a^b^a = b
		
		System.out.println("swapping 5,7: "+ a + "," + b);
	}
}
