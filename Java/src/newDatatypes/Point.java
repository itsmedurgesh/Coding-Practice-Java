package newDatatypes;

public class Point {
	public int x;
	public int y;
	public Point(int a, int b){
		x = a;
		y = b;
	}
	
	public static double distance(Point a, Point b){
		return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
	}
}
