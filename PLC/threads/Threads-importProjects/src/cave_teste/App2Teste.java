package cave_teste;

class Runner2 implements Runnable{
	
	private int id;
	
	public Runner2(int id) {
		this.id = id;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Thread#" + id + ": Hello " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

public class App2Teste {
	public static void main(String[]args) {
		Thread t1 = new Thread(new Runner2(1));
		Thread t2 = new Thread(new Runner2(2));
		t1.start();
		t2.start();
	}
}
