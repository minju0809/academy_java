package ch6_231027;

public class Account {
	private long balance;

//	public Account() {};

	public long getBalance() {
		return balance;
	}

	public void deposit(int money) {
		balance += money;
	}

	public void withdraw(int money) throws InsufficientException {
		if (balance < money) {
			throw new InsufficientException("잔고 부족: " + (money - balance) + " 모자람");
		} else {
			balance -= money;
			System.out.println("현재 잔액: " + balance);
		}
	}
}
