package others;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
		public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
			 ArrayList<Integer> result = new ArrayList<Integer>();
			 // Populate result;
			 int row = a.size();
			 int col = a.get(0).size();
			 int t = 0, b = row-1, l = 0, r = col-1;
			 int dir = 0;
//	 		 System.out.println("row: "+row+"col: "+col);
			 
			 while(l<=r && t<=b){
				 if(dir==0){
					 for(int i=l; i<=r; i++)
						 result.add(a.get(t).get(i));
					 t++;
				 }
				 else if(dir==1){
					 for(int i=t; i<=b; i++)
						 result.add(a.get(i).get(r));
					 r--;
				 }
				 else if(dir==2){
					 for(int i=r; i>=l; i--)
						 result.add(a.get(b).get(i));
					 b--;
				 }
				 else if(dir==3){
					 for(int i=b; i>=t; i--)
						 result.add(a.get(i).get(l));
					 l++;
				 }
				 
				 dir = (dir+1)%4;
			 }
			 	
			 return result;
		}
	public static void test(){
		List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l;
		l = new ArrayList<Integer>();
		l.add(44);
		a.add(l);
		
		l = new ArrayList<Integer>();
		l.add(36);
		a.add(l);
		
		l = new ArrayList<Integer>();
		l.add(395);
		a.add(l);
		
		l = new ArrayList<Integer>();
		l.add(179);
		a.add(l);
		
		l = new ArrayList<Integer>();
		l.add(249);
		a.add(l);
		
		l = new ArrayList<Integer>();
		l.add(349);
		a.add(l);
		
		l = new ArrayList<Integer>();
		l.add(5);
		a.add(l);
		
		l = new ArrayList<Integer>();
		l.add(139);
		a.add(l);
		
		ArrayList<Integer> res = spiralOrder(a);
		
		for(Integer i: res)
			System.out.print(i + "> ");
		
		
	}
}
