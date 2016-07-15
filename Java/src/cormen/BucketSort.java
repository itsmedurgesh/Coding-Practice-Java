package cormen;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {
	static void insertionSort(ArrayList<Double> a){
		if(a.isEmpty()) return;

		for(int i=1; i<a.size(); ++i){
			Double tmp = a.get(i);
			int j = i-1;
			for(; j>-1; --j){
				if(a.get(j) > tmp){
					a.set(j+1, a.get(j));
				}
				else{
					a.set(j+1, tmp);
					break;
				}
			}			
			if(j == -1) a.set(0, tmp); 
			
		}
	}
	
	static void buckerSort(ArrayList<Double> a){
		ArrayList<ArrayList<Double>> b = new ArrayList<ArrayList<Double>>();
		
		for(int i=0; i<a.size(); ++i)
			b.add(new ArrayList<Double>());
		
		for(int i=0; i<a.size(); ++i)
			b.get((int) Math.floor(a.size()*a.get(i))).add(a.get(i));
		
		for(int i=0; i<b.size(); ++i)
			insertionSort(b.get(i));
		
		a.clear();
		
		int j = 0;
		
		// accumulating all arraylists as one arraylist
		while(true){
			while(b.get(j).isEmpty()) ++j;
			a.addAll(b.get(j));
			++j;
			if(j == b.size()) break;			
		}	
		
	}
	
	public static void test(){
		ArrayList<Double> a = 
				new ArrayList<Double>(Arrays.asList(0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68));
//		a.addAll(Arrays.asList({1,2,3,3}));
		
//		insertionSort(a);
		buckerSort(a);
		// in java arrays are passed by reference and variables are always passed by value
		
		for(Double i: a)
			System.out.print(i + " ");
	}

}
