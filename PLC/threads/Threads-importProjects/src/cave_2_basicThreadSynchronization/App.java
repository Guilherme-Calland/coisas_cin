package cave_2_basicThreadSynchronization;

//ctrl + shift + o = import rapido
import java.util.Scanner;

class Processor extends Thread{
	
	private volatile boolean running = true;
	
	public void run() {
		while(running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}/**/
	}
	
	public void shutdown() {
		running = false;
	}
}

public class App{

	public static void main(String[]args) {
		Processor p1 = new Processor();
		p1.start();
		
		System.out.println("Press return to shutdown");
		Scanner s = new Scanner(System.in);
		s.nextLine();
		
		p1.shutdown();
		//é como se estivessem 2 threads executando, um que escreve
		// que a running = true e depois lê a variavel
		// e o outro que escreve running = false
		//a palavra chave volatile resolve qualquer problema que isso
		//possa apresentar
		
		System.out.println("bye");
	}
}
