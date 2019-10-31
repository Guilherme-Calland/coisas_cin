package cave_7_producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AppTeste {
	private static BlockingQueue<Integer> queue2 = new ArrayBlockingQueue(10);

	private static void produce(){
		Random random = new Random(10);
		while(true) {
			try {
				queue2.put(random.nextInt(10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void consume(){
		Random random = new Random(10);
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(random.nextInt(10)==0) {
				try {
					int value = queue2.take();
					System.out.println("Taken value: " + value + "; Queue size: " + queue2.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[]args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				produce();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				consume();
			}
		});
		
		t1.start(); t2.start();
			try {
				t2.join();t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
