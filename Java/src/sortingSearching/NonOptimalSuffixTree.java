package sortingSearching;

import java.util.ArrayList;
import java.util.HashMap;

public class NonOptimalSuffixTree {
	SuffixTreeNode root = new SuffixTreeNode();
	
	public void makeTree(String s){
		for(int i=0; i<s.length(); i++){
			root.insert(s.substring(i), i);
		}
	}
	
	public ArrayList<Integer> search(String s){
		return root.search(s);
	}
	//-------------------------------
	
	public static void test(){
		NonOptimalSuffixTree s = new NonOptimalSuffixTree();
		s.makeTree("thisisasamplestringtobeinsertedintosuffixtree");
		
		ArrayList<Integer> a = s.search("ring");
		a.forEach(System.out::println);
	}
	
}

class SuffixTreeNode{
	HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();

	Character val;
	ArrayList<Integer> indices = new ArrayList<Integer>();
	
	public void insert(String s, int i) {
		// TODO Auto-generated method stub
		indices.add(i);
		if(s!= null && s.length()>0){
			val = s.charAt(0);
			SuffixTreeNode child = null;
			if(children.containsKey(val))
				child = children.get(val);
			else{
				child = new SuffixTreeNode();
				children.put(val, child);
			}
			
			child.insert(s.substring(1), i);
		}
	}

	public ArrayList<Integer> search(String s) {
		// TODO Auto-generated method stub
		if(s == null || s.length() == 0)
			return indices;
		
		if(children.containsKey(s.charAt(0)))
			return children.get(s.charAt(0)).search(s.substring(1));
		
		return null;
		
	}
	
}
