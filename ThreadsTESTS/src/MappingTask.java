import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MappingTask implements Runnable{
	
	List<String> texte = new ArrayList<>();
	private long sleepTime;
	private int nbThreads;
	Map<String, Integer> mappedTxt = new HashMap<>();
	
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	private volatile boolean done = false;
	
	
	public MappingTask(List<String> texte, long sleepTime) {
		
		this.texte = texte;
		this.sleepTime = sleepTime;
		this.instanceNumber = ++count;
		this.taskId = "Task-" + instanceNumber;
		
		
		
	}
	
	

	@Override
	public void run() {
		
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("THREAD " + currentThreadName + taskId + " COMMENCE");
		
		System.out.println("THREAD " + currentThreadName + taskId + " DORT PENDANT : " + sleepTime + " millis");
		
		
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
		// opération
		try {
			mappedTxt = MapFunction.mapGenerator(texte);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("THREAD " + currentThreadName + taskId + " TERMINE");
		
		done = true;
		
		synchronized(this) {
			System.out.println(currentThreadName + " NOTIFYING");
			this.notifyAll();
		}
		
	}
	
	
	public  Map<String, Integer> getMappedText() {
	

		if (!done) {
			synchronized(this){
				try {
					System.out.println(Thread.currentThread().getName() + " WAITING FOR RESULTS");
					this.wait();
					
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "WOKEN UP");
		}
	return mappedTxt;	
	}

	
}
