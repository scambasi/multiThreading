package lowLevelSycronized;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	private LinkedList<Integer> list=new LinkedList<Integer>();
	private final int LIMIT=10;
private Object lock=new Object();	
	// üretim
	public void produce() throws InterruptedException {
		int value=0;
		while(true)
		{
			synchronized (lock) {
				while(list.size()==LIMIT)
				{
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
			
		}
	}

	// tüketim
	public void consume() throws InterruptedException {
		Random r=new Random();
		
		while(true)
		{
			synchronized(lock)
			{
				while(list.size()==0)
				{
					lock.wait();
				}
				System.out.println("List Size is: "+list.size());
				int value=list.removeFirst();
				System.out.println(";Value  is: "+value);
				lock.notify();
			}
			Thread.sleep(r.nextInt(1000));
		}
		
	}
}
