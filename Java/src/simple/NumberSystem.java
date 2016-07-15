package simple;

public class NumberSystem {
	public static int decimaltobase(int n, int base){
		int res = 0;
		int i = 1;
		
		while(n > 0){
			res += (n%base)*i;
			n /= base;
			i *= 10;
		}
		return res;
	}
	
	public static String decimaltobase(float n, int base){
		int intpart = (int)n;
		float floatpart = n - (float)intpart;
		int res1 = decimaltobase(intpart, base);
		
		int max = 10;
		float i = (1/base);
		StringBuffer b = new StringBuffer();
		
		b.append(res1);
		b.append('.');
		
		while(floatpart > 0 && max-- > 0){
			if((floatpart -i) < 0)
				b.append('0');
			else{
				b.append('1');
				floatpart -= i;
			}
			i /= 2;
		}
		
		return b.toString();
	}
	
	public static int intPartbinaryToDecimal(String s){
		
		int res = 0;
		int t = 1;
		for(int i = s.length()-1; i>-1; i--){
			res += Character.getNumericValue(s.charAt(i)) * t;
			t *=2;
		}
		
		return res;
	}
	
	public static float binaryToDecimal(String s){
		int dot = s.indexOf('.');
		int intpart = 0;
		float floatpart = 0;
		String floatstring = null;
		
		if(dot != -1){
//			System.out.println(s.substring(0, dot));
			intpart = intPartbinaryToDecimal(s.substring(0, dot));
			floatstring = s.substring(dot+1);
			
			float t = 0.5f;
			
			for(int i=0; i<floatstring.length(); i++){
				floatpart += Character.getNumericValue(floatstring.charAt(i)) * t;
				t /= 2;
			}
		}
		else{
			intpart = intPartbinaryToDecimal(s);
		}
		
		return (float)intpart + floatpart;
	}
	
	// wrapper functions
	public static int tobinary(int n){
		return decimaltobase(n, 2);
	}
	
	public static int tooctal(int n){
		return decimaltobase(n, 8);
	}
	
	public static int tohex(int n){
		return decimaltobase(n, 16);
	}
	
	
	public static void test(){
		System.out.println(tobinary(11));
		System.out.println(tooctal(11));
		System.out.println(tohex(11));
		System.out.println(binaryToDecimal("1.101"));
	}
}
