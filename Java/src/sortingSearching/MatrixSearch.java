package sortingSearching;

import newDatatypes.Point;

public class MatrixSearch {
	private static class Diagresult{
		int p1x, p1y, p2x, p2y;
		boolean ondiag = false;
	}
	
	public static Point search(int[][] a, int k){
		int cols = a[0].length;
		int rows = a.length;
		//if(k < a[0][0] || k > a[rows-1][cols-1]) return -1;
		
		return search(a, 0, 0, rows-1, cols-1, k);
	}
	
	public static Point search(int[][] a, int x1, int y1, int x2, int y2, int k){
		if(k < a[x1][y1] || k > a[x2][y2]) return new Point(-1,-1);
		
		boolean lessrows = ((x2-x1)<(y2-y1));
		int dist = lessrows ? (x2-x1) : (y2-y1);
		
		int dx = x1+dist;
		int dy = y1+dist;
		
		if(a[dx][dy] < k){
			return lessrows ? search(a, x1, dy+1, x2, y2, k) : search(a, dx+1, y1, x2, y2, k);
		}
		
		
		Diagresult ds = searchdiag(a, x1, y1, dx, dy, k);
		Point p;
		
		if(ds.ondiag) return new Point(ds.p1x, ds.p1y);
		else{
			p = search(a, ds.p2x, y1, x2, ds.p1y, k);
			if(p.x == -1 && p.y == -1)
				p = search(a, x1, ds.p2y, ds.p1x, y2, k);
		}
		
		return p;		
		
	}

	private static Diagresult searchdiag(int[][] a, int x1, int y1, int dx, int dy, int k) {
		// TODO Auto-generated method stub
		int mx = (x1+dx)/2;
		int my = (y1+dy)/2;
		Diagresult ds = new Diagresult();
		
		if(k == a[mx][my]){
			ds.ondiag = true;
			ds.p1x = mx;
			ds.p1y = my;
			return ds;
		}
		
		else if(k == a[mx-1][my-1]){
			ds.ondiag = true;
			ds.p1x = mx-1;
			ds.p1y = my-1;
			return ds;
		}
		
		else if(k == a[mx+1][my+1]){
			ds.ondiag = true;
			ds.p1x = mx+1;
			ds.p1y = my+1;
			return ds;
		}
		
		else if(k > a[mx][my] && k <= a[mx+1][my+1]){
			ds.ondiag = false;
			ds.p1x = mx;
			ds.p1y = my;
			ds.p2x = mx+1;
			ds.p2y = my+1;
			return ds;
		}
		
		else if(k > a[mx-1][my-1] && k <= a[mx][my]){
			ds.ondiag = false;
			ds.p1x = mx-1;
			ds.p1y = my-1;
			ds.p2x = mx;
			ds.p2y = my;
			return ds;
		}
		
		if(k < a[mx-1][my-1])
			return searchdiag(a, x1, y1, mx-1, my-1, k);
		if(k > a[mx+1][my+1])
			return searchdiag(a, mx+1, my+1, dx, dy, k);
		
		return null;		
	}
	
	public static void test(){
		int a[][] = {{15,20,70,85}, {25,35,80,95}, {30,55,95,105}, {40,80,120,120}};
		Point p = search(a, 105);
		System.out.println(p.x + ", "+ p.y);
				
	}
}
