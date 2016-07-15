package moderate;

public class ZerosInFactorial {
	public static int countzeros(int n){
		int count=0;
		for(int i=5; n/i > 0; i*= 5)
			count += n/i;
		return count;
	}
	
	public static void test(){
		System.out.println("# of zeros: "+ countzeros(2000));
	}
}
