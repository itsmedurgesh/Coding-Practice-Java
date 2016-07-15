package hard;

public class LinearTimeSort {
	public static void sort(int[] a){
		for(int i=0; i<a.length; i++){
			if(i != a[i]){
				int t = a[i];
				a[i] = a[a[i]];
				a[a[i]] = t;
			}
		}
	}
	
	public static void test(){
		int[] a = {1,2,5,0,3,4};
		sort(a);
		for(int b:a)
			System.out.print(b +" >");
	}
}
