package cave_4_multipleLocks;

import java.util.Random;

class Worker2{

	private int[] lista1 = new int[200];
	int lista1index = 0;
	
	private int[] lista2 = new int[200];
	int lista2index = 0;
	
	private Random rand = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void incrementaListaUm() {
		synchronized(lock1) {
			for(int i=0; i<100; i++) {
				lista1[lista1index] = (rand.nextInt())%10;
				if(lista1[lista1index] < 0) {
					lista1[lista1index] = -(lista1[lista1index]);
				}
				lista1index++;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void incrementaListaDois() {
		synchronized(lock2) {
			for(int i=0;i<100;i++) {
				lista2[lista2index] = (rand.nextInt())%10;
				if(lista2[lista2index] < 0) {
					lista2[lista2index] = -(lista2[lista2index]);
				}
				lista2index++;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void main() {

		Runnable procA = new Runnable() {
			public void run() {
				incrementaListaUm();
			}
		};

		Runnable procB = new Runnable() {
			public void run() {
				incrementaListaDois();
			}
		};

		Thread t1 = new Thread(procA);
		Thread t2 = new Thread(procA);
		Thread t3 = new Thread(procB);
		Thread t4 = new Thread(procB);
		
		t1.start();t2.start();t3.start();t4.start();
		
		try {
			t1.join();t2.join();t3.join();t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		System.out.println("Lista 1: [ ");
		int temp = 0;
		for(int i = 0; i < lista1.length; i++) {
			if(temp == 20) {
				temp = 0;
				System.out.println("");
			}
			System.out.print(lista1[i] + ", ");
			temp++;
		}
		System.out.println("\n ]");
		temp = 0;
		System.out.println("Lista 2: [ ");
		for(int i = 0; i < lista2.length; i++) {
			if(temp == 20) {
				temp = 0;
				System.out.println("");
			}
			System.out.print(lista2[i] + ", ");
			temp++;
		}
		System.out.println("\n ]");
	}
}

public class App2 {

	public static void main(String[] args) {
		(new Worker2()).main();
	}

}
