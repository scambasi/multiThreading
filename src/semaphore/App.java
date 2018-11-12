package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) throws InterruptedException {
		
		
		ExecutorService es=Executors.newCachedThreadPool();
		for(int i=0;i<1000;i++)
		{
			es.submit(new Runnable() {
				
				@Override
				public void run() {
					Connection.getInstance().connect();
					
				}
			});
			es.shutdown();
			es.awaitTermination(1, TimeUnit.DAYS);
		}
		
		// TODO Auto-generated method stub
//		Semaphore sp=new Semaphore(1);
//		try {
//			sp.acquire();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		sp.release();
//		 System.out.println("Avaliable permits : "+sp.availablePermits());
//		
		
	}
}
