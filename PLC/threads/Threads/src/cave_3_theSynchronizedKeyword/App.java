package cave_3_theSynchronizedKeyword;

public class App {
	
	private int contador = 0;
	
	public synchronized void increment(int num) {
		contador += num;
	}
	
	public static void main(String[]args) {
		App app = new App();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i < 1000 ; i++) {
					app.increment(2);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i = 0; i < 1000 ; i++) {
					app.increment(3);
				}
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("count is: " + app.contador);
	}
}
