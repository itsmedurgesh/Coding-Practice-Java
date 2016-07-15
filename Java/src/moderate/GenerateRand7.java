package moderate;

import java.util.Random;

public class GenerateRand7 {
	public static int rand7(){
		Random rand = new Random();
//		rand.setSeed(System.currentTimeMillis());
		
		int res;
		do{
			res = 5*rand.nextInt(5) + rand.nextInt(5);
		}while(res > 21);
		
		return res%7;
	}
	
	public static int rand7_(){
		Random rand = new Random();
		int[][] a = {{0,1,2,3,4},{5,6,0,1,2},{3,4,5,6,0},{1,2,3,4,5},{6,7,7,7,7}};
		int i;
		int j;
		int res;
		do{
			i = rand.nextInt(5);
			j = rand.nextInt(5);
			res = a[i][j];
		}while(res == 7);
		return res;
	}
	
	public static void test(){
		int[] a = new int[7];
		
		for(int i=0; i<7000; i++)
			a[rand7_()]++;
		
		for(int x:a)
			System.out.println(x);
		
	}
}
