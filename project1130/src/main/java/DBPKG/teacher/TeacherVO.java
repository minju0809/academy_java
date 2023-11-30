package DBPKG.teacher;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TeacherVO {
	String teacher_code;
	String teacher_name;
	String class_name;
	int class_price;
	String teacher_regist_date;
	int tuition;
}
