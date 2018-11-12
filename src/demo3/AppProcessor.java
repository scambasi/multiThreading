package demo3;

import java.util.Scanner;

public class AppProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proccessor p= new Proccessor();
		p.start();

		System.out.println("Press return to  stop ");
		Scanner scanner=new Scanner(System.in);
		scanner.nextLine();
		p.shutDown();
	}

}
class Proccessor extends Thread
{
 private volatile boolean running=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(running)
		{
			System.out.println("hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public void shutDown()
	{
		running=false;
	}
	}