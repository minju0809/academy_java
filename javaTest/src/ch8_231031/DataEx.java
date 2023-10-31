package ch8_231031;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// 날짜, 시간 정보 포함 가능
import java.util.Date;

public class DataEx {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str1 = now.toString();
		String str2 = sdf.format(now);
		System.out.println("날짜: " + str1); // 날짜: Tue Oct 31 10:01:00 KST 2023
		System.out.println("sdf 날짜: " + str2);
		
		// 날짜 정보만 저장 가능
		java.sql.Date str3 = java.sql.Date.valueOf(str2);
		System.out.println("sql 날짜: " + str3);
		
		// 현재 시간 가져오기
		Instant nowK = Instant.now();
		// 가져온 현재 시간을 특정 존으로 변환
		ZoneId zoneId = ZoneId.of("Asia/Seoul");
		// 가져온 특정 존의 시간은 SQLDate로 변환
		ZonedDateTime zonedDateTime = nowK.atZone(zoneId);
		
		// ZonedDateTime에서 시, 분, 초 가져오기
		int hour = zonedDateTime.getHour();
		int minute = zonedDateTime.getMinute();
		int second = zonedDateTime.getSecond();
		
		Date sqlDate = java.sql.Date.valueOf(zonedDateTime.toLocalDate());
		System.out.println("zone 날짜: " + sqlDate + " "+ hour + ":"+ minute + ":"+ second);
	}
}
