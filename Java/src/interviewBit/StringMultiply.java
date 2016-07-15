package interviewBit;

public class StringMultiply {
	public String add(String a, String b){
        if(a.length()==0) return b;
        if(b.length()==0) return a;
        
        int i = a.length()-1;
        int j = b.length()-1;
        
        StringBuffer s = new StringBuffer();
        int carry = 0;
        while(i > -1 || j > -1){
            char c = i > -1 ? a.charAt(i) : '0';
            char d = j > -1 ? b.charAt(j) : '0';
            
            int x = Character.getNumericValue(c);
            int y = Character.getNumericValue(d);
            
            //carry *= 10;
            int z = x+y;
            z += carry;
            
            carry = z/10;
            z %= 10;
            
            s.insert(0, ""+z );
            
            --i;
            --j;
        }
        
        if(carry != 0) s.insert(0, carry);
        
        return s.toString();
    }
	public String multiply(String a, String b) {
	    
	    String res = "";
	    
	    for(int i = a.length()-1; i>-1; --i){
	        char c = a.charAt(i);
	        int x = Character.getNumericValue(c);
	        int carry = 0;
	        StringBuffer s = new StringBuffer();
	        
	        for(int j = b.length()-1; j>-1; --j){
	            
	            char d = b.charAt(j);
	            int y = Character.getNumericValue(d);
	            
	            int z = x*y;
	            z += carry;
	            
	            carry = z/10;
	            z %= 10;
	            
	            s.insert(0, ""+ z);
	        }
	        
	        if(carry != 0)
	        	s.insert(0,  ""+carry);
	        
	        int t = a.length() -1 - i;
	        
	        while(t-- > 0){ s.append('0'); }
	        
	        res = add(res, s.toString());
	        s.setLength(0);
	    }
	    
	    int k = 0;
	    while(res.charAt(k)=='0') ++k;
	    
	    return res.substring(k);
	}
	
	public static void test(){
		StringMultiply s = new StringMultiply();
		System.out.println(s.multiply("99", "99"));
	}
}
