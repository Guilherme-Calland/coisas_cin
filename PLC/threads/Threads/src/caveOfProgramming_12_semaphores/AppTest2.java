package caveOfProgramming_12_semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Runner{
	private int numOfThreads = 0;
	private Semaphore sem = new Semaphore(10);
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			doConnect();
		}finally {
			sem.release();
		}
	}
	
	public void doConnect() {
		synchronized(this) {
			numOfThreads++;
			System.out.println("number of threads working: " + numOfThreads);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this) {
			numOfThreads--;
		}
	}
	
}

public class AppTest2 {
	public static void main(String[]args) {
		Runner r = new Runner();
		ExecutorService pool = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 5000; i++) {
			pool.submit(new Runnable() {
				public void run() {
					r.connect();
				}
			});
		}
	}
}
