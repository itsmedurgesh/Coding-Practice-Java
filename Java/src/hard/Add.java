package hard;

public class Add {
	public static int add(int a, int b){
		int c, e, t;
		c = a^b;
		e = a&b;
		while(e != 0){
			e <<= 1;
			t = c^e;
			e = c&e;
			c = t;
		}
		return c;
	}
	
	public static void test(){
		System.out.println(add(-5,-7));
	}
}
