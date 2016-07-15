package threadsAndLocking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private Lock lock;
	
	public Chopstick(){
		lock = new ReentrantLock();
	}
	public boolean pickup() {
		return lock.tryLock();
	}

	public void putdown() {
		// TODO Auto-generated method stub
		lock.unlock();
	}

}
