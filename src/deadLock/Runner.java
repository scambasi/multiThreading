package deadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	Account acc1=new Account();
	Account acc2=new Account();
	private Lock lock1=new ReentrantLock();
	private Lock lock2=new ReentrantLock();
	private void acquireLocks(Lock firstLock,Lock secondLock) throws InterruptedException
	{
		while(true)
		{
			//acquire lock
			boolean gotFirstLock=false;
			boolean gotSecondLock=false;
			
			//lock not acquire
			try {
				gotFirstLock=firstLock.tryLock();
				gotSecondLock=secondLock.tryLock();
				
				
			} 
			finally 
			{
				if(gotFirstLock & gotSecondLock)
				{
					return;
				}
				if(gotFirstLock)
				{
					firstLock.unlock();
				}
				
				if(gotSecondLock)
				{
					secondLock.unlock();
				}
			}
		}
	}
			
	public void firstThread() throws InterruptedException {
		Random r=new Random();
		
		for (int i = 0; i <1000; i++) {
			acquireLocks(lock1, lock2);
			try {
				Account.transfer(acc1, acc2, r.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
			
		}
	}

	public void secondThread() throws InterruptedException {
		Random r=new Random();
		for (int i = 0; i <1000; i++) {
			lock2.lock();
			lock1.lock();
			try {
				Account.transfer(acc2, acc1, r.nextInt(100));
			} finally {
				lock2.unlock();
				lock1.unlock();
			}
		
		}
	}

	public void finished() {
		System.out.println("Account 1 :"+acc1.getBalance());
		System.out.println("Account 2 :"+acc2.getBalance());
		System.out.println("Total Balance :"+(acc1.getBalance()+acc2.getBalance()));
	}
}
