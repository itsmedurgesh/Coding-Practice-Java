package moderate;

import java.util.ArrayList;

public class MinimizeWaste {
	
	// to hold the dictionary
	private class SS{
		ArrayList<String> ss = new ArrayList<String>();
	}	
	
	//to hold the temporary results
	@SuppressWarnings("unused")
	private class res{
		boolean c = true;
		StringBuffer sb = new StringBuffer();
		int w = 0;
	}
	
	//-----------------------------------------
	SS[] head = new SS[26];
	ArrayList<res> r;
	int gw = 0;
	String gs = "";
	
	void addwords(String s){
		if(head[s.charAt(0)-'a'] == null){
			head[s.charAt(0)-'a'] = new SS();
		}
		head[s.charAt(0)-'a'].ss.add(s);
	}
	
	boolean starts(char c){
		return (head[c-'a']!=null);
	}
	
	ArrayList<String> gets(char c){
		return head[c-'a'].ss;
	}

	// left for later
	void getresult(String s){
//		boolean cont = false;
		
		for(int i=0; i<s.length(); i++){
			if(starts(s.charAt(i))){
				for(String p : gets(s.charAt(i))){
					if(i+p.length() < s.length())
						if(p.compareTo(s.substring(i, i+p.length())) == 0){
							if(r == null){
//								rnew reslist();
//								res.sb.append(p);
							}
						}
				}
			}
		}
	}
	
	
	// recursive implementation for getting minimum wastage
	int minwaste(String s){
		if(s.length() == 0) return 0;
		
		int m1 = Integer.MAX_VALUE, m2;
		if(starts(s.charAt(0))){
			for(String p : gets(s.charAt(0))){
				if(p.length() <= s.length()){
					if(p.compareTo(s.substring(0, p.length())) == 0){
						m1 = minwaste(s.substring(p.length()));						
					}
				}
			}
		}
		
		m2 = 1 + minwaste(s.substring(1));
		
		return (m1 < m2) ? m1 : m2;
	}
	
	
	public static void test(){
//		String a = "durgesh";
		MinimizeWaste m = new MinimizeWaste();
		m.addwords("looked");
		m.addwords("like");
		m.addwords("her");
		m.addwords("just");
		m.addwords("brother");
		
		
		System.out.println("minimum wastage is " + m.minwaste("jesslookedjustliketimherbrotherholalike"));
	}
}
