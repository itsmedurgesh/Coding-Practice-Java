package moderate;

import newDatatypes.Node;

public class BiNode {
	private static class Ends{
		Node start=null, end=null;
	}
	public static Ends getDList(Node root){
		
		if(root == null) return null;
		
		Ends leftres = getDList(root.left);
		Ends rightres = getDList(root.right);
		
		Ends res = new Ends();
		
		if(leftres == null)
			res.start = root;
		else{
			res.start = leftres.start;
			leftres.end.right = root;
			root.left = leftres.end;
		}
		
		if(rightres == null)
			res.end = root;
		else{
			res.end = rightres.end;
			rightres.start.left = root;
			root.right = rightres.start;
		}
		
		return res;
	}
	
	public static void test(){
		Node root = new Node(10);
		//making tree
		root.left = new Node(8);
		root.left.left = new Node(6);
		root.left.right = new Node(9);
		root.left.left.left = new Node(5);
		root.right = new Node(12);
		root.right.right = new Node(15);
		root.right.left = new Node(11);
		
		
		
//		Node start = null, end = null;
		Ends res = getDList(root);
//		System.out.println(res.start.data);
		Node t = res.start;
		while(t != null){
			System.out.print(t.data + " > ");
			t = t.right;
		}
	}
}
