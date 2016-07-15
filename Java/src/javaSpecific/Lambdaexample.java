package javaSpecific;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambdaexample {
	public static void test(){
		List<Integer> a = (List<Integer>) Arrays.asList(2,3,4,56,43);
		
		a.forEach(n -> {
			n *=2;
			System.out.print(n + " ");
		});
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(56);
		l.add(78);
		l.forEach(System.out::println);
		
	}
}
