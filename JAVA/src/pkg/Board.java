package pkg;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Getter, Setter 등 추가
@AllArgsConstructor // 생성자 추가
public class Board {
	private String subject;
	private String content;
	private String writer;

	public Board() {
	}

//	public Board(String subject, String content, String writer) {
//		this.subject = subject;
//		this.content = content;
//		this.writer = writer;
//	}
	
	
}
