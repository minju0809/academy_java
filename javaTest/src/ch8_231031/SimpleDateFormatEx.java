package ch8_231031;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx {

	public static void main(String[] args) {
		Date now = new Date();

		SimpleDateFormat sdf =  new SimpleDateFormat("오늘은 yyyy년 MM월 dd일 E요일 a HH시 mm분 ss초이고 올해의 D번째 날이며 이달의 d번째 날입니다.");
		System.out.println(sdf.format(now));

		SimpleDateFormat sdf2 = new SimpleDateFormat("D");
		String stringRemainDay = sdf2.format(now);
		int RemainDay = 365 - Integer.parseInt(stringRemainDay);
		System.out.println("올해의 남은 날: " + RemainDay + "일");
		
	}
}
