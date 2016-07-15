package newDatatypes;

public class Node {
	public int data;
	public Node left, right;
	
	public Node(int d){
		data = d;
		left = null;
		right = null;			
	}
	
	int getval(){
		return data;
	}

}
