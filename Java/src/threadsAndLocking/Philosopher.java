package threadsAndLocking;

public class Philosopher extends Thread {
	private short bites = 10;
	private Chopstick left, right;
	
	public Philosopher(Chopstick l, Chopstick r){
		left = l;
		right = r;
	}
	
	public void eat(long id) throws InterruptedException{
		if(pickup()){
			System.out.println(id+" eating..");
			chew(id);
			putdown();	
			System.out.println(id+" bite done..");
			return;
		}
		System.out.println(id+ " pickup failed..");
		Thread.sleep(500);
		eat(id);
	}

	private boolean pickup() {
		// TODO Auto-generated method stub
		if(!left.pickup()) return false;
		if(!right.pickup()){
			left.putdown();
			return false;
		}
		return true;
		
	}

	private void chew(long id) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(500);
			System.out.println(id+" takes a bite..");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void putdown() {
		// TODO Auto-generated method stub
		left.putdown();
		right.putdown();
	}
	
	public void run(){
		long threadId = Thread.currentThread().getId();
        System.out.println("Thread # " + threadId + " is doing this task");
		for(int i=0; i<bites; i++)
			try {
				eat(threadId);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("thread " + threadId + " done..");
	}
	
	public static void test(){
		// create a table
		final short TABLESIZE = 4;
		Philosopher[] philosophers = new Philosopher[TABLESIZE];
		Chopstick[] chopsticks = new Chopstick[TABLESIZE];
		
		for(int i=0; i<TABLESIZE; i++){
			chopsticks[i] = new Chopstick();
		}
		
		for(int i=0; i<TABLESIZE; i++){
			short left = (short) i;
			short right = (short) ((i==0)? TABLESIZE-1 : (i-1));
			philosophers[i] = new Philosopher(chopsticks[left], chopsticks[right]);
		}
		
		for (int i = 0; i < chopsticks.length; i++) {
			philosophers[i].start();
		}
		
//		System.out.println("done..");
	}
}
