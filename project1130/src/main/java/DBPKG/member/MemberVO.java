package DBPKG.member;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberVO {
	String regist_month;
	String c_no;
	String c_name;
	String class_name;
	String class_area;
	int tuition;
	String grade;
	
	String phone;
	String address;
}
