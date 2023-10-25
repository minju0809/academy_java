package ch4_201025;

public class ProblemChild extends ProblemParent {
//	public int studentNo;
//	
//	public ProblemChild(String name, int studentNo) {
//		// super("영심이"); // 2번
//		this.name = name;
//		this.studentNo = studentNo;
//	}
	
	public String name;
	
	public ProblemChild() {
		this("홍길동");
		System.out.println("Child() call");
	}
	
	public ProblemChild(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
