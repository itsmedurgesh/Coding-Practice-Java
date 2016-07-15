package others;

public class ArrayRotate {
	public static void reverse(int[] a, int start, int end){
		while(start<end){
			int tmp = a[start];
			a[start]=a[end];
			a[end]=tmp;
			start++;
			end--;
		}
	}
	
	public static void rotate(int[] a, int k){
		reverse(a, 0, k-1);
		reverse(a, k, a.length-1);
		reverse(a, 0, a.length-1);
	}
	
	public static void test(){
		int[] a = {5,1,4,6,8,0,5,3,1};
		rotate(a, 3);
		for(int b:a)
			System.out.print(b+"> ");
	}
}
