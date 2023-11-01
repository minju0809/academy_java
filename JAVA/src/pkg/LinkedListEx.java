package pkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
	public static void main(String[] args) {
//		List<String> li = new ArrayList<>();
		List<String> li = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i = 0; i<100000; i++) {
			li.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("걸린 시간: " + (endTime-startTime));
	}
}
