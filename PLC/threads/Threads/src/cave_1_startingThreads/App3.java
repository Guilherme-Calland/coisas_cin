package cave_1_startingThreads;

public class App3 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("dale");
			}
		});

	}

}
