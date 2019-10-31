package caveOfProgramming_10_reentrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner2{
	private int count = 0;
	private Lock l = new ReentrantLock();
	private Condition c = l.newCondition();
	
	public void increment() {
		for(int i = 0; i < 10000; i++) {
			count++;
		}
	}
	
	public void runOne() {
		l.lock();
		try {
			c.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			increment();
		}finally {
			l.unlock();
		}
	}
	
	public void runTwo() {
		l.lock();
		System.out.println("press enter");
		(new Scanner(System.in)).nextLine();
		c.signal();
		try {
			increment();
		}finally {
			l.unlock();
		}
	}
	
	public void end() {
		System.out.println("Count: " + count);
	}
}

public class AppTest {
	public static void main(String[]args) throws InterruptedException {
		Runner2 r = new Runner2();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				r.runOne();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				r.runTwo();
			}
		});
		t1.start();t2.start();t1.join();t2.join();
		r.end();
		
	}
}
