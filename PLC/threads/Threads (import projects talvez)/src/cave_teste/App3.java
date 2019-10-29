package cave_teste;

public class App3 {
	public static void main(String[]args) {
		Thread hello = new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("Hello " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread goodBye = new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0; i< 10; i++) {
					System.out.println("GoodBye " + i);
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		hello.start();
		goodBye.start();
	}
}
