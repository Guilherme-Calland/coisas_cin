package caveOfProgramming_14_theFinalChapter_InterruptingThreads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App2 {
	public static void main(String[]args) throws InterruptedException {
		
		System.out.println("Starting.");
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Future<?> foo = exec.submit(new Callable<Void>() {
			public Void call() {
				Random rand = new Random();
				
				for(int i = 0; i < 1E8; i++) {

					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted.");
						break;
					}
					Math.sin(rand.nextDouble());
				}				
				return null;
			}
		});
		
		exec.shutdown();
		
		Thread.sleep(500);
		
//		foo.cancel(true);
		exec.shutdownNow();
		
		exec.awaitTermination(10, TimeUnit.DAYS);
		
		System.out.println("Finished.");
	}
}
