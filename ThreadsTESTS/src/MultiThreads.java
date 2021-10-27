
public class MultiThreads implements Runnable {
	Thread thread;
	
	@Override
	public void run() {
		System.out.println("Thread running " + thread);
		  for (int i = 0; i < 4; i++) {
		   System.out.println(i);
		   System.out.println(thread.getName());
		   
		   try {
		    Thread.sleep(1000);
		   } catch (InterruptedException e) {
		    System.out.println("Thread has been interrupted");
		   }
		  }
		 }
	public void start() {
		  System.out.println("Thread started");
		  if (thread == null) {
		   thread = new Thread();
		   thread.start();
		  }
		 }
		
	
	public static void main(String[] args) {
		  // TODO Auto-generated method stub
		MultiThreads th1 = new MultiThreads();
		  th1.start();
		  MultiThreads th2 = new MultiThreads();
		  th2.start();
		  
		  th1.run();
		  th2.run();
		 }
		}
			    



