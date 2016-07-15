package moderate;

public class ConvertToWords {
	public static String toString(long n){
		String res = "";
		String[] big = {"", " thousand", " million", " billion", " trillion"};
		int i=0;
		while(n > 0){
			int k = (int) (n % 1000);
			res = substring(k) + big[i++] + res;
			n /= 1000;
		}
		return res;
	}
	
	private static String substring(int n){
		int a = n/100;
		int b = (n%100)/10;
		int c = n%10;
		
		String res = "";
		if(a != 0)
			res += getones(a) + " hundred";
		if(b == 0){
			res += getones(c);
		}
		else if(b == 1){
			res += getten(n%100);
		}
		else{
			res += gettens(b) + getones(c);
		}
		
		return res;
	}
	
	private static String getones(int n){
		switch(n){
		case 0: return "";
		case 1: return " one";
		case 2: return " two";
		case 3: return " three";
		case 4: return " four";
		case 5: return " five";
		case 6: return " six";
		case 7: return " seven";
		case 8: return " eight";
		case 9: return " nine";
		}
		return null;
	}
	
	private static String getten(int n){
		switch(n){
		case 10: return " ten";
		case 11: return " eleven";
		case 12: return " twelve";
		case 13: return " thirteen";
		case 14: return " fourteen";
		case 15: return " fifteen";
		case 16: return " sixteen";
		case 17: return " seventeen";
		case 18: return " eighteen";
		case 19: return " nineteen";
		}
		return null;
	}
	
	private static String gettens(int n){
		switch(n){
		case 2: return " twenty";
		case 3: return " thirty";
		case 4: return " forty";
		case 5: return " fifty";
		case 6: return " sixty";
		case 7: return " seventy";
		case 8: return " eighty";
		case 9: return " ninety";
		}
		return null;
	}
	
	public static void test(){
		long n = 785456234;
		System.out.println(toString(n));
	}
}
