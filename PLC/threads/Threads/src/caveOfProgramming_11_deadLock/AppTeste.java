package caveOfProgramming_11_deadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AccountTest {
	public int balance;

	public AccountTest(int value) {
		balance = value;
	}

	public static void transfer(AccountTest a1, AccountTest a2, int value) {
		a1.balance -= value;
		a2.balance += value;
	}
}

class Run{

	Random rand = new Random(100);

	AccountTest accountA = new AccountTest(500);
	AccountTest accountB = new AccountTest(500);
	AccountTest accountC = new AccountTest(500);

	private Lock lockA = new ReentrantLock();
	private Lock lockB = new ReentrantLock();
	private Lock lockC = new ReentrantLock();

	public void job1() {

		for(int i = 0; i < 10; i++) {
			
			getLocks(lockA, lockB);

			try {
				AccountTest.transfer(accountA, accountB, rand.nextInt(100));
			}finally {
				lockA.unlock();
				lockB.unlock();
			}
		}
	}

	public void job2() {
		for(int i = 0; i < 10; i++) {
			
			getLocks(lockB, lockC);
			
			try {
				AccountTest.transfer(accountB, accountC, rand.nextInt(100));
			}finally {
				lockB.unlock();
				lockC.unlock();
			}
		}
	}

	public void job3() {
		for(int i = 0; i < 10; i++) {
			
			getLocks(lockC, lockA);
			
			try {
				AccountTest.transfer(accountC, accountA, rand.nextInt(100));
			}finally {
				lockC.unlock();
				lockA.unlock();
				
			}
		}
	}

	public void getLocks(Lock l1, Lock l2) {
		while(true) {
			boolean gotLock1 = false;
			boolean gotLock2 = false;
			try {
				gotLock1 = l1.tryLock();
				gotLock2 = l2.tryLock();
			} finally {

				if(gotLock1 && gotLock2) {
					return;
				}

				if(gotLock1) {
					l1.unlock();
				}
				if(gotLock2) {
					l2.unlock();
				}

			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void show() {
		System.out.println("Account A:" + accountA.balance );
		System.out.println("Account B:" + accountB.balance );
		System.out.println("Account C:" + accountC.balance );
		System.out.println("\nTotal Balance:" + (accountA.balance 
				+	 accountB.balance
				+  accountC.balance) );
	}
}

public class AppTeste{
	public static void main(String[]args) {
		Run r = new Run();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				r.job1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				r.job3();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				r.job3();
			}
		});
		t1.start();t2.start();t3.start();
		try {
			t1.join();t2.join();t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.show();
	}
}

