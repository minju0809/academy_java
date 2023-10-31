package ch8_231031;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONDAY) + 1;
		int date = cal.get(Calendar.DATE);
		int dateOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String[] weekArr = { "일", "월", "화", "수", "목", "금", "토" };

		// 삼항연산자
		String dayOfWeekStr = dateOfWeek >= 1 && dateOfWeek <= 7 ? weekArr[dateOfWeek - 1] : "유효하지 않은 요일";

		// 배열
//		String dayOfWeekStr = weekArr[dateOfWeek-1]; 

		// switch문
//		String strWeek = null;
//		switch (dateOfWeek) {
//		case Calendar.MONDAY:
//			strWeek = "월";
//			break;
//		case Calendar.TUESDAY:
//			strWeek = "화";
//			break;
//		case Calendar.WEDNESDAY:
//			strWeek = "수";
//			break;
//		case Calendar.THURSDAY:
//			strWeek = "목";
//			break;
//		case Calendar.FRIDAY:
//			strWeek = "금";
//			break;
//		case Calendar.SATURDAY:
//			strWeek = "토";
//			break;
//		default:
//			strWeek = "일";
//		}
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		String dayStr = year + "년 " + month + "월 " + date + "일 " + dayOfWeekStr + "요일 ";
		System.out.println(dayStr);
		String timeStr = hour + "시 " + minute + "분 " + second + "초 ";
		System.out.println(timeStr);
	}
}
