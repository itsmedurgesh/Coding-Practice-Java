package cormen;

public class CountInversion {
	public static int invs = 0;

	public static void mergesort(int[] a){
		int[] helper = new int[a.length];
		mergesort(a,  helper, 0, a.length-1);
	}

	public static void mergesort(int[] a, int[] helper, int start, int end){
		if(start >= end) return;
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
					invs += (mid - leftid + 1);	/* if an element from right side is smaller than an
					element from left side than it is smaller than all the elements after that
					element in the left side array and hence number of inversions are
					mid - leftid + 1
					*/
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
		int[] a = {3,4,8,1,2};
		mergesort(a);
		for(int i: a){
			System.out.print(i + "> ");
		}
		
		System.out.println("inversions: "+ invs);
	}

}
