package moderate;

import java.util.HashMap;

public class PairIntsWithGivenSum {
	HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
	
	//pair can share a number
	public int getpairs(int[] a, int sum){
		int pairs = 0;
		for(int i=0; i<a.length; i++){
			if(h.containsKey(sum-a[i])){
				pairs +=h.get(sum-a[i]);
			}
			if(h.containsKey(a[i]))
				h.put(a[i], h.get(a[i])+1);
			else
				h.put(a[i], 1);
		}
		return pairs;
	}
	
	//if pairs can't share a number
	public int getpairsnotshared(int[] a, int sum){
		int pairs = 0;
		for(int i=0; i<a.length; i++){
			if(h.containsKey(sum-a[i]) && h.get(sum-a[i]) > 0){
				pairs++;
				h.put((sum-a[i]), 0);
			}
			else
				h.put(a[i], 1);
		}
		
		return pairs;
	}
	
	/* another method is to sort the array and walk the array from both sides
	 * and finding complimentary numbers as we go along until we cross each other
	 * this will take O(n log n) at least
	 */
	
	public static void test(){
		int[] a = {2,3,3,3,2,4,2,1};
		PairIntsWithGivenSum p = new PairIntsWithGivenSum();
		System.out.println(p.getpairs(a, 5));
		System.out.println(p.getpairsnotshared(a, 5));
	}
}
