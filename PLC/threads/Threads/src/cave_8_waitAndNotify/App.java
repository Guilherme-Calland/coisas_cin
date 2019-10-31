package cave_8_waitAndNotify;

public class App {
	public static void main(String[]ars) throws InterruptedException {
		
		Processor p = new Processor();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				p.produce();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				p.consume();
			}
		});
		
		t1.start();t2.start();
		t1.join();t2.join();
	}
}
