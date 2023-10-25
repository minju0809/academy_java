package ch4_201025;

public class ProblemParent {
	// 6번
//	public String name;
//	
//	public ProblemParent() {}; // 1번
//	
//	public ProblemParent(String name) {
//		this.name = name;
//	}
	
	// 7번
	public String nation;
	
	public ProblemParent() {
		this("대한민국");
		System.out.println("Parent() call");
	}
	
	public ProblemParent(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
