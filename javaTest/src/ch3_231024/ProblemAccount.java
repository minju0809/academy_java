package ch3_231024;
// 19번
public class ProblemAccount {
	private final int min_balance = 0;
	private final int max_balance = 1000000;
	
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if (balance >= min_balance && balance <= max_balance) {
			this.balance += balance;
		}
	}

	public int getMin_balance() {
		return min_balance;
	}

	public int getMax_balance() {
		return max_balance;
	}
}
