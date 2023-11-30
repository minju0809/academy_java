package DBPKG.member;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClassVO {
	String regist_month;
	String c_no;
	String class_area;
	int tuition;
	String teacher_code;
}
