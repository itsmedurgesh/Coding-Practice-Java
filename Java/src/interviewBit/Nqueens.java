package interviewBit;

import java.util.ArrayList;

public class Nqueens {
	static char[][] createboard(int a){
		char[][] res = new char[a][a];
		for(int i = 0; i < a; ++i){
			for(int j = 0; j<a; ++j) res[i][j] = '.';
		}
		
		return res;
	}
	
	static void printboard(char[][] board, int a){
		for(int i = 0; i < a; ++i){			
			for(int j = 0; j<a; ++j) System.out.print(board[i][j]+ " ");
			System.out.println();
		}
	}
	
	static ArrayList<String> convert(char[][] b, int a){
		ArrayList<String> res = new ArrayList<String>();
		for(int i = 0; i < a; ++i){
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j<a; ++j) sb.append(b[i][j]);
			res.add(sb.toString());
			sb.setLength(0);
		}		
		return res;
	}
	
	
	static void printall(ArrayList<ArrayList<String>> res){
		  for(ArrayList<String> b : res){
			  for(String s: b){
				  System.out.println(s);
			  }
			  System.out.println();
		  }
	}
	
	static boolean isvalid(char[][] b, int a, int row, int col){
		
		if(row == a || col == a) return true;
		
		// check same row
		for(int i = 0; i < col; ++i) if(b[row][i] == 'Q') return false;
		
		//check diagonal left down
		for(int i = row+1, j = col-1; i<a && j >-1; ++i, --j)
			if(b[i][j] == 'Q') return false;
		
		//check diagonal left up
		for(int i = row-1, j = col-1; i > -1 && j > -1; --i, --j)
			if(b[i][j] == 'Q') return false;
		
		return true;
	}
	
	static void placequeens(char[][] b, int a, int col, ArrayList<ArrayList<String>> res){
		if(col == a) res.add(convert(b, a));
		
		for(int i = 0; i < a; ++i){
			if(isvalid(b, a, i, col)){
				b[i][col] = 'Q';
				placequeens(b, a, col+1, res);
				b[i][col] = '.';
			}
		}
	}
	public static void test(){
		int a = 1;		
//		printboard(b, 3);
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		for(int i = 0; i<a; ++i){
			char[][] b = createboard(a);
			b[i][0] = 'Q';
			//System.out.println("board " + i);
			//printboard(b, a);
//			if(placequeens(b, a, 1, res)){
//				res.add(convert(b, a));
//			}
			placequeens(b, a, 1, res);
		}
		
		printall(res);
	}
}
