package sortingSearching;

import java.util.ArrayList;

public class LongestIncreasingSubsquesnce {
	public static ArrayList<Integer> getSubsequence(ArrayList<Integer> a){
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> bestsol=null;
		
		for(int i: a){
			bestsol = buildsolution(i, sol);
		}
		
		return bestsol;
	}

	private static ArrayList<Integer> buildsolution(int i, ArrayList<ArrayList<Integer>> sol) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> bestsol=null;
		ArrayList<ArrayList<Integer>> newsols = new ArrayList<ArrayList<Integer>>(); 
		
		if(sol.isEmpty()){
			ArrayList<Integer> t = new ArrayList<Integer>();
			t.add(i);
			sol.add(t);
		}
		else{
			boolean found = false;
			for(ArrayList<Integer> t: sol){
				if(t.get(t.size()-1) <= i){
					found = true;
//					t.add(i);
					@SuppressWarnings("unchecked")
					ArrayList<Integer> t1 = (ArrayList<Integer>) t.clone();
					t1.add(i);
					newsols.add(t1);
					if(bestsol == null || bestsol.size() < t1.size())
						bestsol = t1;
				}
				/*
				 * this part is added so if last element is smaller than current last element
				 * but bigger than others we replace current last element without increasing 
				 * the length but this increases possibility of this list growing more
				 */
//				else if(t.size()>2 && t.get(t.size()-2) <= i){
//					found = true;
//					t.remove(t.size()-1);
//					t.add(i);
//					if(bestsol == null || bestsol.size() < t.size())
//						bestsol = t;
//				}
				
//				if(bestsol == null || bestsol.size() < t.size())
//					bestsol = t;
			}
			if(!found){
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(i);
				sol.add(t);
			}
			/* this is because we can not modify the list we are iterating
			 * 
			 */
			for(ArrayList<Integer> t: newsols){
				sol.add(t);
			}
			
		}
		
		return bestsol;
	}
	
	public static void test(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(13);
		a.add(14);
		a.add(10);
		a.add(17);
		a.add(15);
		a.add(16);
		a.add(18);
			
		a = getSubsequence(a);
		
		for(Integer i: a)
			System.out.print(i + "> ");
	}
}
