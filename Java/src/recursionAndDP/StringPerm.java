package recursionAndDP;

import java.util.ArrayList;

public class StringPerm {
	
	public static ArrayList<String> perms(String s){
		if(s.length() == 0) return null;
		
		if(s.length() == 1){
			ArrayList<String> a = new ArrayList<String>();
			a.add(s);
			return a;
		}
		
		char prefix = s.charAt(0);
		String suffix = s.substring(1);
		
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		
		a = perms(suffix);
		
		for(String str : a){
			for(int i=0; i<= str.length(); i++){
				b.add(str.substring(0, i) + prefix + str.substring(i));
			}
		}
		
		return b;
	}
	
	public static void test(){
		String str = "durgesh";
		ArrayList<String> a = new ArrayList<String>();
		a = perms(str);
		for(String s: a){
			System.out.println(s);
		}
		System.out.println("total: " + a.size());
	}

}
