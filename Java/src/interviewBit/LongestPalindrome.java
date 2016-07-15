package interviewBit;

public class LongestPalindrome {
	boolean isPalim(String s){
        for(int i=0; i<s.length()/2; ++i){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        
        return true;
    }
    
	public String longestPalindrome(String a) {
	    String b = new StringBuffer(a).reverse().toString();
	    String max = "";
	    String tmp = "";
	    for(int i = 1; i <= a.length(); ++i){
	        String aa = a.substring(0, i);
	        String bb = b.substring(b.length()-i);
	        
	        StringBuffer sb = new StringBuffer();
	        
	        for(int j = 0; j < aa.length(); ++j){
	            if(aa.charAt(j) == bb.charAt(j)){
	                sb.append(aa.charAt(j));
	            }
	            else{
	            	if(sb.length() >= 0){
	                    if(sb.length() > max.length()){
	                        tmp = sb.toString();
	                        if(isPalim(tmp)) max = tmp;
	                    }
                 
	                    sb.setLength(0);
	                }
	            }
	        }
	        if(sb.length() >= 0){
                if(sb.length() > max.length()){
                    tmp = sb.toString();
                    if(isPalim(tmp)) max = tmp;
                }
         
                sb.setLength(0);
            }

	    }
	    for(int i = 1; i <= a.length(); ++i){
	        String aa = b.substring(0, i);
	        String bb = a.substring(b.length()-i);
	        
	        StringBuffer sb = new StringBuffer();
	        
	        for(int j = 0; j < aa.length(); ++j){
	            if(aa.charAt(j) == bb.charAt(j)){
	                sb.append(aa.charAt(j));
	            }
	            else{
	                if(sb.length() >= 0){
	                    if(sb.length() > max.length()){
	                        tmp = sb.toString();
	                        if(isPalim(tmp)) max = tmp;
	                    }
                 
	                    sb.setLength(0);
	                }
	            }
	        }
	        
	        if(sb.length() >= 0){
                if(sb.length() > max.length()){
                    tmp = sb.toString();
                    if(isPalim(tmp)) max = tmp;
                }
         
                sb.setLength(0);
            }
	    }
	    
	    return max;
	}
	
	public static void test(){
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println(lp.longestPalindrome("bbbbabcaaabbacbaaaccbacababaabcabcaaaa"));
	}
}
