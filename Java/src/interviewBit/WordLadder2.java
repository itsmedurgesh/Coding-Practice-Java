package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder2 {

	public static void constructpath(String start, String end, HashMap<String, ArrayList<String>> parents, 
			ArrayList<String> current, ArrayList<ArrayList<String>> answer){
		if(start == end){
			answer.add(current);
			return;
		}

		for(int i = 0; i < parents.get(start).size(); ++i){
			current.add(parents.get(start).get(i));
			constructpath(parents.get(start).get(i), end, parents, current, answer);
			current.remove(current.size()-1);
		}
	}
	
	public static ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dictV){
		HashSet<String> dict = new HashSet<String>(dictV);
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		HashMap<String, ArrayList<String>> parents = new HashMap<String, ArrayList<String>>();
		
		// swapping the start and end strings
		String t = start;
		start = end;
		end = t;
		
		dist.put(start, 1);
		
		Queue<String> q = new LinkedList<String>(); 
		q.add(start);
		
		while(!q.isEmpty()){
			String word = q.poll();
			if(word == end) break;
			
			for(int i = 0; i < word.length(); ++i){
				for(int j = 0; j < 26; ++j){
					char[] newchars = word.toCharArray();
					newchars[i] = (char)('a' + j);
					String newword = new String(newchars);
					if(dict.contains(newword)){
						if(!dist.containsKey(newword)){
							dist.put(newword, dist.get(word)+1);
							q.add(newword);
							if(parents.containsKey(newword)){
								parents.get(newword).add(word);
							}
							else{
								ArrayList<String> p = new ArrayList<String>();
								p.add(word);
								parents.put(newword, p);
							}
						}
						else if(dist.get(newword) == dist.get(word)+1){
							if(parents.containsKey(newword)){
								parents.get(newword).add(word);
							}
							else{
								ArrayList<String> p = new ArrayList<String>();
								p.add(word);
								parents.put(newword, p);
							}
						}
					}
				}
			}
			
			
		}
		
		if(!dist.containsKey(end)) return ans;
		ArrayList<String> current = new ArrayList<String>();
		current.add(end);
		constructpath(end, start, parents, current, ans);
		return ans;
	}
	
	public static void test(){
		ArrayList<String> dictV = new ArrayList<String>(Arrays.asList("hit", "cog", "hot","dot","dog","lot","log"));
		
		ArrayList<ArrayList<String>> ans = findLadders("hit", "cog", dictV);
		
		for(ArrayList<String> as : ans){
			for(String s : as){
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
}
