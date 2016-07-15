package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListAnagrams {
	public boolean isAnagram(String a, String b){
        if(a.length() != b.length()) return false;
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i = 0; i < a.length(); ++i){
        	if(!h.containsKey(a.charAt(i))) h.put(a.charAt(i), 1);
        	else h.put(a.charAt(i), h.get(a.charAt(i))+1);
        }
        for(int i = 0; i < b.length(); ++i){
        	if(!h.containsKey(b.charAt(i))|| h.get(b.charAt(i)) == 0){ h.clear(); return false; }
        	else h.put(b.charAt(i), h.get(b.charAt(i))-1);
        }
        
        return true;
    }
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(a.size() == 0) return res;
	    
	    for(int i = 0; i < a.size(); ++i){
	        boolean found = false;
	        for(int j = 0; j < res.size(); ++j){
	            if(isAnagram(a.get(i), a.get(res.get(j).get(0) -1))){ 
	                res.get(j).add(i+1);        
	                found = true;
	                break;
	            }
	        }
	        
	        if(!found){
	            ArrayList<Integer> t = new ArrayList<>();
	            t.add(i+1);
	            res.add(t);
	        }
	        
	    }
	    
	    return res;
	}
	public static void test(){
		ListAnagrams l = new ListAnagrams();
		List<String> ll = new ArrayList<String>();
		ll.addAll(Arrays.asList(
				"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", 
				"abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", 
				"babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", 
				"bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", 
				"abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", 
				"aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", 
				"abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", 
				"aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"));
		ArrayList<ArrayList<Integer>> res = l.anagrams(ll);
		System.out.println(l.isAnagram("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", 
				"abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa"));
	}
}
