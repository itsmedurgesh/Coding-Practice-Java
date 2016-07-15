package sortingSearching;

public class HeapSort {
	
	/* this implementation is easier to comprehend as child of a element at i 
	 * are at 2i and 2i+1 and hence we can simply get parent by j = i/2
	 */
	public static int[] buildHeap(int[] a){
		int[] b = new int[a.length +1];
		
		b[1] = a[0];
		for(int i=1; i<a.length; i++){
			b[i+1] = a[i];
			checkOrder(b, i+1);
		}
		
		return b;
	}
	
	public static void inplaceBuildheap(int[] a){
		for(int i=1; i<a.length; i++)
			checkOrderInplace(a, i);
	}
	
	private static void checkOrderInplace(int[] a, int i){
		if(i == 0) return;
		int j = (i-1)/2;
		
		if(a[j]<a[i]){
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
			checkOrderInplace(a, j);
		}
		else 
			return;
		
	}

	// this is building Max Heap and this and can be used for ascending sorting
	private static void checkOrder(int[] a, int i) {
		// TODO Auto-generated method stub
		if(i==0 || i==1) return;
		int j = i/2;
		if(a[j]<a[i]){
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		checkOrder(a, j);
	}
	
	// this sorts the array by using built heap
	private static void sort(int[] a){
		for(int i=a.length-1; i>0; i--){
			swap(a, 0, i);
			reorder(a, 0, i);
		}
	}
	
	private static void reorder(int[] a, int i, int j){
		int p = 2*i + 1;
		int q = 2*i + 2;
		
		if(p >= j) return;
		
		int max = (a[p] > a[q]) ? p : q;
		
		if(q == j) max = p;
		
		if(a[max] > a[i]){
			swap(a, i, max);
			reorder(a, max, j);
		}
		else return;		
	}
	
	private static void swap(int[] a, int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void test(){
		int[] a = {3,4,6,8,54,2,4,7,9,6534};
//		int[] b = buildHeap(a);
		inplaceBuildheap(a);
		sort(a);
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+ "> ");
	}
}
