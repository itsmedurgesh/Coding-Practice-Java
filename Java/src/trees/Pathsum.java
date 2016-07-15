package trees;

import java.util.ArrayList;

import newDatatypes.Node;

public class Pathsum {
	Node root;
	ArrayList<Node> l = new ArrayList<Node>();
	
	Pathsum(Node t){
		root = t;
		//l.add(root);
	}
	
	public void printpath(Node r, int s){
		if(r == null) return;
		l.add(r);
		checksum(s);
		printpath(r.left, s);
		printpath(r.right, s);
		l.remove(r);		
	}
	
	public void checksum(int s){
		int sum = 0;
		for(int i = l.size()-1; i>=0; i--){
			sum += l.get(i).data;
			if(sum == s){
				for(int j = i; j<l.size(); j++){
					System.out.print("> " + l.get(j).data);
				}
				System.out.println(" ");
			}
		}
	}
	
	public static void test(){
		Node r = new Node(5);
		r.left = new Node(6);
		r.right = new Node(7);
		r.left.left =  new Node(3);
		r.left.right = new Node(2);
		r.left.right.left = new Node(1);
		r.left.right.right = new Node(8);
		r.right.left = new Node(-3);
				
		Pathsum ps = new Pathsum(r);
		
		ps.printpath(r, 9);
	}
}
