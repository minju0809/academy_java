package ch4_201025;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		// 20번
		ProblemAccountVO vo = new ProblemAccountVO();

		Scanner scanner = new Scanner(System.in);
		boolean run = true;

		int select = 0;

		ProblemAccountVO[] accountArray = new ProblemAccountVO[100];

		String num = "";
		String name = "";
		int money = 0;
		int totalMoney = 0;

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");

			select = scanner.nextInt();
			scanner.nextLine();

			if (select == 1) {
				System.out.println("------");
				System.out.println("계좌생성");
				System.out.println("------");

				System.out.print("계좌번호: ");
				num = scanner.nextLine();
				System.out.print("계좌주: ");
				name = scanner.nextLine();
				System.out.print("초기입금액: ");
				money = scanner.nextInt();

				vo.setAccountNum(num);
				vo.setAccountName(name);
				vo.setAccountMoney(money);

//				for (int i = 0; i < accountArray.length; i++) {
//					if(accountArray[0] == null) {

					accountArray[0] = vo;
//					break;
//					}
//				}

				System.out.println("결과: 계좌가 생성되었습니다.");
//				System.out.println(vo.getAccountNum());

			} else if (select == 2) {
				System.out.println("------");
				System.out.println("계좌목록");
				System.out.println("------");
				for (int i = 0; i < accountArray.length; i++) {
					System.out.print(accountArray[i].getAccountNum() + " ");
					System.out.print(accountArray[i].getAccountName() + " ");
					System.out.println(accountArray[i].getAccountMoney() + " ");
				}
			} else if (select == 3) {
				System.out.println("------");
				System.out.println("예금");
				System.out.println("------");

				System.out.print("계좌번호: ");
				num = scanner.nextLine();
				System.out.print("예금액: ");
				money = scanner.nextInt();

				totalMoney = vo.getAccountMoney();
				totalMoney += money;
				vo.setAccountMoney(totalMoney);
				System.out.println(vo.getAccountMoney());
			} else if (select == 4) {
				System.out.println("------");
				System.out.println("출금");
				System.out.println("------");

				System.out.print("계좌번호: ");
				num = scanner.nextLine();
				System.out.print("출금액: ");
				money = scanner.nextInt();
				totalMoney = vo.getAccountMoney();
				totalMoney -= money;
				if (totalMoney < 0) {
					System.out.println("가지고 있는 금액보다 출금하려는 금액이 많습니다.");
				} else {
					vo.setAccountMoney(totalMoney);
					System.out.println(vo.getAccountMoney());
				}
			} else if (select == 5) {
				run = false;
				System.out.println("프로그램 종료");
			}

		}
		scanner.close();
		/////////////////////////////////////////////////////////////////////
		
		// 334페이지 문제6번.
		
	}

}
