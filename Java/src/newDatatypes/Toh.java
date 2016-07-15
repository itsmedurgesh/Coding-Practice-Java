package newDatatypes;

public class Toh {
	String first = "F", middle = "M", last = "L";
	int disks;
	
	public Toh(int n){
		disks = n;
	}
	
	void move(int n, String first, String middle, String last ){
		if (n == 1)
			System.out.println("move disk "+ n + " from " + first + " to " + last);
		else{
			move(n-1, first, last, middle);
			System.out.println("move disk "+ n + " from " + first + " to " + last);
			move(n-1, middle, first, last);
		}
		
	}
	
	public static void test(){
		Toh t = new Toh(4);
		t.move(4, "F", "M", "L");
	}
}
