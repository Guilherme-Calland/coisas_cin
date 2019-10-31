package cave_6_countdownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessorTeste implements Runnable{
	private CountDownLatch l;
	private int id;
	public ProcessorTeste(int id, CountDownLatch l){
		this.id = id;
		this.l = l;
	}
	public void run() {
		System.out.println("starting " + id);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done " + id);
		l.countDown();
	}
}

public class AppTeste {
	public static void main(String[]args) {
		CountDownLatch latch = new CountDownLatch(10);
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 10; i++) {
			pool.submit(new ProcessorTeste(i, latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("all done");
	}
}
