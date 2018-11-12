package demo3;

public class AppSynchronized {

	private int count = 0;

	public synchronized void increment()
	{
		count++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppSynchronized app = new AppSynchronized();
		app.doWork();

	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}

			}
		});
		t1.run();
		t2.run();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		System.out.println("count is "+count);
	}

}
