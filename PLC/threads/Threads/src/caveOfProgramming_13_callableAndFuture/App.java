package caveOfProgramming_13_callableAndFuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
	public static void main(String[]args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		
		Future<Integer> future = pool.submit(new Callable<Integer>(){
			public Integer call() throws Exception {
				Random rand = new Random();
				int duration = rand.nextInt(4000);
				
				if(duration > 2000) {
					throw new IOException("Sleeping for too long");
				}
				
				System.out.println("Starting...");
				Thread.sleep(duration);
				System.out.println("Done");
				
				return duration;
			}
		});
		
		Future<?> future2 = pool.submit(new Callable<Void>(){
			public Void call() throws Exception {
				Random rand = new Random();
				int duration = rand.nextInt(4000);
				
//				if(duration > 2000) {
//					throw new IOException("Waaay too long.");
//				}
				
				System.out.println("Starting again...");
				Thread.sleep(duration);
				System.out.println("Done again");
				
				return null;
			}
		});
		
		pool.shutdown();
		
		try {
			System.out.println("Result is: " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			IOException exce = (IOException) e.getCause();
			
			System.out.println(exce.getMessage());
		}
	}
}
