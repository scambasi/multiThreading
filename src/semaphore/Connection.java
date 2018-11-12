package semaphore;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection instance = new Connection();
	private int connection = 0;
	private Semaphore sem = new Semaphore(10);

	private Connection() {
	}

	public static Connection getInstance() {
		return instance;
	}

	public static void setInstance(Connection instance) {
		Connection.instance = instance;
	}

	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		doConnect();
		sem.release();
	}
	public void doConnect()
	{
synchronized (this) {
			
			connection++;
			System.out.println("Current Connection" + connection);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			synchronized (this) {
				connection--;
			}
		}
	}
}
