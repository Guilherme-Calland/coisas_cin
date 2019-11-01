package caveOfProgramming_12_semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class ConnectionTest{

	private int connections;

	private Semaphore sem = new Semaphore(5, true);

	public ConnectionTest() {

	}

	public void connect(){

		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			synchronized(this) {
				connections++;
				System.out.println("Connections: " + connections);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally {
			connections--;
			sem.release();
		}



	}
}

public class AppTest {

	public static void main(String[]args) {
		ConnectionTest c = new ConnectionTest();
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i = 0; i < 500; i++) {
			pool.submit(new Runnable() {
				public void run() {
					c.connect();
				}
			});
		}
	}
}
