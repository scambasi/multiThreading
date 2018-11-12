package demo3;


class Runner implements Runnable
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
				e.printStackTrace();
				
			}
		}
	}
}
public class AppRunnableOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Thread(new Runner());
		Thread t2=new Thread(new Runner());
		t1.start();
		t2.start();

	}

}
