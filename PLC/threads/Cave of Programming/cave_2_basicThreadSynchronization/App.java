package cave_2_basicThreadSynchronization;

import java.util.Scanner;

class Processor extends Thread{
	
	private volatile boolean running = true;
	
	public void run() {
		while(running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor p1 = new Processor();
		p1.start();
		Scanner s = new Scanner(System.in);
		System.out.println("press return do stop");
		s.nextLine();
		p1.shutdown();
		System.out.println("bye");
	}

}
