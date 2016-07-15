package recursionAndDP;

import java.util.ArrayList;

public class Place8Queens {
	byte[][] board = new byte[8][8];
	
	public void print(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				System.out.print(" " + board[i][j]);
			}
			System.out.println(" ");
		}
	}
	
	public void placequeen(){
		int i=0,j=0;
		for(int k=0;k<8;k++){
			board[i][j] = 1;
			j++;
			i += 2;
			if(i>=8) i=1;

		}
	}
	
	public void placequeennew(int row, int[]cols, ArrayList<int[]> result){
		if(row == 8) result.add(cols.clone());
		else{
			for(int col=0; col<8; col++){
				if(checkvalid(cols, row, col)){
					cols[row] = col;
					placequeennew(row+1, cols, result);
				}
			}
		}
	}
	
	private boolean checkvalid(int[] cols, int row, int col) {
		// TODO Auto-generated method stub
		for(int row2=0; row2<row; row2++){
			int col2 = cols[row2];
			
			if(col2 == col) return false;
			
			int coldistance = Math.abs(col2-col);
			int rowdistance = row-row2;
			if(rowdistance == coldistance)
				return false;
		}
		return true;
	}

	public boolean verify(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(board[i][j]==1){
					//check rows
					for(int p=0;p<8;p++)
						if(board[p][j] == 1 && p!=i)
							return false;
					//check column
					for(int q=0;q<8;q++)
						if(board[i][q]==1 && q!=j)
							return false;
//					//check diagonal
					for(int r=1;r<8;r++){
						if((i+r)<8 && (j+r)<8)
							if(board[i+r][j+r] == 1)
								return false;
						if((i-r)>-1 && (j-r)>-1)
							if(board[i-r][j-r]==1)
								return false;
						
						if((i+r)<8 && (j-r)>-1)
							if(board[i+r][j-r]==1)
								return false;
						if((i-r)>-1 && (j+r)<8)
							if(board[i-r][j+r]==1)
								return false;
					}
				}
			}
		}
		return true;
	}
	
	
	public static void test(){
		Place8Queens b = new Place8Queens();
//		b.print();
//		b.placequeen();
//		System.out.println("===========================" + b.verify());
//		b.print();
		
		ArrayList<int[]> a = new ArrayList<int[]>();
		int[] col = new int[8];
		b.placequeennew(0, col, a);
		
		for(int[] p: a){
			for(int q:p){
				System.out.print(" " + q);
			}
			
		}
		
		
	}
}
