package trees;
import java.util.ArrayList;
import java.util.HashMap;

import newDatatypes.Point;
import newDatatypes.Line;
public class CommonLine {
	ArrayList<Point> points = new ArrayList<Point>();
	HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
	
	public Line findCommon(){
		Point a,b;
		Line l;
		int bestcount = 0;
		Line bestline = null;
		
		for(int i=0; i<points.size(); i++){
			for(int j=i+1; j<points.size(); j++){
				a = points.get(i);
				b = points.get(j);
				l = new Line(a,b);
				if(!h.containsKey(l.m)){
					h.put(l.m, 1);
				}
				else{
					int val = h.get(l.m);
					val++;
					if(val > bestcount){
						bestcount = val;
						bestline = l;
					}
					
					h.put(l.m, val);
				}
			}
		}
		return bestline;
	}
	
	public static void test(){
		CommonLine c = new CommonLine();
		c.points.add(new Point(2,2));
		c.points.add(new Point(3,3));
		c.points.add(new Point(7,2));
		c.points.add(new Point(4,4));
		c.points.add(new Point(8,8));
		c.points.add(new Point(-9,12));
		c.points.add(new Point(12,12));
		
		Line l = c.findCommon();
		
		if(l!=null)
			System.out.println("common line is m: " + (double)l.m/1000 + " c: " + (double)l.c/1000);
	}
}
