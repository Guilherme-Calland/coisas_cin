package cave_5_threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor2 implements Runnable{
	private int id;
	public Processor2(int id) {
		this.id = id;
	}
	public void run() {
		System.out.println("running: " + id);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class AppTeste {
	public static void main(String[]args) {
		
		long start = System.currentTimeMillis();
		
		ExecutorService pool = Executors.newFixedThreadPool(100);
		
		for(int i = 0; i < 1000; i++) {
			pool.submit(new Processor2(i));
		}
		
		pool.shutdown();
		
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("cabô");
		
		long end = System.currentTimeMillis();
		
		System.out.println("tempo de execucao: " + (end - start) + "ms");
	}
}
