package ch3_231024;

public class Problem {
	public static void main(String[] args) {
//		// 14번
//		ProblemMember m = new ProblemMember("홍길동", "hong");

//		// 15번
//		ProblemMemberService memberService = new ProblemMemberService();
//		boolean result = memberService.login("hong", "12345");
//		if(result) {
//			System.out.println("로그인 되었습니다.");
//			memberService.logout("hong");
//		} else {
//			System.out.println("id 또는 password가 올바르지 않습니다.");
//		}

//		// 16번
//		ProblemPrinter printer = new ProblemPrinter();
//		printer.println(10);
//		printer.println(true);
//		printer.println(5.7);
//		printer.println("홍길동");
		
		// 19번
		ProblemAccount account = new ProblemAccount();
		
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());
		account.setBalance(20000);
		System.out.println("현재 잔고: " + account.getBalance());
		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance());
		account.setBalance(10000000);
		System.out.println("현재 잔고: " + account.getBalance());
	}
}
