package sortingSearching;

import java.util.Random;

public class SelectionRankSort {
	public static int getrank(int[] a, int left, int right, int rank){
		int pivot = a[randomint(left, right)];
		
		int leftend = partition(a, left, right, pivot);
		int leftsize = leftend - left + 1;
		
		if(leftsize == rank+1)
			return max(a, left, leftend);
		else if(rank < leftsize)
			return getrank(a, left, leftend, rank);
		else
			return getrank(a, leftend +1, right, rank - leftsize);
	
	}

	private static int max(int[] a, int left, int leftend) {
		// TODO Auto-generated method stub
		int max = a[left];
		for(int i=left+1; i<= leftend; i++)
			if(a[i]>max)
				max = a[i];
		
		return max;
	}

	private static int partition(int[] a, int left, int right, int pivot) {
		// TODO Auto-generated method stub
		while(true){
			while(left<=right && a[left]<=pivot)
				left++;
			while(left<=right && a[right]>pivot)
				right--;
			
			if(left>right)
				return left-1;
			int t = a[left];
			a[left] = a[right];
			a[right] = t;
		}
	}

	private static int randomint(int left, int right) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		return left + rand.nextInt(right-left);
	}
	
	public static void test(){
		int[] a = {4,67,8,9,3,1,6,98,34,257};
		System.out.println(getrank(a,0,a.length-1, 5));
	}
}
