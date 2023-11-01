package pkg;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
	public static void main(String[] args) {
		Set<String> li = new HashSet<>();
		li.add("A");
		li.add("B");
		li.add("C");
		li.add("A");
		li.add("B");
		li.add(null);
		li.add(null);
		
		li.remove("A"); // A 모두 삭제
		for(String m : li) {
			System.out.print(m + " "); // null B C 
		}
	}
}
