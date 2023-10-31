package ch8_231031;

// 확인문제 6번
public class ProblemMember {
	private String id;
	private String name;

	public ProblemMember(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ": " + name;
	}
}
