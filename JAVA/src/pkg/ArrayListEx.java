package pkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayListEx {
	public static void main(String[] args) {
//		List<Board> li = new ArrayList<>();
//		List<Board> li = new Vector<>();
		List<Board> li = new LinkedList<>();

		Board m = null;

		long startTime;
		long endTime;

		startTime = System.nanoTime();
		for (int i = 1; i <= 100000; i++) {
//			li.add(new Board("제목" +i,"내용"+i,"글쓴이"+i)); // 생성자로 추가

			m = new Board();
			m.setSubject("제목" + i);
			m.setContent("내용" + i);
			m.setWriter("글쓴이" + i);
			li.add(0, m);
		}
		endTime = System.nanoTime();
		System.out.println("소요시간: " + (endTime - startTime));

//		int size = li.size();
//		System.out.println("총 레코드 수: " + size);

//		m = li.get(2); // 인덱스 번호의 레코드 찾기
//		System.out.println("세 번째 레코드: " + m);

//		li.remove(0); // 인덱스 번호 삭제
//		li.remove(0);

//		m = li.get(2); // 인덱스 번호의 레코드 찾기
//		System.out.println("세 번째 레코드: " + m);

//		size = li.size();
//		System.out.println("삭제 후 총 레코드 수: " + size);

	}
}
