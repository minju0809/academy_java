package DBPKG.guestbook;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GuestbookVO {
	int idx;
	String name;
	String title;
	String content;
	int count;
	
	String ch1;
	String ch2;
	
	int start;
	int pageSize;
}
