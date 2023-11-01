package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ThreadVectorEx {
	public static void main(String[] args) {
//		List<Board> li = new ArrayList<>(); // (비동기) 스레드 처리 되면서 데이터가 소실될 수 있음
		List<Board> li = new Vector<>(); // (동기) 멀티 스레드 환경에서는 안전하게 객체를 추가 또는 삭제할 수 있음
		
		Thread threadA = new Thread() {
			public void run() {
				System.out.println("===> [ AAA ]");
				for (int i = 1; i <= 10; i++) {
					System.out.println("===> aaaaa");
					li.add(new Board("A제목" + i, "A내용" + i, "A글쓴이" + i));
				}
			}
		};

		Thread threadB = new Thread() {
			public void run() {
				System.out.println("===> [ BBB ]");
				for (int i = 11; i <= 20; i++) {
					System.out.println("===> bbbbb");
					li.add(new Board("B제목" + i, "B내용" + i, "B글쓴이" + i));
				}
			}
		};

		Thread threadC = new Thread() {
			public void run() {
				System.out.println("===> [ CCC ]");
				for (int i = 21; i <= 30; i++) {
					System.out.println("===> ccccc");
					li.add(new Board("C제목" + i, "C내용" + i, "C글쓴이" + i));
				}
			}
		};

		System.out.println("-------------확인1-----------------");
		threadA.start();
		threadB.start();
		threadC.start();
		System.out.println("-------------확인2-----------------");

		try {
			System.out.println("-------------확인3-----------------");
			threadA.join(); // A를 뺀 나머지를 일시정지
			threadB.join();
			threadC.join();
		} catch (Exception e) {

		}
		
		for (Board m : li ) {
			System.out.println(m);
		}

		int size = li.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();
	}
}
