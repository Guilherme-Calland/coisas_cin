package caveOfProgramming_14_theFinalChapter_InterruptingThreads;

import java.util.Random;

public class App {
	public static void main(String[]args) throws InterruptedException {
		System.out.println("Starting.");
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Random rand = new Random();
				
				for(int i = 0; i < 1E8; i++) {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						System.out.println("we've been interrupted");
//						break;
//					}
					
					
					
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted.");
						break;
					}
					Math.sin(rand.nextDouble());
				}				
			}
			
		});
		t.start();
		
		Thread.sleep(500);
		
		t.interrupt();
		
		t.join();
		System.out.println("Finished.");
	}
}
