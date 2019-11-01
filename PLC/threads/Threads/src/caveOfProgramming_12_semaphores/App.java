package caveOfProgramming_12_semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Connection{
	private static Connection instance = new Connection();
	
	private Semaphore sem = new Semaphore(20, true);
	//existem 20 permissoes, para digamos 1000 threads, apenas 20 
	// tem permissoes para rodar. true -> o primeiro que usar
	//acquire será o primeiro a ter permissao,
	
	
	private int connections = 0;
	
	private Connection() {
	//só existe um único objeto connection (private constructor)	
	}
	
	public static Connection getInstance() {
		return instance;
	}
	
	
	public void connect() throws InterruptedException {
		
		sem.acquire();
		
		try {
			doConnect();
		}finally {
			sem.release();
		}
		
	}

	public void doConnect() throws InterruptedException {
		
		synchronized(this) {
			connections++;
			System.out.println("Current connections: " + connections);
		}
		
		
		Thread.sleep(2000);
		
		
		synchronized(this) {
			connections--;
		}
		
		
		
	}
}

public class App {
	public static void main(String[]args) throws Exception {
//		Semaphore sem = new Semaphore(1);
//		num de permissoes = 1
//		
//		sem.acquire();
//		espera até que seja liberado uma permisao
//		
//		sem.release();
//		aumenta o num de permissoes
//		
		
		ExecutorService pool = Executors.newCachedThreadPool();
		//cached thread pool: uma nova thread é criada à cada submit
		//(para cada runnable jogado na pool)
		for(int i = 0; i < 200; i++) {
			pool.submit(new Runnable() {
				public void run() {
					try {
						Connection.getInstance().connect();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//no caso, só existe um objecto Connection
				}
			});
		}
		
		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.DAYS);
		
		
	}
}
