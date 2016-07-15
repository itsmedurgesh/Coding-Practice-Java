package threadsAndLocking;

public class ThreadExample extends Thread{
	int count = 0;
	public void run(){
		System.out.println("Thread started..");
		try{
			while(count < 5){
				Thread.sleep(500);
				System.out.println("Thread count: "+count);
				count++;
			}
		}catch(InterruptedException e){
			System.out.println("Thread interrupted..");
		}
		
		System.out.println("Thread exiting..");
	}
	
	public static void test(){
		ThreadExample t = new ThreadExample();
		t.start();
		
		while(t.count != 5){
			try{
				Thread.sleep(250);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
