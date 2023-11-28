package board.comment;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO {
	private String idx;
	private String sname;
	private String title;
	private String content;
	private String postcode;
	private String address;
	private String detail_address;
	private String extra_address;
	private int cnt;
}

