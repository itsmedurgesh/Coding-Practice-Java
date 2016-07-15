package newDatatypes;

import java.util.LinkedList;

abstract class Animal{
	private int order;
	String name;
	Animal(String s){
		name = s;
	}
	
	void setOrder(int o){
		order = o;
	}
	
	int getOrder(){
		return order;
	}
	
	boolean isOlder(Animal a){
		return this.order < a.order;
	}
}

class Dog extends Animal{
	Dog(String s){
		super(s);
	}
}

class Cat extends Animal{
	Cat(String s){
		super(s);
	}
}

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a){
		a.setOrder(order++);

		if(a instanceof Dog) dogs.addLast((Dog)a);
		else if(a instanceof Cat) cats.addLast((Cat)a);
		
	}
	
	public Animal dequeueAny(){
		if(dogs.isEmpty()) return dequeueCats();
		if(cats.isEmpty()) return dequeueDogs();
		
		Dog d = dogs.peek();
		Cat c = cats.peek();
		
		if(d.isOlder(c)) return dequeueDogs();
		else return dequeueCats();
		
	}
	
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	
	public Cat dequeueCats(){
		return cats.poll();
	}
	
	public static void test(){
		AnimalQueue a = new AnimalQueue();
		a.enqueue(new Dog("first dog"));
		a.enqueue(new Dog("second dog"));
		a.enqueue(new Cat("first cat"));
		a.enqueue(new Cat("second cat"));
		a.enqueue(new Dog("third dog"));
		
		System.out.println(a.dequeueCats().name);
		System.out.println(a.dequeueDogs().name);
		System.out.println(a.dequeueAny().name);
	}
}
