package deadLock;

public class Account {
	private int balance=1000;
	private void deposit(int amount)
	{
		balance+=amount;
		
	}
	public void withDraw(int amount)
	{
		balance-=amount;
	}
	public int getBalance()
	{
		return balance;
	}
	public static void transfer(Account acc1,Account acc2,int amount)
	{
		acc1.withDraw(amount);
		acc2.deposit(amount);
	}

}
