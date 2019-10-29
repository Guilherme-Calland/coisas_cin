package cave_teste;

class Runner extends Thread{
	
	private int id;
	
	public Runner(int id) {
		this.id = id;
	}
	
	public void run() {
		for(int i = 0; i< 10; i++) {
			System.out.println("Thread#" + id + ": Hello! " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class AppTeste {
	public static void main(String[]args) {
		Runner runner1 = new Runner(1);
		Runner runner2 = new Runner(2);
		runner1.start();
		runner2.start();
	}
}
