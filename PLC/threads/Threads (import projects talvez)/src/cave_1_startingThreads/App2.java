package cave_1_startingThreads;

class Runner2 implements Runnable{
	private int id;
	
	public Runner2(int id) {
		this.id = id;
	}
	
	public void run() {
		for(int i = 0; i < 10 ; i++) {
			System.out.println("Thread#" + id + ": Hello " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class App2 {
	public static void main(String[]args) {
		Thread t1 = new Thread(new Runner(1));
		Thread t2 = new Thread(new Runner(2));
		
		t1.start();
		t2.start();
	}
}
