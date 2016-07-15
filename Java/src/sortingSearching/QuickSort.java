package sortingSearching;

public class QuickSort {
	static void quicksort(int[] a){
		quicksort(a, 0, a.length-1);
	}
	
	static void quicksort(int[] a, int start, int end){
		int pidx = partition(a, start, end);
		if(start < pidx-1)
			quicksort(a, start, pidx-1);
		if(pidx < end)
			quicksort(a, pidx, end);
	}
	
	static int partition(int[] a, int start, int end){
		int pivot = a[(start+end)/2];
		while(start<=end){
			while(a[start] < pivot) start++;
			while(a[end] > pivot) end--;
			if(start<=end){
				int t = a[start];
				a[start] = a[end];
				a[end] = t;
				start++;
				end--;
			}
		}
		return start;
	}
	
	public static void test(){
		int[] a = {32,3,1,5,34,565,23,67,89};
		quicksort(a);
		for(int i: a){
			System.out.print(i + "> ");
		}
	}
}
