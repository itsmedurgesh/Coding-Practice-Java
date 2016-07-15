package trees;
import newDatatypes.Node;

public class CommonAncestor {
	public static boolean isInTree(Node root, Node node){
		if(root == null) return false;
		if(root.data == node.data) return true;
		if(root.left == null && root.right == null) return false;
		
		return isInTree(root.left, node) || isInTree(root.right, node);
	}
	
	public static Node findCommonAncester(Node root, Node p, Node q){
		if(!isInTree(root,p) || !isInTree(root,q)) return null;
		
		if(root.data == p.data || root.data == q.data) return root;
		
		boolean pinLeftTree = isInTree(root.left, p);
		boolean qinLeftTree = isInTree(root.left, q);
		boolean pinRightTree = isInTree(root.right, p);
		boolean qinRightTree = isInTree(root.right, q);
		
		if((pinLeftTree && qinRightTree) || (pinRightTree && qinLeftTree)) 
			return root;
		if(pinLeftTree && qinLeftTree)
			return findCommonAncester(root.left, p, q);
		if(pinRightTree && qinRightTree)
			return findCommonAncester(root.right, p, q);
		
		return null;
	}
	
	public static void test(){
		Node root = new Node(5);
		root.left = new Node(7);
		root.right = new Node(6);
		Node r = new Node(8);
		root.left.left = r;
		Node p = new Node(9);
		root.left.right = p;
		Node q = new Node(11);
		root.left.right.left = new Node(10);
		root.left.right.right = q;
		
		
		Node t = findCommonAncester(root, r, q);
		System.out.println(t.data);
	}
}
