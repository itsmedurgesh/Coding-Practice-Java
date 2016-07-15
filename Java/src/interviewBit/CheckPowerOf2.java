package interviewBit;

public class CheckPowerOf2 {
	boolean check(String a){
        if(a.charAt(a.length()-1) != '1') return false;
        for(int i=0; i<a.length()-1; ++i)
            if(a.charAt(i) != '0') return false;
            
        return true;
    }
    
    boolean checkempty(String a){
        for(int i=0; i<a.length(); ++i)
            if(a.charAt(i) != 0) return true;
            
        return false;
    }
	public int power(String a) {
	    
	    if(check(a)) return 0;
	    StringBuffer s = new StringBuffer();
	    int r = 0;
	    
	    while(checkempty(a)){
	        for(int i = 0; i<a.length(); ++i){
	            int x = Character.getNumericValue(a.charAt(i));
	            r *= 10;
	            x += r;
	            r = x%2;
	            x /= 2;
	            s.append("" + x);
	        }
	        
	        if(check(a)) return 1;
	        a = s.toString();
	        s.setLength(0);
	        if(r != 0) return 0;
	    }
	    
	    return 1;
	}
	
	public static void test(){
		CheckPowerOf2 c = new CheckPowerOf2();
		System.out.println(c.power("1"));
	}

}
