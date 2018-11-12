package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service=Executors.newFixedThreadPool(2);
		for(int i=0;i<5;i++)
		{
			service.submit(new Processor(i));
		}
		service.shutdown();
		System.out.println("All tasks submitted");
		try {
			service.awaitTermination(1,TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks completed.");

	}

}
class Processor implements Runnable
{
	private int id=10;
	public Processor(int id) {
		// TODO Auto-generated constructor stub
	this.id=id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("starting : "+ id);
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed : "+ id);
	}
}
