package cave_8_waitAndNotify;

import java.util.Scanner;

class Processor2{
	public synchronized void func1() throws InterruptedException {
		for(int i = 0; i < 5 ; i++) {
			System.out.println("Hello");
			Thread.sleep(500);
		}
		wait();
		for(int i = 0; i < 5 ; i++) {
			System.out.println("GoodBye");
			Thread.sleep(500);
		}
	}
	
	public synchronized void func2() throws InterruptedException {
		Scanner s = new Scanner(System.in);
		Thread.sleep(500);
		System.out.print("press return key");
		s.nextLine();
		notify();
		System.out.println("return key pressed");
		Thread.sleep(500);
		for(int i = 1; i < 6; i++) {
			System.out.print(i + ", ");
			Thread.sleep(500); 
		}
		System.out.println("");
		
	}
}

public class AppTeste {
	public static void main(String[]args) throws InterruptedException {
		Processor2 p = new Processor2();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					p.func1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					p.func2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();t2.start();t1.join();t2.join();
	}
}
