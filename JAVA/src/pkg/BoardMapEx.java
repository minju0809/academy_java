package pkg;

import java.util.List;
import java.util.Map;

public class BoardMapEx {
	public static void main(String[] args) {
//		BoardMap service = new BoardMapImpl();
//			Map<String, Object> board = service.insert();
//			System.out.println("code: " + board.get("code"));
//			System.out.println("msg: " + board.get("msg"));
//			System.out.println("method: " + board.get("method"));
//			System.out.println("키 값 존재 유무: " + board.containsKey("msg"));
//			System.out.println("주어진 값 존재 유무: " + board.containsValue("성공"));
//			System.out.println("주어진 값 존재 유무: " + board.containsValue("성공2"));
//			System.out.println("저장된 키의 총 수: " + board.size());
//			
//			Map<String, String> board2 = service.login();
//			String id = "ppk";
//			String pwd = "1234";
//			if (board2.containsKey(id)) {
//				if (board2.get(id).equals(pwd)) {
//					System.out.println("로그인 성공");
//				} else {
//					System.out.println("비밀번호 확인");
//				}
//			} else {
//				System.out.println("아이디 확인");
//			}

		BoardMap service = new BoardMapImpl();

		MapVo1 board = service.insert();
		System.out.println("code: " + board.getCode());
		System.out.println("msg: " + board.getMsg());
		System.out.println("method: " + board.getMethod());

		String id = "kang";
		String pwd = "1111";

		List<MapVo2> service2 = service.login();

		String S = "";
		String Sid = "";
		for (MapVo2 m : service2) {
			if (m.getId().equals(id)) {
				if (m.getPwd().equals(pwd)) {
					Sid = m.getId();
					S = "T";
				}
			}
			System.out.println("id: " + m.getId() + ", pwd: " + m.getPwd());
		}
		if (S.equals("T")) {
			System.out.println(Sid + " 로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
}
