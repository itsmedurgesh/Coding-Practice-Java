package others;

public class OddOccuringNumbers {
	public static void test(){
		int[] a = {2,3,4,4,3,2,5,3};
		int xor=0;
		for(int b: a)
			xor ^= b;
		int p = 0;
		while((xor & 0x1)==0){
			p++;
			xor >>= 1;
		}
		int x1 = 0, x2 = 0;
		for(int b: a){
			if(((b >> p)&0x1) == 0)
				x1 ^= b;
			else
				x2 ^= b;
		}
		
		System.out.println(x1 +" and "+x2);
		
		
	}
}
