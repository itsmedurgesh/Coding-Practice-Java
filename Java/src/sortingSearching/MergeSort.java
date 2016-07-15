package sortingSearching;

public class MergeSort {
	public static void mergesort(int[] a){
		int[] helper = new int[a.length];
		mergesort(a,helper, 0, a.length-1);
	}
	
	public static void mergesort(int[] a, int[] helper, int start, int end){
		if(end <= start) return;
 		
		int mid = (start+end)/2;
		mergesort(a, helper, start, mid);
		mergesort(a, helper, mid+1, end);
		merge(a, helper, start, mid, end);
	}
	
	public static void merge(int[] a, int[] helper, int start, int mid, int end){
		for(int i=start; i<= end; i++)
			helper[i] = a[i];
		
		int leftid = start;
		int rightid = mid+1;
		
		for(int i=start; i<=end; i++){
			if(leftid <= mid && rightid <= end){
				if(helper[leftid]<helper[rightid]){
					a[i] = helper[leftid++];
				}
				else{
					a[i] = helper[rightid++];
				}
			}
			else if(leftid > mid){
				a[i] = helper[rightid++];
			}
			else{
				a[i] = helper[leftid++];
			}
		}
	}
	
	public static void test(){
		int[] a = {32,3,1,5,34,565,23,67,89};
		mergesort(a);
		for(int i: a){
			System.out.print(i + "> ");
		}
	}
}
