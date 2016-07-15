package others;

public class MatrixRotate {
	public static int[][] transpose(int[][] a){
		int rows = a.length;
		int cols = a[0].length;
		
		int[][] b = new int[cols][rows];
		
		for(int i=0; i<rows; i++){
			for(int j = 0 ; j<cols; j++){
				b[j][i] = a[i][j];
			}
		}
		
		return b;
	}
	
	/* this function rotates a square matrix 90 degrees clockwise
	 * 
	 */
	public static void rotate(int[][] a){
		int size = a.length;
		for(int i = 0; i <= (size-1)/2; i++){
			for(int j = i; j < size-i-1; j++){
				int t = a[i][j];
				a[i][j] = a[size-1-j][i];
				a[size-1-j][i] = a[size-1-i][size-1-j];
				a[size-1-i][size-1-j] = a[j][size-1-i];
				a[j][size-1-i] = t;
			}
		}
	}
	
	public static void test(){
		int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		a = transpose(a);
		rotate(a);
		for(int i=0; i<a.length; i++){
			System.out.println("");
			for(int j = 0 ; j<a[0].length; j++){
				System.out.print(a[i][j]+"> ");
			}
		}
	}
}
