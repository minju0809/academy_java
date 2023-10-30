package ch7_231030;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		
		Calendar nowC = Calendar.getInstance();
		int year = nowC.get(Calendar.YEAR);
		int month = nowC.get(Calendar.MONTH);
		int day = nowC.get(Calendar.DAY_OF_MONTH);
		System.out.println(year +"년 " + month+ "월 " + day + "일 ");
	}
}
