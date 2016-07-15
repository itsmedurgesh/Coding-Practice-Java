package interviewBit;

public class LongestPalindromenew {
	boolean isPalim(String s){
        for(int i=0; i<s.length()/2; ++i){
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        
        return true;
    }
    
	public String longestPalindrome(String a) {
		
		if(a.length() == 0 || a.length() == 1) return a;
		
		String max = "";
		int mid = -1;
		
		for(int i = 0; i <a.length(); ++i){
			//checking odd palindromes
			int k = 0;
			for(k = 0; ; ++k){
				if((i+k) >= a.length() || (i-k) < 0) break;
				if(a.charAt(i+k) != a.charAt(i-k)) break;
			}
			--k;
			if(k > -1){
//				int length = 2*k+1;
				int id = i-k;
				String palin = a.substring(i-k, i+k+1);
				if(palin.length() > max.length()){
					max = palin;
					mid = id;
				}else if(palin.length() == max.length() && id < mid){
					max = palin;
					mid = id;
				}
			}
			
			// checking even palindromes
			k = 1;
			for(k = 1; ; ++k){
				if((i+k) >= a.length() || (i-k+1) < 0) break;
				if(a.charAt(i+k) != a.charAt(i-k+1)) break;
			}
			--k;
			if(k > 0){
//				int length = 2*k;
				int id = i-k+1;
				String palin = a.substring(i-k+1, i+k+1);
				if(palin.length() > max.length()){
					max = palin;
					mid = id;
				}else if(palin.length() == max.length() && id < mid){
					max = palin;
					mid = id;
				}
			}
		}
		
		return max;
	}
	
	public static void test(){
		LongestPalindromenew lp = new LongestPalindromenew();
		System.out.println(lp.longestPalindrome("ac"));
	}
}
