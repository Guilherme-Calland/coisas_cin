package cave_6_countdownLatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run() {
		System.out.println("started.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done.");
		
		latch.countDown();
	}
}

public class App {
	public static void main(String[]args) {
		CountDownLatch latch = new CountDownLatch(3);
		//faz com que 1 ou mais threads espere
		// até o temporizador(3) chegar à 0 para 
		// ter acesso ao runnable
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 3; i++){
			pool.submit(new Processor(latch));
		}
		
		try {
			latch.await();
			/*espera countdown chegar a 0*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("completed all.");
	}
}
