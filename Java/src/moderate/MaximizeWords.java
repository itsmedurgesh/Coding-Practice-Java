package moderate;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximizeWords {
	
	private class Node{
		int start;
		boolean c = true;
		int waste;
		ArrayList<String> ss = new ArrayList<String>();
	}
	
	HashMap<Character, Integer> sh = new HashMap<Character, Integer>();
	HashMap<String, Integer> wh = new HashMap<String, Integer>();
	
	public void addwords(String s){
		if(!sh.containsKey(s.charAt(0)))
			sh.put(s.charAt(0), 1);
		
		wh.put(s, 1);
	}
	
	public void getMaxWords(String s){
		int waste = 0;
		int wstart = 0;
		ArrayList<Node> l = new ArrayList<Node>();
		StringBuffer res = new StringBuffer();
		
		boolean cont = false;
		
		for(int i=0; i<s.length(); i++){
			if(!cont){
				if(!sh.containsKey(s.charAt(i))){
					waste++;
					res.append(Character.toUpperCase(s.charAt(i)));
				}
				else{
					cont = true;
				}
			}
			if(cont){

				if(sh.containsKey(s.charAt(i))){
					Node t = new Node();
					t.start = i;
					t.waste = wstart;
					l.add(t);
				}
				
				cont = false;
				for(int j=0; j<l.size(); j++){
					if(!l.get(j).c){
						if(sh.containsKey(s.charAt(i))){
							l.get(j).c = true;
							l.get(j).start = i;
						}else
							l.get(j).waste++;							
					}
					if(wh.containsKey(s.substring(l.get(j).start, i+1))){
						l.get(j).ss.add(s.substring(l.get(j).start, i+1));
						l.get(j).c = false;
					}
					
					if(l.get(j).c)
						cont = true;
				}
				
				if(!cont){
					wstart = 0;
					int min = Integer.MAX_VALUE;
					int minid = 0;
					for(int j=0; j<l.size(); j++){
						if(l.get(j).waste < min){
							min = l.get(j).waste;
							minid = j;
						}							
					}
					for(int k=0; k<l.get(minid).ss.size(); k++){
							res.append(l.get(minid).ss.get(k));
							res.append(" ");
							waste += l.get(minid).waste;
					}
					
					//for(int k = l.size()-1; l>-1; l--)
						l.removeAll(l);
				}
				wstart++;
			}
			
		}
		
		System.out.println(res.toString());
		System.out.println("waste: "+ waste);		
	}
	
	public static void test(){
		MaximizeWords m = new MaximizeWords();
		m.addwords("looked");
		m.addwords("like");
		m.addwords("her");
		m.addwords("just");
		m.addwords("brother");
		
		m.getMaxWords("jesslookedjustliketimherbrother");
	}
}
