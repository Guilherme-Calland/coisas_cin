package cave_5_threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Starting: " + id);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed: " + id);
	}
}

public class App {
	public static void main(String[]args) {
		ExecutorService executor = Executors.newFixedThreadPool(100);
		
		for(int i = 0; i < 1000; i++) {
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		//encerre quando terminar todas as tarefas;
		
		System.out.println("All tasks submitted");
		
		try {
			executor.awaitTermination(100, TimeUnit.SECONDS);
			/*só leia o restante do codigo ou quando 
			 * a pool terminar ou qual der 100 segundos*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
		
		
	}
}
