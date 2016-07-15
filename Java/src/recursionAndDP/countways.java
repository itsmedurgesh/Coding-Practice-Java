package recursionAndDP;

public class countways {
	public static int countallways(int n){
		if(n<0) return 0;
		if(n==0) return 1;
		
		return countallways(n-1)+countallways(n-2)+countallways(n-3);
	}
	
	static int map[] = new int[1000];
	public static int countallwaysDP(int n){
		
		if(n<0) return 0;
		if(n==0) return 1;
		
		if(map[n] != 0) return map[n];
		//System.out.println("called with n : "+n);
		map[n] = countallwaysDP(n-1)+countallwaysDP(n-2)+countallwaysDP(n-3);
		return map[n];
	}
	
	public static void test(){
		System.out.println("total number of ways: " + countallwaysDP(40));
	}
}
