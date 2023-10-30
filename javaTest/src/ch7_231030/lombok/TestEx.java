package ch7_231030.lombok;

import java.io.IOException;

public class TestEx {
	public static void main(String[] args) throws IOException {
//		TestVO vo = new TestVO();
//		vo.setKor(100);
//		System.out.println("국어: "+vo.getKor());

		// System 클래스
		Boolean run = true;
		int keyValue = 0;

		while (run) {
			if (keyValue != 13 && keyValue != 10) {
				System.out.print("키 입력: ");
			}
			keyValue = System.in.read();

			if (keyValue == 13 || keyValue == 10) {
				continue;
			}
			System.out.println("keyValue:" + keyValue);
			if (keyValue == 97) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
		}

		// ChatGPT 방법
//		int keyValue = 0;
//
//		do {
//			if (keyValue != 13 && keyValue != 10) {
//				System.out.print("키 입력: ");
//			}
//			keyValue = System.in.read();
//			if (keyValue != 13 && keyValue != 10) {
//				System.out.println("keyValue: " + keyValue);
//			}
//		} while (keyValue != 97);
//
//		System.out.println("프로그램이 종료되었습니다.");
		
	}
}
