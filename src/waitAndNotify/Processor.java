package waitAndNotify;

import java.util.Scanner;

public class Processor {

	// üretim
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("producer threading running ");
			wait();
			System.out.println("resume ");
		}
	}

	// tüketim
	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("waiting for return key");
			scanner.nextLine();
			System.out.println("returned key pressed.");
			notify();
		}
	}
}
