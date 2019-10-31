package cave_9_lowLevelSynchronization;

import java.util.LinkedList;

class Processor{

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;

		while(true) {
			synchronized(lock) {
				while(list.size()== LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
			
			Thread.sleep(500);
		}
	}

	public void consume() throws InterruptedException {
		while(true) {
			synchronized(lock) {
				while(list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println("; value is: " + value);
				lock.notify();
			}
			
			Thread.sleep(500);
		}
	}
}

public class App {
	public static void main(String[]args) throws InterruptedException {
		Processor p = new Processor();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					p.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					p.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();t2.start();t1.join();t2.join();
	}
}
