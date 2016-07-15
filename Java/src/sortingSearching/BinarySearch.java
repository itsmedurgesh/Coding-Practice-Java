package sortingSearching;

public class BinarySearch {
	public static int search(int[] a, int k){
		//TODO:
		return search(a, 0, a.length-1, k);
	}
	
	public static int search(int[] a, int start, int end, int k){
		if(end < start) return -1;
		if(end == start && a[end]!= k) return -1;
		
		int mid = (start+end)/2;
		if(a[mid]==k) return mid;
		
		if(a[mid]<k)
			return search(a, mid+1, end, k);
		else
			return search(a, start, mid-1, k);
	}
	
	/* if sorted array is rotated
	 * 
	 */
	public static int rotatedSearch(int[] a, int k){
		return rotatedSearch(a, 0, a.length-1, k);
	}
	
	public static int rotatedSearch(int[] a, int start, int end, int k){
		
		int pivot = findpivot(a, start, end);
//		return pivot;
		
		if(k < a[start])
			return search(a, pivot+1, end, k);
		else
			return search(a, start, pivot, k);
	}
	
	private static int findpivot(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		if(end < start) return -1;
		if(end == start) return end;
			
		int mid = (start+end)/2;
		
		if(mid < end && a[mid] > a[mid+1])
			return mid;
		if(mid > start && a[mid] < a[mid-1])
			return mid-1;
		
		if(a[start]>= a[mid])
			return findpivot(a, start, mid-1);
		else
			return findpivot(a, mid+1, end);
		
	}

	public static void test(){
		int[] a = {15,16,17,18,19,10,11};
		int i = rotatedSearch(a, 10);
//		
//		int[] b = {2,3,5,6,7,12,45,78};
//		i = search(b, 13);
		System.out.println(i);
	}
}
