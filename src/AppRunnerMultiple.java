


class Runner extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Hello"+1);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
public class AppRunnerMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner runner1=new Runner();
		runner1.start();
		Runner runner2=new Runner();
		runner2.start();
		

	}

}
