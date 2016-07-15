package newDatatypes;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayIterator<T>(this);
	}
	
	private class CircularArrayIterator<T1> implements Iterator<T1>{
		
		private int _current = -1;
		private T1[] _items;
		public CircularArrayIterator(CircularArray<T1> circularArray) {
			// TODO Auto-generated constructor stub
			_items = circularArray.items;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return _current < (_items.length -1);
		}

		@Override
		public T1 next() {
			// TODO Auto-generated method stub
			return (T1)_items[getindex(++_current)];
		}
		
	}
	
	T[] items;
	int head=0;
	
	@SuppressWarnings("unchecked")
	public CircularArray(int size){
		items = (T[])new Object[size];
	}
	
	private int getindex(int id){
		if(id<0)
			id += items.length;
		return (head+id)%items.length;
	}
	
	public void rotate(int shift){
		head = getindex(shift);
	}
	
	public T get(int i){
		if(i<0 || i>items.length)
			throw new IndexOutOfBoundsException("..");
		
		return items[getindex(i)];
	}
	
	public void set(int i, T t){
		items[getindex(i)] = t;
	}
	
	
	// test method
	public static void test(){
		CircularArray<Integer> c = new CircularArray<Integer>(5);
		c.set(0, 12);
		c.set(1, 14);
		c.set(2, 16);
		c.set(3, 18);
		c.set(4, 122);
		c.rotate(3);
		
		for(int a: c){
			System.out.println(a);
		}
		
	}

}
