package caveOfProgramming_10_reentrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {

	private int count;
	private Lock l = new ReentrantLock();
	private Condition cond = l.newCondition();

	private void increment() {
		for(int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread(){
		l.lock();
		try {
			cond.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			increment();
		}finally {
			l.unlock();
		}
		//assim garante que, caso ocorra uma exceçao 
		//dentro da duncao,
		//ele será destravado mesmo assim.
	}

	public void secondThread() {
		l.lock();
		
		System.out.println("press return");
		(new Scanner(System.in)).nextLine();
		cond.signal();
		
		try {
			increment();
		} finally {
			l.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}

public class App {
	public static void main(String[]args) throws InterruptedException {
		Runner r = new Runner();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				r.firstThread();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				r.secondThread();
			}
		});
		t1.start();t2.start();
		t1.join();t2.join();
		r.finished();
	}
}
