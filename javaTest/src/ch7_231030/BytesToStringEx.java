package ch7_231030;

import java.util.StringTokenizer;

public class BytesToStringEx {
	public static void main(String[] args) {
		String str1 = new String("ABC");
		System.out.println(str1);

		StringBuilder str2 = new StringBuilder("abc");
		str2.append("ABC");
		str2.append("def");
		System.out.println(str2);

		str2.insert(0, "insert");
		str2.delete(0, 0);
		System.out.println(str2);

		String data = "홍길동/하늘이/둘리";
		StringTokenizer strT = new StringTokenizer(data);
		while (strT.hasMoreTokens()) {
			String token = strT.nextToken();
			System.out.println(token);
		}

		String dataA = "홍길동/하늘이/둘리";
		String[] names = dataA.split("/");
		System.out.println("첫번째 값: " + names[0]);

		int count = 0;
		for (String r : names) {
			count++;
			if (count == names.length) {
				System.out.print(r + " ");
			} else {
				System.out.print(r + ",");
			}
		}
	}
}
