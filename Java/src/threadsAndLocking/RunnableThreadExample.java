package threadsAndLocking;

public class RunnableThreadExample implements Runnable{
	int count = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("runnable thead started..");
		try{
			while(count < 5){
				Thread.sleep(500);
				count++;
			}
		}catch(InterruptedException e){
			System.out.println("runnable thead interrupted..");
		}finally{
			System.out.println("runnable thead exiting..");
		}
	}
	
	public static void test(){
		RunnableThreadExample r = new RunnableThreadExample();
		Thread thread = new Thread(r);
		thread.start();
		while(r.count != 5){
			try{
				Thread.sleep(250);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
