package cave_9_lowLevelSynchronization;

import java.util.LinkedList;

public class AppTest{
	private static LinkedList<Integer> minhaLista = new LinkedList<Integer>();
	private static int valor = 0;
	private static Object trava = new Object();
	public static void produce() {

		while(true) {
			synchronized(trava) {
				while(minhaLista.size() == 5) {
					try {
						trava.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				minhaLista.add(valor++);
				trava.notify();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void consume() {

		while(true) {
			synchronized(trava) {
				while(minhaLista.size() == 0) {
					try {
						trava.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				minhaLista.removeFirst();
				trava.notify();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[]args) {
		(new Thread(new Runnable() {
			public void run() {
				produce();
			}
		})).start();
		(new Thread(new Runnable() {
			public void run() {
				consume();
			}
		})).start();


		while(true) {
			for(int i = 0; i < minhaLista.size(); i++) {
				System.out.print(i + ", ");
			}
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}


