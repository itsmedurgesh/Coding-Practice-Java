package sortingSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
/* implementing Comparator allows us use directly in arrays using new comparison method
 * 
 */
public class Anagram implements Comparator<String>{
	public String sortedChars(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return sortedChars(o1).compareTo(sortedChars(o2));
	}
	
	public void segregate(String[] s){
		HashMap<String, LinkedList<String>> h = new HashMap<String, LinkedList<String>>();
		for(String ss: s){
			if(h.containsKey(sortedChars(ss))){
				h.get(sortedChars(ss)).add(ss);
			}
			else{
				LinkedList<String> l = new LinkedList<String>();
				l.add(ss);
				h.put(sortedChars(ss), l);
			}
		}
		
		int i=0;
		for(String key: h.keySet()){
			for(String ss: h.get(key)){
				s[i++] = ss;
			}
		}
		
	}
	
	public static void test(){
		String[] s = {"durgesh",
				"choudhary",
				"dureghs",
				"aab",
				"aba",
				"baa"};
		Arrays.sort(s, new Anagram());
//		new Anagram().segregate(s);
		for(String ss: s)
			System.out.println(ss);
	}
}
