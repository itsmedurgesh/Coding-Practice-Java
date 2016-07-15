package trees;
import java.util.LinkedList;

import newDatatypes.Node;

public class SubTree {
	LinkedList<Node> l = new LinkedList<Node>();
	Node root;
	
	SubTree(Node r){
		root = r;
		l.add(root);
	}
	
	public Node searchBFS(Node p){
		while(!l.isEmpty()){
			Node h = l.remove();
			if(h.data == p.data)
				return h;
			
			if(h.left != null) l.add(h.left);
			if(h.right != null) l.add(h.right);
		}
		return null;	
	}
	
	public boolean matchTree(Node t1, Node t2){
		
		if(t2 == null) return true;
		 
		if(t1.data == t2.data) 
			return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
		
		return false;
	}
	
	public boolean isMatching(Node t){
		while(true){
			Node matchedRoot = searchBFS(t);
			if(matchedRoot == null) return false;
			
			if(matchTree(matchedRoot, t)) return true;
		}
			
	}
	
	public static void test(){
		Node root = new Node(5);
		root.left = new Node(7);
		root.right = new Node(6);
		root.left.left = new Node(8);
		root.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.left.right.left.left = new Node(12);
		root.left.right.left.right = new Node(13);
		root.left.right.right.left = new Node(16);
		root.left.right.right.right = new Node(17);
		
		
		Node p = new Node(9);
		p.left = new Node(10);
		p.right = new Node(11);
		
		SubTree s = new SubTree(root);
		System.out.println(s.isMatching(p));
	}
}
