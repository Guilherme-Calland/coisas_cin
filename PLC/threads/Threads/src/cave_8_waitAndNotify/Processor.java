package cave_8_waitAndNotify;

import java.util.Scanner;

public class Processor {
	public void produce() {
		synchronized(this) {
			//this = esse Processor
			System.out.println("Producer Thread running...");
			try {
				wait();
				//nao resume até que seja notificado
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("resumed");
		}
	}

	public void consume() {

		Scanner scanner = new Scanner(System.in);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized(this) {
			System.out.println("press return key");
			scanner.nextLine();
			System.out.println("return key pressed");
			notify();
		}
		

	}
}
