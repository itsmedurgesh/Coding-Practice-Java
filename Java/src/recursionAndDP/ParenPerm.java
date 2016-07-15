package recursionAndDP;

import java.util.HashSet;
import java.util.Set;

public class ParenPerm {
	public static Set<String> getPerm(int n){
		if(n == 0) return null;
		if(n == 1){
			Set<String> a = new HashSet<String>();
			a.add("()");
			return a;
 		}
		
		Set<String> a = getPerm(n-1);
		Set<String> b = new HashSet<String>();
		for(String s: a){
			for(int i=0; i< s.length(); i++){
				if(s.charAt(i) == '('){
					b.add(s.substring(0, i+1) + "()" + s.substring(i+1));
				}
			}
			b.add("()" + s);
		}
		
		return b;
	}
	
	public static void test(){
		Set<String> a = getPerm(3);
		for(String s: a){
			System.out.println(s);
		}
		System.out.println("total: "+ a.size());
	}
}
