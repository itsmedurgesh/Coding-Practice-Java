package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SplitArrayWithSameAverage {
	
	
	static boolean possible(int id, int length, int sum1, ArrayList<Integer> res1, 
			ArrayList<Integer> a, ArrayList<ArrayList<ArrayList<Boolean>>> dp){
		if(length == 0) return sum1 == 0;
		if(id >= a.size()) return false;
		
		if(dp.get(id).get(sum1).get(length) == true) return true;
		
		if(sum1 >= a.get(id)){
			res1.add(a.get(id));
			if(possible(id+1, length-1, sum1-a.get(id), res1, a, dp)) return true;
			res1.remove(res1.size()-1);
		}
		
		if(possible(id+1, length, sum1, res1, a, dp)) return true;
		
		dp.get(id).get(sum1).set(length, true);
		return false;
	}
	
	public static ArrayList<ArrayList<Integer>> getSplits(ArrayList<Integer> a){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		if(a.size() <= 1) return res;
		
		int sum = 0;
		for(Integer i : a) sum += i;
		
		/* this line is excluded because the condition is not required always*/
		//if(sum%2 == 1) return res; // sum is not even
		
		Collections.sort(a);
		
		ArrayList<Integer> res1 = new ArrayList<Integer>();
		ArrayList<Integer> res2 = new ArrayList<Integer>();
		ArrayList<ArrayList<ArrayList<Boolean>>> dp = new ArrayList<ArrayList<ArrayList<Boolean>>>();
		for(int i = 0; i < a.size(); ++i){
			dp.add(new ArrayList<ArrayList<Boolean>>());
			for(int j = 0; j <= sum; ++j){
				dp.get(i).add(new ArrayList<Boolean>());
				for(int k = 0; k < a.size(); ++k){
					dp.get(i).get(j).add(false);
				}
			}
		}
		int total = a.size();
		for(int i = 1; i < total; ++i){
			if(sum*i % total != 0) continue;
			int sum1 = sum*i / total;
			if(possible(0, i, sum1, res1, a, dp)){
				int p1 = 0, p2 = 0;
				while(p1 < res1.size() && p2 < total){
					if(res1.get(p1) == a.get(p2)){
						++p1;
						++p2;
					}
					else{
						res2.add(a.get(p2));
						++p2;
					}
				}
				while(p2 < total) res2.add(a.get(p2++));
				res.add(res1);
				res.add(res2);
				return res;
			}
		}
		res.add(new ArrayList<Integer>());
		res.add(new ArrayList<Integer>());
		return res;
	}
	
	public static void test(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(47, 14, 30, 19, 30, 4, 32, 32, 15, 2, 6, 24));
		ArrayList<ArrayList<Integer>> res = getSplits(a);
		for(Integer i : res.get(0)) System.out.print(i + " ");
		System.out.println();
		for(Integer i : res.get(1)) System.out.print(i + " ");
	}
}
