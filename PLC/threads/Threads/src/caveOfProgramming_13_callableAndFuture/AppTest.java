package caveOfProgramming_13_callableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppTest {
	
	static int number = 0;
	
	public static void main(String[]args) throws InterruptedException, ExecutionException {
		ExecutorService myPool = Executors.newCachedThreadPool();
		for(int i = 0; i < 1000; i++) {
			Future<String> future = myPool.submit(new Callable<String>() {
				public String call() {
					number++;
					return "oi " + number;
				}
			});
			System.out.println(future.get());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Deu ruim");
			}
		}
	}
}
