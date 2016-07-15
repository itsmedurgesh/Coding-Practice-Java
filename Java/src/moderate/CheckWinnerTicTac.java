package moderate;

public class CheckWinnerTicTac {
	public static int checkWinwner(int[][] b){
				
		for(int i=0; i<3; i++){
			// row check
			if(b[i][0] != 0 && b[i][0] == b[i][1] && b[i][0] == b[i][1] && b[i][0] == b[i][2])
				return b[i][0];
			
			//column check
			if(b[0][i] != 0 && b[0][i] == b[1][i] && b[0][i] == b[1][i] && b[0][i] == b[2][i])
				return b[0][i];	
		}
		
		if(b[0][0]!=0 && b[1][1]==b[0][0] && b[2][2]==b[0][0])
			return b[0][0];
		
		if(b[2][0]!=0 && b[1][1]==b[2][0] && b[0][2]==b[2][0])
			return b[2][0];
		
		return 0;		
	}
	
	public static void test(){
		int[][] a = {{1,0,2},
		{1,2,2},
		{2,2,1}};
		
		System.out.println("winner is: "+checkWinwner(a));
	}
}
