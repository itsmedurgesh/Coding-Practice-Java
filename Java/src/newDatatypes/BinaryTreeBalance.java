package newDatatypes;

public class BinaryTreeBalance {
	Node root;
	
	public static boolean checkBalance(Node root){
		if(abs(height(root.left) - height(root.right)) <= 1){
			if(root.left != null && root.right != null)
				return checkBalance(root.left) && checkBalance(root.right);
			else return true;
		}
		return false;
	}
	
	public static int abs(int x){
		return x<0?-x:x;
	}
	
	public static int height(Node root){
		if(root == null) return 0;
		if(root.left == null){
			if(root.right == null){
				return 1;
			}
			else{
				return 1 + height(root.right);
			}
		}
		else{
			if(root.right == null){
				return 1 + height(root.left);
			}
			else{
				return height(root.left) > height(root.right) ? (1 + height(root.left)) : (1 + height(root.right));
			}
		}		
		
	}
	
	public static void test(){
		BinaryTreeBalance b = new BinaryTreeBalance();
		b.root = new Node(15);
		b.root.left = new Node(12);
		b.root.left.left = new Node(12);
		b.root.left.left.left = new Node(12);
		b.root.right = new Node(3);
		
		System.out.println("Tree balance is " + checkBalance(b.root));
	}
}
