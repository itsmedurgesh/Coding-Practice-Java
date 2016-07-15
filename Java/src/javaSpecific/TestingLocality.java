package javaSpecific;

import java.util.ArrayList;
import java.util.LinkedList;

// this program show that java performs bad for contiguous allocation
// and hence can not utilize caching efficiently but c++ can


public class TestingLocality {
	static class Node{
		int data;
		String name;
		Node(int d, String n){
			data = d;
			name = n;
		}
		void increment(int d){
			data += d;
		}
	}
	public static void test(){
		final long startTime = System.currentTimeMillis();
		
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.add(0);
		for(int i = 1; i < 100000; ++i) a.add(a.get(i-1) + 1);
		long sum = 0;
		for(int i = 1; i < 100000; ++i) sum += a.get(i);
		
		System.out.println(sum);
		
		for(int i = 1; i < 100000; ++i){
			Node node = new Node(i, i+"");
			node.increment(i);
		}
		
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime) );
		
	}
}
