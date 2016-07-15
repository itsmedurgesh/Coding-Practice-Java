package recursionAndDP;

public class MoveGrid {
	static int[][] map = new int[100][100]; 
	public static int move(int x, int y){
		if(x < 0 || y < 0) return 0;
		
		if(x == 0 && y == 0) return 1;
		
		if(x == 0) return move(x, y-1);
		if(y == 0) return move(x-1, y);
		return move(x-1, y) + move(x, y-1);
	}
	
	public static int moveDP(int x, int y){
		if(x < 0 || y < 0) return 0;
	
		if(map[x][y] != 0) return map[x][y];
		
		if(x == 0 && y == 0){
			map[0][0] = 1;
			return map[0][0];
		}
		
		if(x == 0){
			map[x][y] = moveDP(x, y-1);
			return map[x][y];
		}
		if(y == 0){
			map[x][y] = moveDP(x-1, y);
			return map[x][y];
		}
		
		map[x][y] = moveDP(x-1, y) + moveDP(x, y-1);
		return map[x][y];
	}
	
	
	public static void test(){
		long time1 = System.nanoTime();
		move(15,15);
		long time2 = System.nanoTime();
		moveDP(15,15);
		long time3 = System.nanoTime();
		
		System.out.println("time taken: "+ (time2-time1) + " and " + (time3-time2));
		//System.out.println("total number of ways: " + moveDP(10,10));
		
	}
}
