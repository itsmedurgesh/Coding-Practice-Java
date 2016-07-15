package simple;

public class ThreeFactors {
	
	public static int sum(int a, int b, int c){
		return a*b + b*c + c*a;
	}
	public static void factors(int n){
		int a=1, b=1, c=1;
		boolean flag = true;
		
		while(flag){
			int m1 = sum(a+1, b, c);
			int m2 = sum(a, b+1, c);
			int m3 = sum(a, b, c+1);
			
			if(m1 >= m2 && m1 >= m3 && m1 <= n)
				a++;
			else if(m2 >= m1 && m2 >= m3 && m2 <= n)
				b++;
			else if(m3 >= m1 && m3 >= m2 && m3 <= n)
				c++;
			else
				flag = false;
		}
		
		int d = n - sum(a,b,c);
		
		System.out.println("a: "+a+" b: "+b+" c: "+c+" d: "+d);
		
	}
	
	public static void test(){
		factors(36);
	}
}
