package ch3_231024;
// 15번
public class ProblemMemberService {
	String id = "hong";
	String password = "12345";

	public boolean login(String id, String password) {
		boolean run = true;
		if (this.id.equals(id) && this.password.equals(password)) {
			run = true;
		} else {
			run = false;
		}
		return run;
	}

	public void logout(String id) {
//		this.id = id;
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}
