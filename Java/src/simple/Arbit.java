package simple;

import java.util.ArrayList;

public class Arbit {
	static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
        
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
	}
	
	public static void test(){
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a =new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		
		A.add(a);
		
		a =new ArrayList<Integer>();
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		
		A.add(a);
		
		a =new ArrayList<Integer>();
		a.add(9);
		a.add(10);
		a.add(11);
		a.add(12);
		
		A.add(a);
		
		ArrayList<ArrayList<Integer>> B = performOps(A);
		for (int i = 0; i < B.size(); i++) {
		    for (int j = 0; j < B.get(i).size(); j++) {
		            System.out.print(B.get(i).get(j) + " ");
		    }
		}
	}
}
