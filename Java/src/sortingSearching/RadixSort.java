package sortingSearching;

import java.util.LinkedList;

public class RadixSort {
	public static void radixsort(int[] a){
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] q = new LinkedList[10];
		boolean flag = false;
		int p=1;
		int x, qidx;
		
		do {
			
			flag = false;
			//enqueue part
			for (int i = 0; i < a.length; i++) {
				x = a[i] / p;
				qidx = x % 10;
				if (q[qidx] == null)
					q[qidx] = new LinkedList<Integer>();
				q[qidx].add(a[i]);
			}
			//dequeue part
			int aidx = 0;
			for (int i = 0; i < 10; i++) {
				while (q[i] != null && !q[i].isEmpty()) {
					a[aidx++] = q[i].poll();
				}
			}
			p *= 10;
			for(int i : a){
				if((i/p)%10 != 0){
					flag = true;
					continue;
				}
			}
			
		} while (flag);
	}
	
	public static void test(){
		int[] a = {32,3,1,5,34,565,23,67,89,45};
		radixsort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + "> ");
		}
	}
	
}
