package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class keepMedian {
	/* TODO: implement comparator to make this work
	 * 
	 */
	private Comparator<Integer> maxHeapComperator;
	private Comparator<Integer> minHeapComperator;
	private PriorityQueue<Integer> maxHeap, minHeap;
	
	keepMedian(){
		maxHeap = new PriorityQueue<Integer>(maxHeapComperator);
		minHeap = new PriorityQueue<Integer>(minHeapComperator);
	}
	
	public void addNewNumber(int n){
		if(maxHeap.size() == minHeap.size()){
			if((minHeap.peek() != null) && n > minHeap.peek()){
				maxHeap.offer(minHeap.poll());
				minHeap.offer(n);
			}
			else
				maxHeap.offer(n);
		}
		else{
			if(n < maxHeap.peek()){
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(n);
			}
			else
				minHeap.offer(n);
		}
	}
	
	public double getMedian(){
		if(maxHeap.isEmpty()) return 0;
		
		if(maxHeap.size() == minHeap.size())
			return ((double)minHeap.peek() + (double)maxHeap.peek()) /2;
		else
			return maxHeap.peek();
	}
	
	public static void test(){
		keepMedian m = new keepMedian();
		m.addNewNumber(23);
		m.addNewNumber(34);
		m.addNewNumber(45);
		m.addNewNumber(56);
		m.addNewNumber(67);
		m.addNewNumber(212);
		m.addNewNumber(2);
		System.out.println(m.getMedian());
		
	}
}
