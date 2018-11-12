package demo3;

public class AppRunnable {

	public static void main(String[] args) {
	new Thread(new Runnable() {
		
		@Override
		public void run() {
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
	});

	}

}
