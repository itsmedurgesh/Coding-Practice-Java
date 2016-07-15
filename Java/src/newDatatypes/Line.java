package newDatatypes;

public class Line {
	public int m, c;
	double epsilon = 1e-8;
	boolean inf_slope;
	
	public Line(int a, int b){
		m = a;
		c = b;
		inf_slope = false;
	}
	
	public Line(Point a, Point b){
		inf_slope = ((b.x - a.x) == 0)? true : false;
		
		if (!inf_slope) {
			m = (int)(((double) b.y - (double) a.y) / ((double) b.x - (double) a.x))*1000;
			c = (int)((double) a.y - (double)(m/1000) * (double) a.x)*1000;
		}
	}
	
	boolean sameLine(Line l){
		//TODO: defering comparison of infinite slope lines
		if(l.inf_slope || inf_slope) return false;
		//return (l.m < m+epsilon && l.m >= m-epsilon) && (l.c < c+epsilon && l.c >= c-epsilon);
		return (l.m == m) && (l.c == c);
	}
	
	boolean parallelLine(Line l){
		if(l.inf_slope || inf_slope) return false;
		//return (l.m < m+epsilon && l.m >= m-epsilon) && !(l.c < c+epsilon && l.c >= c-epsilon);
		return (l.m == m) && (l.c != c);
	}
}
