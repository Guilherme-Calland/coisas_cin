package caveOfProgramming_11_deadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{
	private int balance;

	public Account(int balance) {
		this.balance = balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

	public static void transfer(Account acc1, Account acc2, int amount ) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
}

class Runner{
	private Account acc1 = new Account(1000);
	private Account acc2 = new Account(1000);

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void aquireLocks(Lock firstLock, Lock secondLock) {

		while(true) {
			//requireLocks
			boolean getFirstLock = false;
			boolean getSecondLock = false;

			try {
				getFirstLock = lock1.tryLock();
				getSecondLock = lock1.tryLock();
			}finally {
				if(getFirstLock && getSecondLock) {
					return;
				}
				
				if(getFirstLock){
					lock1.unlock();
				}
				
				if(getSecondLock) {
					lock2.unlock();
				}
			}





			//Locks not required
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

	public void firstThread() {
		Random rand = new Random();
		for(int i = 0; i < 10000; i++) {

			aquireLocks(lock1, lock2);

			lock1.lock();
			lock2.lock();
			try{
				Account.transfer(acc1, acc2, rand.nextInt(100));
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() {
		Random rand = new Random();
		for(int i = 0; i < 10000; i++) {

			aquireLocks(lock2, lock1);

			lock2.lock();
			lock1.lock();
			try{
				Account.transfer(acc2, acc1, rand.nextInt(100));
			}finally {
				lock2.unlock();
				lock1.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()) );
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
		t1.start();t2.start();t1.join();t2.join();
		r.finished();
	}
}
