package caveOfProgramming_14_theFinalChapter_InterruptingThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*1,2-> is dois tipos de interrupcao
 * 3-> interrupcao usando o pool.shutdownnow
 * 4 -> interrupcao usando o future*/
public class AppTeste {
	static int numero;
	public static void main(String[]args) throws InterruptedException {
		System.out.println("Starting.");
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("First Thread...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Interrupted First Thread.");
				}
				System.out.println("First Thread Done.");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Second Thread...");
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Interrupted Second Thread.");
				}
				System.out.println("Second Thread Done.");
			}
		});

		t1.start();

		t1.interrupt();

		t2.start();

		t2.interrupt();

		try {
			t1.join();t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ExecutorService pool = Executors.newCachedThreadPool();
		
		System.out.println("\nStarting.......");
		
		for(int i = 0; i < 100; i++) {
			Future<?> foo = pool.submit(new Callable<Void>() {
				public Void call() {
					synchronized(this) {
						numero++;
						System.out.println("Starting " + numero + " from threadpool");
						if(Thread.currentThread().isInterrupted()) {
							System.out.println(numero + " interrpmido");
							
						}
						System.out.println("Done with " + numero + " from threadpool");
						return null;
					}
				}
			});
			
			foo.cancel(true);

		}


		pool.shutdown();
		
		Thread.sleep(1000);
		
//		pool.shutdownNow();
		
		
		
		pool.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println("Finished.");

	}
}
