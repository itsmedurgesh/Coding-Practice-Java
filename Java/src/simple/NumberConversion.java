package simple;

public class NumberConversion {
	/* from any base to decimal
	 * 
	 */
	public static float toDecimal(String s, int base){
		int dot = s.indexOf('.');
		String intpart, fracpart=null;
		if(dot != -1){
			intpart = s.substring(0, dot);
			fracpart = s.substring(dot+1);
		}
		else
			intpart = s;
		
		// converting int part
		int res1 = 0;
		int t = 1;
		for(int i = intpart.length()-1; i>-1; i--){
			if(base != 16)
				res1 += Character.getNumericValue(intpart.charAt(i)) * t;
			else
				res1 += getdecval(intpart.charAt(i))*t;
			t *= base;
		}
		
		
		// converting fraction part
		float res2 = 0;
		float t1 = 1/(float)base;
		if(fracpart != null)
		for(int i = 0; i<fracpart.length(); i++){
			if(base != 16)
				res2 += Character.getNumericValue(fracpart.charAt(i)) * t1;
			else
				res2 += getdecval(fracpart.charAt(i)) * t1;
			
			t1 /= base;
		}
		
		return res1 + res2;
	}

	private static int getdecval(char c) {
		// TODO Auto-generated method stub
		
		switch(c){
		case 'a': return 10;
		case 'b': return 11;
		case 'c': return 12;
		case 'd': return 13;
		case 'e': return 14;
		case 'f': return 15;
		default: return Character.getNumericValue(c);
		}
	}
	
	/* from decimal to any base
	 * 
	 */
	public static String fromDecimal(float n, int base){
		int intpart = (int)n;
		float fracpart = n - intpart;
		
		StringBuffer s = new StringBuffer();
		//convert int part
		String res1 = "";
		while(intpart > 0){
			if(base != 16)
				res1 = Integer.toString(intpart%base) + res1 ;
			else
				res1 = gethexval(intpart%base) + res1;
			intpart /= base;
		}
		
		s.append(res1);
		s.append('.');
		
		int max = 10;
		
		while(fracpart > 0 && max > 0){
			fracpart *= base;
			int p = (int)fracpart;
			fracpart -= p;
			if(base != 16)
				s.append(p);
			else
				s.append(gethexval(p));
			max--;
		}
		
		return s.toString();		
	}

	private static char gethexval(int i) {
		// TODO Auto-generated method stub
		switch(i){
		case 10: return 'a';
		case 11: return 'b';
		case 12: return 'c';
		case 13: return 'd';
		case 14: return 'e';
		case 15: return 'f';
		default: return Integer.toString(i).charAt(0);
		}
	}
	
	
	/* testing method
	 * 
	 */
	public static void test(){
//		System.out.println(1+"");
		System.out.println(toDecimal("28.56", 16));
		System.out.println(fromDecimal(40.335938f, 16));
		
		System.out.println(toDecimal("27.56", 8));
		System.out.println(fromDecimal(23.71875f, 8));
	}
}
