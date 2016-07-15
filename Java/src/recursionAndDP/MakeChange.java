package recursionAndDP;

public class MakeChange {
	public static int change(int n, int denom){
		int next = 0;
		int ways = 0;
		switch(denom){
		case 25:
			next = 10;
			break;
		case 10:
			next = 5;
			break;
		case 5:
			next = 1;
			break;
		case 1:
			return 1;
		
		}
		
		for(int i=0; i*denom <= n; i++){
			ways += change(n - i*denom, next);
		}
		return ways;
		
	}
	
	public static void test(){
		System.out.println("total ways: " + change(20,25));
	}
}
