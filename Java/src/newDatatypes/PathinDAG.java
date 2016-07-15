package newDatatypes;

public class PathinDAG {
	Node root;
	public static boolean checkPath(Node first, Node second){
		if(first == second)
			return true;
		if(first.left != null)
			if(first.left == second)
				return true;
			else
				return checkPath(first.left, second);
		if(first.right != null)
			if(first.right == second)
				return true;
			else 
				return checkPath(first.right, second);
		return false;		
	}
}
