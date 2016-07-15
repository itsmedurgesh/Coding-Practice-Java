package newDatatypes;

public class NodeforReflection {
	@SuppressWarnings("unused")
	private int data1;
	public int data;
	
	public NodeforReflection(int d){
		data = d;
		data1 = d;			
	}
	
	int getval(){
		return data;
	}

}
